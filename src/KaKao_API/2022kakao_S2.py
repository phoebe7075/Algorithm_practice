import requests
import random
import json

baseUrl = "https://huqeyhi95c.execute-api.ap-northeast-2.amazonaws.com/prod/"
key = ""
start_header= {'Content-Type':'application/json; charset=utf-8', 'X-Auth-Token':'2a40503ff7a51abdc86536712476bd1d'}
header = {'Content-Type':'application/json; charset=utf-8',"Authorization":key}

# 직접 조절 변수

# 시나리오 2
start_grade = 4000
Fixed_point = 100
Fixed_Gap = 90

user_list = [start_grade for i in range(901)]
wait_list = []
abuse_list = [0 for i in range(901)]
user_streak_rate = [1 for i in range(901)]
user_match_count = [0 for i in range(901)]

def start():
    resp = requests.post(baseUrl+"start", headers=start_header, params={'problem' : '2'})

    key = resp.json()["auth_key"]
    print(key)
    header["Authorization"] = key
    return resp

    
def getWaitingLine(time):
    global wait_list
    wait_list = []
    resp = requests.get(baseUrl+"waiting_line", headers = header)
    
    for wait in resp.json()["waiting_line"]:
        wait_list.append([time-int(wait["from"]), int(wait["id"])])
    
    wait_list.sort(reverse=True, key=lambda x : x[0])
    return resp

def getGameResult():
    resp = requests.get(baseUrl+"game_result", headers=header)
    
    return resp.json()["game_result"]

def getUserInfo():
    resp = requests.get(baseUrl+"user_info", headers=header)
    
    return resp.json()

def getScore():
    resp = requests.get(baseUrl+"score", headers=header)
    
    return resp.json()


def changeGrade(results):
    global user_list, abuse_list, user_match_count, user_streak_rate
    for res in results:
        win_id = int(res["win"])
        lose_id = int(res["lose"])
        taken_time = int(res["taken"])
        is_loser_abuse = False
        if user_match_count[lose_id] > 8:
            is_loser_abuse = int(abuse_list[lose_id]/user_match_count[lose_id]*100) > 70 and taken_time <= 10
        is_winner_abuse = False
        if user_match_count[win_id] > 8:
            is_winner_abuse = int((abuse_list[win_id]/user_match_count[win_id])*100) > 70
        
        gain_point = Fixed_point * int(40/taken_time)
        win_point = gain_point + random.randrange(-int(gain_point/5), int(gain_point/5))
        lose_point = gain_point + random.randrange(-int(gain_point/5), int(gain_point/5))
        user_match_count[win_id] += 1
        user_match_count[lose_id] += 1
        if not is_loser_abuse and not is_winner_abuse : # 둘다 일반유저로 판단될 경우.
           
            if(user_list[win_id] - user_list[lose_id] < 0): # 진 유저가 어뷰징을 한 것으로 판단될때 1
                abuse_list[lose_id] += 1
            elif(taken_time <= 10): ## 진 유저가 어뷰징을 한 것으로 판단될때 2
                abuse_list[lose_id] += 1
            
            win_point = int(win_point*user_streak_rate[win_id]) # 연속으로 이긴 회수만큼 배수로 승점을 더 준다.
            user_streak_rate[win_id] += 0.1
            user_streak_rate[lose_id] = 1
            
            user_list[win_id] = min(user_list[win_id] + win_point, 9999)
            user_list[lose_id] = max(user_list[lose_id] - lose_point, 0)
            
        elif is_loser_abuse and not is_winner_abuse: # 진 유저가 어뷰징 유저고 이긴 유저는 일반 유저인 경우
            abuse_list[lose_id] += 1
            
            
            win_point = int(win_point*user_streak_rate[lose_id])
            user_streak_rate[lose_id] += 0.1
            user_streak_rate[win_id] = 1
            
            user_list[lose_id] = min(user_list[lose_id] + win_point, 9999) # 어뷰저의 점수를 올림
            user_list[win_id] = max(user_list[win_id] - (Fixed_point * int(40/23)), 0) #이긴유저의 점수를 떨군다
        elif not is_loser_abuse and is_winner_abuse: # 이긴 유저가 어뷰징 유저고 진 유저는 일반 유저일 경우
            abuse_list[win_id] += 1
            
            win_point = int(win_point*user_streak_rate[win_id]) # 연속으로 이긴 회수만큼 배수로 승점을 더 준다.
            user_streak_rate[win_id] += 0.1
            user_streak_rate[lose_id] = 1
            
            user_list[win_id] = min(user_list[win_id] + win_point, 9999)
            user_list[lose_id] = max(user_list[lose_id] - lose_point, 0)
        else : # 둘 다 어뷰저일때
            abuse_list[lose_id] += 1
            abuse_list[win_id] += 1
            
            if taken_time <= 10 : #높은 실력을 가진 어뷰저가 졌을 경우
                win_point = int(win_point*user_streak_rate[lose_id])
                user_streak_rate[lose_id] += 0.1
                user_streak_rate[win_id] = 1
                
                user_list[lose_id] = min(user_list[lose_id] + win_point, 9999) # 진 어뷰저의 점수를 올림
                user_list[win_id] = max(user_list[win_id] - lose_point, 0) # 이긴 어뷰저의 점수를 떨군다
            else: # 20% 확률로 정상게임을 했을 경우
                win_point = int(win_point*user_streak_rate[win_id])
                user_streak_rate[win_id] += 0.1
                user_streak_rate[lose_id] = 1
                
                user_list[win_id] = min(user_list[win_id] + win_point, 9999)
                user_list[lose_id] = max(user_list[lose_id] - lose_point, 0)
        
    
def is_Abuser(uid: int):
    global abuse_list, user_match_count
    
    if(user_match_count[uid] > 8):
        if int((abuse_list[uid]/user_match_count[uid])*100) > 70:
            return True

    return False 
        

def matching():
    global wait_list
    command = []
    for i in range(len(wait_list)):
        if wait_list[i][1] == -1:
            continue
        match = [0, 0]
        match[0] = wait_list[i][1]
        wait_list[i][1] = -1
        
        if(is_Abuser(wait_list[i][1])): # 어뷰저일 경우 가장 근접한 차이의 어뷰저와 매칭이 될 때까지 대기를 시키고, 없으면 매칭이 취소될때까지 매칭을 하지 않음.
            minGap = 9999
            minIdx = -1
            
            for j in range(i+1, len(wait_list)):
                if(wait_list[j][1] != -1 and is_Abuser(wait_list[j][1])):
                    if(minGap > abs(user_list[match[0]]-user_list[j])):
                        minGap = abs(user_list[match[0]]-user_list[j])
                        minIdx = j
            
            if(minGap > Fixed_Gap*2 and minIdx != -1):
                continue
            
            match[1] = wait_list[minIdx][1]
            wait_list[minIdx][1] = -1
            command.append(match)
            continue
        
        
        if(wait_list[i][0] > 14):
            if(user_list[match[0]] == start_grade):
                for j in range(i+1, len(wait_list)):
                    if(wait_list[j][1] != -1 and not is_Abuser(wait_list[j][1])):
                        match[1] = wait_list[j][1]
                        wait_list[j][1] = -1
                        break
            else:
                minGap = 9999
                minIdx = -1
                closeIdx = -1
                
                for j in range(i+1, len(wait_list)):
                    if(wait_list[j][1] != -1 and not is_Abuser(wait_list[j][1])):
                        if(closeIdx == -1):
                            closeIdx = j
                        if(user_list[j] == start_grade):
                            continue
                        
                        if(minGap > abs(user_list[match[0]]-user_list[j])):
                            minGap = abs(user_list[match[0]]-user_list[j])
                            minIdx = j
                if(minGap > Fixed_Gap):
                    match[1] = wait_list[closeIdx][1]
                    wait_list[closeIdx][1] = -1
                else:
                    match[1] = wait_list[minIdx][1]
                    wait_list[minIdx][1] = -1
        else:
            minGap = 9999
            minIdx = -1
            for j in range(i+1, len(wait_list)):
                if(wait_list[j][1] != -1 and not is_Abuser(wait_list[j][1])):
                    if(user_list[j] == start_grade):
                        continue
                    if(minGap > abs(user_list[match[0]]-user_list[j])):
                        minGap = abs(user_list[match[0]]-user_list[j])
                        minIdx = j
            if(minIdx == -1): #대기열에 있는 유저중 아무도 매치를 해보지않았을 때 i 다음번째로 기다린 유저와 매치를 진행.
                for j in range(i+1, len(wait_list)):
                    if(wait_list[j][1] != -1 and not is_Abuser(wait_list[j][1])):
                        match[1] = wait_list[j][1]
                        wait_list[j][1] = -1
                        break
            elif(minGap <= Fixed_Gap): #대기열 유저중에 내 수준과 비슷한 유저가 있을 때만 가장 비슷한 유저와 매치.
                match[1] = wait_list[minIdx][1]
                wait_list[minIdx][1] = -1
        if match[0] != 0 and match[1] != 0: 
            command.append(match)
    return command


def send_match(matchs):
    data = {"pairs":matchs}
    resp = requests.put(baseUrl+"match", headers=header, data=json.dumps(data))
    
    return resp

def send_Grade():
    global user_list
    command = []
    
    for i in range(1,len(user_list)):
        command.append({"id":i, "grade":user_list[i]})
        
    data = {"commands":command}
    
    resp = requests.put(baseUrl+"change_grade", headers=header, data=json.dumps(data))
    return resp


if __name__ == "__main__":
    start()
    send_match([])
    time = 1
    while(True):
        changeGrade(getGameResult())
        getWaitingLine(time)
        res = send_match(matching())
        print(res.json())
        if(len(res.json()) == 1):
            continue
        time+=1
        if(res.json()["time"] == 594):
            send_Grade()
            print(getUserInfo())
        elif(res.json()["status"] == "finished"):
            break
    
    print(getScore())
    
            
        
        
        
        
        
        