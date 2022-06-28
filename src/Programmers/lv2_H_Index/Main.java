package Programmers.lv2_H_Index;
import java.util.*;
public class Main {
}

class Solution {
    public int solution(int[] citations) {
        int answer = 0;

        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0; i<citations.length; i++) {
            list.add(citations[i]);
        }

        Collections.sort(list, Collections.reverseOrder());

        int idx = list.get(0) > citations.length ? citations.length : list.get(0);
        for(int i=idx; i>0; i--) {
            int tmp = 0;
            for(int j=0; j<i; j++) {
                if(list.get(j) >= i) {
                    tmp++;
                }
            }
            if(tmp >= i) {
                return i;
            }
        }
        return answer;
    }
}