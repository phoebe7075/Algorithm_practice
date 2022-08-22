package Programmers.lv3_코딩테스트_공부;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(10, 10, new int[][]{{10, 15, 2, 1, 2}, {20, 20, 3, 3, 4}}));
        
    }
}
class Solution {
    static int dp[][];
    static int alpcap=0, copcap=0;
    static int INF = 1_000_000_000;
    public int solution(int alp, int cop, int[][] problems) {
        for(int i=0; i<problems.length; i++) {
            if(alpcap < problems[i][0]) {
                alpcap = problems[i][0];
            }
            
            if(copcap < problems[i][1]) {
                copcap = problems[i][1];
            }
        }
        dp = new int[Math.max(alp, alpcap)+1][Math.max(cop,copcap)+1];
        for(int i=0; i<=Math.max(alp, alpcap); i++) {
            Arrays.fill(dp[i], INF);
        }
        

        return calc(alp, cop, problems);
    }
    public static int minimumCheck(int value, boolean flag) {
        if(flag) {
            return Math.min(value, alpcap);
        }else {
            return Math.min(value, copcap);
        }
    }
    public static int calc(int a, int c, int[][] list) {
        if(alpcap <= a && copcap <= c) {
            return 0;
        }
        if(dp[a][c] != INF) {
            return dp[a][c];
        }
        dp[a][c] = INF+1;
        dp[a][c] = Math.min(dp[a][c], 1+calc(minimumCheck(a+1, true), c, list));
        dp[a][c] = Math.min(dp[a][c], 1+calc(a, minimumCheck(c+1, false), list));
        for(int[] x : list) {
            if(a >= x[0] && c >= x[1]){
                dp[a][c] = Math.min(dp[a][c], calc(minimumCheck(a+x[2],true), minimumCheck(c+x[3], false), list)+x[4]);
            }
        }

        return dp[a][c];
    }
}