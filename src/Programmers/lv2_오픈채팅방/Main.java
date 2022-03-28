package Programmers.lv2_오픈채팅방;
import java.util.*;
public class Main {
}

class Solution {
    public String[] solution(String[] record) {

        ArrayList<String> arr = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        String s[];
        for(String x : record) {
            s = x.split(" ");

            if(s[0].equals("Enter")) {
                arr.add("1 " + s[1]);
                map.put(s[1],s[2]);
            }else if (s[0].equals("Leave")) {
                arr.add("2 " + s[1]);
            }else if (s[0].equals("Change")){
                map.put(s[1],s[2]);
            }
        }
        int idx = 0;
        String[] answer = new String[arr.size()];
        for(String x : arr) {
            s = x.split(" ");
            answer[idx] = "";
            if(s[0].equals("1")) {
                answer[idx] = (map.get(s[1]) + "님이 들어왔습니다.");
            }else if (s[0].equals("2")) {
                answer[idx] = (map.get(s[1]) + "님이 나갔습니다.");
            }
            idx++;
        }
        return answer;
    }
}