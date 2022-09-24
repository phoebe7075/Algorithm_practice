package Programmers.카카오2022공채_01;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution("2022.05.19", new String[]{"A 6", "B 12", "C 3"}, new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"});
    }
    
}
class Solution {
    static int year, month, day;
    static ArrayList<Integer> list = new ArrayList<>();
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer;
        String[] s = today.split("\\.");
        year = Integer.parseInt(s[0]);
        month = Integer.parseInt(s[1]);
        day = Integer.parseInt(s[2]);
        
        for(int i=0; i<privacies.length; i++) {
            s = privacies[i].split(" ");
            for(String tmp : terms) {
                String s1[] = tmp.split(" ");
                if(s1[0].equals(s[1])) {
                    check(i+1, Integer.parseInt(s1[1]), s[0]);
                }
            }
        }
        answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }



        return answer;
    }


    static void check(int idx, int deter, String date) {
        int y,m,d;
        String s[] = date.split("\\.");
        y = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        d = Integer.parseInt(s[2]);

        int res = (year-y)*12 + (month-m);

        if(day >= d) {
            res++;
        }

        if(res > deter) {
            list.add(idx);
        }
    }
}