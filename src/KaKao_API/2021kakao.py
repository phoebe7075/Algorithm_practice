from symbol import parameters
import requests
import random
import json

baseUrl = "https://kox947ka1a.execute-api.ap-northeast-2.amazonaws.com/prod/users/"
key = ""
start_header= {'Content-Type':'application/json; charset=utf-8', 'X-Auth-Token':'18132fa5f8f9f2470a4a7ae8ab9440c1'}
header = {'Content-Type':'application/json; charset=utf-8',"Authorization":key}

arr = [[0 for col in range(5)] for row in range(5)]
trucks = []
over = []
low = []
empties = [0 for i in range(25)]


def getLocations():
    global over, low, empties, arr
    over = []
    low = []
    empties = []
    
    resp = requests.get(baseUrl+"locations", headers=header)
    
    for loc in resp.json()["locations"]:
        arr[4-loc["id"]%5][int(loc["id"]/5)] = loc["located_bikes_count"]
        if loc["located_bikes_count"] >= 3:
            over.append(loc["id"])
        elif loc["located_bikes_count"] <= 1:
            low.append(loc["id"])
    return resp

def getTrucks():
    resp = requests.get(baseUrl+"trucks", headers= header)
    return resp

def simulation(simulate):
    data = {'commands':simulate}
    resp = requests.put(baseUrl+"simulate", headers=header, data=json.dumps(data))
    return resp

def score():
    resp = requests.get(baseUrl+"score", headers=header)
    return resp

def setting():
    commands = []
    commands.append({"truck_id":0, "command":[1,1]})
    commands.append({"truck_id":1, "command":[2,1,1]})
    commands.append({"truck_id":2, "command":[2,2,1,1]})
    commands.append({"truck_id":3, "command":[2,2,2,1,1]})
    commands.append({"truck_id":4, "command":[2,2,2,2,1,1]})
    
    return commands

def moving(fr, to):
    minDist = 99999
    minID = -1
    minLocation = -1
    minDist2 = 99999
    minID2 = -1
    minLocation2 = -1
    bikecount = 0
    for truck in trucks:
        if(truck["id"] == -1):
            continue
        distance1 = getDist(truck["location_id"], fr)
        distance2 = getDist(truck["location_id"], to)
        distance3 = getDist(fr, to)
        if(minDist > distance1+distance3):
            minID = truck["id"]
            minLocation = truck["location_id"]
            minDist = distance1+distance3
        if(minDist2 > distance2 & truck["loaded_bikes_count"] > 0):
            minID2 = truck["id"]
            minLocation2 = truck["location_id"]
            minDist2 = distance2
            bikecount = truck["loaded_bikes_count"]
    
    
    
    command = []
    
    if minID == -1:
        return None
    # ret = {}
    # if minID2 != -1 and minDist >= minDist2:
    #     command = bfs(minLocation2, to) + [6]
    #     if(len(command) > 10):
    #         command[9] = 6
    #     ret = {"truck_id":minID2, "command":command}
    #     for truck in trucks:
    #         if truck["id"] == minID2:
    #             truck["id"] = -1
    # else:
    #     if minDist > 7:
    #         command = bfs(minLocation, fr) + [5] + bfs(fr, to) + [6]
    #         if(len(command) > 10):
    #             command[9] = 6
    #     else:
    #         command = bfs(minLocation, fr)
    #         for i in range(min(int(arr[4-(fr%5)][int(fr/5)]-2), 9-minDist)):
    #             command += [5]
    #         command += bfs(fr, to) + [6]
        
            
    #     ret = {"truck_id":minID, "command":command}
    #     for truck in trucks:
    #         if truck["id"] == minID:
    #             truck["id"] = -1
    command = bfs(minLocation, fr) + [5] + bfs(fr, to) + [6]
    if(len(command) > 10):
        command[9] = 6
    ret = {"truck_id":minID, "command":command}
    for truck in trucks:
        if truck["id"] == minID:
            truck["id"] = -1
    return ret


def bfs(fr, to):
    command = []
    
    while fr != to:
        if (4-fr%5) < (4-to%5):
            command.append(3)
            fr -= 1
        elif (4-fr%5) > (4-to%5):
            command.append(1)
            fr += 1
        elif int(fr/5) < int(to/5):
            command.append(2)
            fr += 5
        elif int(fr/5) > int(to/5):
            command.append(4)
            fr -= 5
        else:
            break
    return command

def getDist(fr, to):
    return abs((4-fr%5) - (4-to%5)) + abs(int(fr/5) - int(to/5))


def start():
    resp = requests.post(baseUrl+"start", headers=start_header, params={'problem' : '1'})

    key = resp.json()["auth_key"]
    print(key)
    header["Authorization"] = key
    return resp

def Trucks_Set(list):
    global trucks
    trucks = []
    for truck in list["trucks"]:
        trucks.append({"id":truck["id"], "location_id":truck["location_id"], "loaded_bikes_count":truck["loaded_bikes_count"]})
        
def scoring(fail_count, dist):
    return round(((1428-fail_count)-1077) / (351) * 100, 1)* 0.95 + round((3600-dist)/3600*100,1) * 0.05

def getScore():
    resp = requests.get(baseUrl+"score", headers=header)
    return resp

if __name__ == "__main__":
    
    start()
    simulation(setting())
    while(True):
        command = []
        
        getLocations()
        Trucks_Set(getTrucks().json())
        if len(low) > 0:
            random.shuffle(low)
            for i in range(min(len(low), 5)):
                minId = -1
                minDist = 99999
                for x in over:
                    tmpDist = getDist(low[i], x)
                    
                    if(minDist > tmpDist):
                        minId = x
                        minDist = tmpDist
                command.append(moving(minId, low[i]))
            
        res = simulation(command).json()
        print(res)
        if res["status"] == "finished":
            print("%0.1f"%float(scoring(int(float(res["failed_requests_count"])), float(res["distance"]))))
            break
        