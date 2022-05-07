package Programmers.KaKao2022_03;
import java.util.*;
public class Main {
}

class Solution {
    static boolean[] clearable;
    static ArrayList<Integer> list = new ArrayList<>();
    static int len;
    public int solution(int alp, int cop, int[][] problems) {
        int answer = 0;
        clearable = new boolean[problems.length];
        len = problems.length;

        return answer;
    }

    public boolean isClear(int a, int c, int[][] p) {
        for(int i=0; i<len; i++) {
            if(a > p[i][0] && c > p[i][1]) {
                clearable[i] = true;

            }
        }

        for(int i=0; i<len; i++) {
            if(!clearable[i]) return false;
        }
        return true;
    }
}