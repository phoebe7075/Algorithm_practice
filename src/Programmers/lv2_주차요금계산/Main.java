package Programmers.lv2_주차요금계산;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new int[]{180, 5000, 10, 600}, new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"});
    }
}

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer;
        Map<String, Integer>map = new HashMap<>();
        Map<String, Integer>result = new TreeMap<>();
        for(String x : records) {
            String[] tmp = x.split(" ");
            String[] time = tmp[0].split(":");
            int t = Integer.parseInt(time[0])*60 + Integer.parseInt(time[1]);
            if(tmp[2].equals("IN")) {
                map.put(tmp[1],t);
            }else {
                int intime = map.get(tmp[1]);
                if(result.getOrDefault(tmp[1],-1) == -1) {
                    result.put(tmp[1],t-intime);
                }else {
                    result.put(tmp[1],result.get(tmp[1]) + (t-intime));
                }
                map.remove(tmp[1]);
            }
        }


        for(String x : map.keySet()) {
            int intime = map.get(x);

            if(result.getOrDefault(x,-1) == -1) {
                result.put(x,1439-intime);
            }else {
                result.put(x,result.get(x) + (1439-intime));
            }
        }
        answer = new int[result.size()];
        int idx = 0;
        for(String x : result.keySet()) {
            int t = result.get(x);
            answer[idx] = fees[1];
            if(t > fees[0]) {
                t = t-fees[0];

                if(t % fees[2] != 0) {
                    answer[idx] += ((t/fees[2])+1) * fees[3];
                }else {
                    answer[idx] += (t/fees[2]) * fees[3];
                }
            }
            idx++;
        }


        return answer;
    }
}