package Programmers.lv1_신고결과_받기;
import java.util.*;
public class Main {
}
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        int[] count = new int[id_list.length];
        boolean[][] check = new boolean[id_list.length][id_list.length];
        Map<String, Integer> map = new HashMap<>();
        ArrayList<String> list[] = new ArrayList[id_list.length];




        for(int i=0; i<id_list.length; i++) {
            map.put(id_list[i],i);
            list[i] = new ArrayList<>();
        }


        for(String x : report) {
            String[] tmp = x.split(" ");
            int reporter = map.get(tmp[0]);
            int defendant = map.get(tmp[1]);

            if(!check[reporter][defendant]) {
                count[defendant]++;
                check[reporter][defendant] = true;
                list[reporter].add(tmp[1]);
            }
        }


        for(int i=0; i<list.length; i++) {
            for(String x : list[i]) {
                int tmp = map.get(x);

                if(count[tmp] >= k) {
                    answer[i]++;
                }
            }
        }


        return answer;
    }
}