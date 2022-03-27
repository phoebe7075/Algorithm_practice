package Programmers.lv2_이진변환반복하기;

public class Main {
}


class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int round = 0;
        while(s.length() > 1) {
            round++;
            int prev = s.length();

            String[] tmp = s.split("0");
            int next = 0;
            for(String x : tmp) {
                next+= x.length();
            }

            answer[1] += (prev-next);
            s = Integer.toBinaryString(next);

        }

        answer[0] = round;

        return answer;
    }
}