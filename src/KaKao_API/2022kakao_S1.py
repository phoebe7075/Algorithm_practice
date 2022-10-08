import requests
import random
import json

baseUrl = "https://huqeyhi95c.execute-api.ap-northeast-2.amazonaws.com/prod/"
key = ""
start_header= {'Content-Type':'application/json; charset=utf-8', 'X-Auth-Token':'1d1c113a9d4cc780e68d1fe6f221e388'}
header = {'Content-Type':'application/json; charset=utf-8',"Authorization":key}

# 직접 조절 변수

# Scenario 1
# Fixed_point = 700
# Fixed_Gap = 80
# {'status': 'finished', 'efficiency_score': '90.2168', 'accuracy_score1': '69.3333', 'accuracy_score2': '58.1192', 'score': '225.1165'}


# 시나리오 1
start_grade = 4000
Fixed_point = 700
Fixed_Gap = 80

user_list = [start_grade for i in range(31)]
wait_list = []



def start():
    resp = requests.post(baseUrl+"start", headers=start_header, params={'problem' : '1'})

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
    global user_list
    for res in results:
        win_id = int(res["win"])
        lose_id = int(res["lose"])
        taken_time = int(res["taken"])
        gain_point = int(Fixed_point/taken_time/2)
        win_point = gain_point + random.randrange(-int(gain_point/5), int(gain_point/5))
        lose_point = gain_point + random.randrange(-int(gain_point/5), int(gain_point/5))
        user_list[win_id] = min(user_list[win_id] + win_point, 9999)
        user_list[lose_id] = max(user_list[lose_id] - lose_point, 0)
    
    
        

def matching():
    global wait_list
    command = []
    for i in range(len(wait_list)):
        if wait_list[i][1] == -1:
            continue
        match = [0, 0]
        match[0] = wait_list[i][1]
        wait_list[i][1] = -1
        if(wait_list[i][0] > 14):
            if(user_list[match[0]] == start_grade):
                for j in range(i+1, len(wait_list)):
                    if(wait_list[j][1] != -1):
                        match[1] = wait_list[j][1]
                        wait_list[j][1] = -1
                        break
            else:
                minGap = 9999
                minIdx = -1
                closeIdx = -1
                
                for j in range(i+1, len(wait_list)):
                    if(wait_list[j][1] != -1):
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
                if(wait_list[j][1] != -1):
                    if(user_list[j] == start_grade):
                        continue
                    if(minGap > abs(user_list[match[0]]-user_list[j])):
                        minGap = abs(user_list[match[0]]-user_list[j])
                        minIdx = j
            if(minIdx == -1): #대기열에 있는 유저중 아무도 매치를 해보지않았을 때 i 다음번째로 기다린 유저와 매치를 진행.
                for j in range(i+1, len(wait_list)):
                    if(wait_list[j][1] != -1):
                        match[1] = wait_list[j][1]
                        wait_list[j][1] = -1
                        break
            elif(minGap <= Fixed_Gap): #대기열 유저중에 내 수준과 비슷한 유저가 있을 때만 가장 비슷한 유저와 매치.
                match[1] = wait_list[minIdx][1]
                wait_list[minIdx][1] = -1
        if match[0] != 0 and match[0] != 0: 
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
    
            
        
        
        
        
        
        