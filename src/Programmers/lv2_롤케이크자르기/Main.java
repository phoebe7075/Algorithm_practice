package Programmers.lv2_롤케이크자르기;
import java.util.*;
public class Main {
    
}


class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        HashSet<Integer> setA = new HashSet<>();
        HashSet<Integer> setB = new HashSet<>();
        int count[] = new int[10001];
        for(int i=0; i<topping.length; i++) {
            count[topping[i]]++;
            if(count[topping[i]] == 1) {
                setB.add(topping[i]);
            }
        }
        
        for(int i=0; i<topping.length-1; i++) {
            if(!setA.contains(topping[i])) {
                setA.add(topping[i]);
            }
            count[topping[i]]--;
            if(count[topping[i]] == 0) {
                setB.remove(topping[i]);
            }
            if(setA.size() == setB.size()) {
                answer++;
            }
        }
        
        
        return answer;
    }
}