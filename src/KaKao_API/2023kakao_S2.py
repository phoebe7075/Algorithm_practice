import requests
import json
baseUrl = "https://68ecj67379.execute-api.ap-northeast-2.amazonaws.com/api/"
key = ""
start_header= {'Content-Type':'application/json; charset=utf-8', 'X-Auth-Token':'2bc060df43d63643ac125a9f2fe6639d'}
header = {'Content-Type':'application/json; charset=utf-8',"Authorization":key}



class Node:
    def __init__(self, data):
        self.data = data
        self.next = None
class SLL:
    def __init__(self, data):
        new_node = Node(data)
        self.head = new_node
        self.list_size = 1

    def canReservation(self, data):
        node = self.head

        while(node != None):
            if(node.data[0] <= data[1] <= node.data[1] or node.data[0] <= data[0] <= node.data[1] or (node.data[0] > data[0] and node.data[1] < data[1])):
                return False
            node = node.next

        return True
    
    def reservation(self, data):
        node = self.head
   
        prev = None
        while(node != None):
            if(node.data[0] >= data[1]):
                break
            prev = node
            node = node.next
        if(node == None):
            new_node = Node(data)
            prev.next = new_node
        else:
            new_node = Node(data)
            prev.next = new_node
            new_node.next = node
            
    def checkout(self, time):
        node = self.head
        if(self.list_size > 2):
            abc = 1
        if(node.data[1] == time):
            self.head = node.next
            return
        prev = None
        while(node != None):
            if(node.data[1] == time):
                break
            prev = node
            node = node.next
        if(node == None):
            return
        prev.next = node.next
        node = None
            
            
    def checkin(self, time):
        node = self.head
        node = node.next
        if(node == None):
            return None
        
        if(node.data[0] == time):
            return node.data
        
        return None
    
    def print(self):
        if(self.head.next != None):
            return self.head.next.data[2]
        else:
            return 0
            
        
width = 200
height = 10
room_list = [[SLL([0,0]) for col in range(width)] for row in range(height)]
reserve_list = []

def start():
    resp = requests.post(baseUrl+"start", headers=start_header, data=json.dumps({'problem' :2}))

    key = resp.json()["auth_key"]
    print(key)
    header["Authorization"] = key
    return resp


def getNewRequset():
    resp = requests.get(baseUrl+"new_requests", headers=header)
    
    return resp.json()["reservations_info"]

def getScore():
    resp = requests.get(baseUrl+"score", headers=header)
    
    return resp.json()


def sendReply(replys):
    data = {"replies": replys}
    
    resp = requests.put(baseUrl+"reply", headers=header, data=json.dumps(data))
    
    return resp

def sendSimulation(simulate):
    data = {"room_assign": simulate}
    
    resp = requests.put(baseUrl+"simulate", headers=header, data=json.dumps(data))
    
    return resp


def requestScheduling(req):
    global reserve_list, room_list
    reply_command = []
    for request in req:
        command = {}
        checkinDate = request["check_in_date"]
        checkoutDate = request["check_out_date"]
        amount = request["amount"]
        uid = request["id"]
        res = searchRoom(amount, [checkinDate, checkoutDate])
        if (res[0] != -1):
            for i in range(res[1], res[1]+amount):
                room_list[res[0]][i].reservation([checkinDate, checkoutDate, uid, amount])
            command = {"id":uid, "reply":"accepted"}
        else:
            command = {"id":uid, "reply":"refused"}
            
        reply_command.append(command)
            
    return reply_command
            
        
def searchRoom(amount, checkDate):
    global room_list
    count = 0
    for i in range(height):
            for j in range(width):
                count = 0
                if room_list[i][j].canReservation(checkDate):
                    count = 1
                    for k in range(j+1, min(width,j+amount)):
                        if(not room_list[i][k].canReservation(checkDate)):
                            j = k
                            break
                        else:
                            count+=1
                    if(count == amount):
                        return [i,j]
    return [-1, -1]


def simulating(time):
    global room_list, reserve_list
    
    command = []
    already_add_list = []
    for i in range(height):
        for j in range(width):
            res = room_list[i][j].checkin(time)
            if (res != None):
                if(res[2] not in already_add_list):
                    command.append({"id":res[2],"room_number": (((i+1)*1000)+j+1)})
                    already_add_list.append(res[2])
            
    return command
                    
                        
def roomClearing(time):
    global room_list
    
    for i in range(height):
            for j in range(width):
                room_list[i][j].checkout(time)
                

def printing():
    global room_list
    
    for i in range(height):
        tmparr = []
        for j in range(width):
            tmparr.append(room_list[i][j].print())
        print(tmparr)
        

if __name__ == "__main__":
    start()
    time = 1
    while(time <= 1000):
        response = getNewRequset()
        sendReply(requestScheduling(response))
        roomClearing(time)
        command = simulating(time)
        res = sendSimulation(command)
        time += 1
        print(res.json())
    print(getScore())