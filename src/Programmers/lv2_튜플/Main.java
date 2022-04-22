package Programmers.lv2_튜플;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int ans[] = solution.solution("{{4,2,3},{3},{2,3,4,1},{2,3}}");
    }
}
class Solution {
    public int[] solution(String s) {
        int[] answer;
        s = s.substring(1, s.length()-1);
        String[] list = s.split("}");

        for(int i=0; i<list.length; i++) {
            if(list[i].charAt(0) == ',') {
                list[i] = list[i].substring(2);
            }else {
                list[i] = list[i].substring(1);
            }
        }
        boolean num[] = new boolean[100001];

        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        answer = new int[list.length];
        for(int i=0; i<list.length; i++) {
            arr.add(new ArrayList<>());
        }

        for(int i=0; i<list.length; i++) {
            String[] tmp = list[i].split(",");
            int len = tmp.length;

            for(String m : tmp) {
                arr.get(len-1).add(Integer.parseInt(m));
            }
        }

        for(int i=0; i<list.length; i++) {
            for(int tmp : arr.get(i)) {
                if(!num[tmp]) {
                    answer[i] = tmp;
                    num[tmp] = true;
                    break;
                }
            }
        }

        return answer;
    }
}