package Programmers.lv1_k번째_수;
import java.util.*;
public class Main {
}

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int len = commands.length;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<array.length; i++) {
            list.add(array[i]);
        }
        for(int i=0; i<len; i++) {
            System.out.println(i);
            List<Integer> sublist = new ArrayList<>(list.subList(commands[i][0]-1,commands[i][1]));
            Collections.sort(sublist);
            answer[i] = sublist.get(commands[i][2]-1);
        }


        return answer;
    }
}