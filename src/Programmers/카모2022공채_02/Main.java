package Programmers.카모2022공채_02;

/*
입력값 〉
["A B C D", "A D", "A B D", "B D"], 2
기댓값 〉
7

입력값 〉
["JAY", "JAY ELLE JAY MAY", "MAY ELLE MAY", "ELLE MAY", "ELLE ELLE ELLE", "MAY"], 3
기댓값 〉
8



 */






import java.util.*;

class Solution {
    public int solution(String[] id_list, int k) {
        HashMap<String, Integer> user_coupon_list = new HashMap<>();
        

        for(String x : id_list){
            HashMap<String, Integer> user_duple_check = new HashMap<>();
            String[] tmp = x.split(" ");

            for(String user : tmp) {
                user_duple_check.put(user, 0);
            }
            
            for(String user : user_duple_check.keySet()){
                if(user_coupon_list.getOrDefault(user, 0) == 0) {
                    user_coupon_list.put(user, 1);
                }else {
                    int cnum = user_coupon_list.get(user);
                    user_coupon_list.put(user, Math.min(cnum+1, k));
                }
            }
        }

        int answer = 0;

        for(String user : user_coupon_list.keySet()){
            answer+= user_coupon_list.get(user);
        }

        return answer;
    }
}