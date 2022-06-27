package Programmers.lv2_42746;
import java.util.*;
public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new int[]{3, 30, 34, 5, 9});
    }
}

class Solution {
    public String solution(int[] numbers) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i : numbers) {
            list.add(i);
        }
        Collections.sort(list, (a1, a2) -> {
            String x = Integer.toString(a1);
            String y = Integer.toString(a2);

            return Integer.parseInt(y+x) - Integer.parseInt(x+y);

        });

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<list.size(); i++) {
            sb.append(list.get(i));
        }
        if(list.get(0) == 0) {
            return "0";
        }

        return sb.toString();

    }
}