package Beakjoon.tmp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String s[] = {"1 development hometask","1 recruitment marketing","2 hometask","2 development marketing hometask","3 marketing","3 officetask","3 development"};
        String p[] = {"development","marketing","hometask"};
        String x[] = {"recruitment","education","officetask"};

    }
    static int priority;
    public long solution(int[] abil, int k) {
        long answer = 0;
        int round = (abil.length+1)/2;
        priority = k;
        int idx = 0;
        long tmp = 0;
        Arrays.sort(abil);
        int[] diff = new int[round];

        for(int i=0; i<round; i++) {
            diff[round] = abil[round*2] - abil[(round*2)+1];
        }

        Arrays.sort(diff);
        while(idx < abil.length-1) {
            idx++;
            tmp += abil[idx];
            idx++;
        }

        answer = tmp;

        for(int i=0; i<k; i++) {
            answer += diff[round-i];
        }
        return answer;
    }


}



