package Beakjoon.bj7579_앱_DP;

import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, m;
    static int[] bytes;
    static int[] costs;
    static int[][] dp;
    static int costTotal = 0;
    public static void main(String[] args) throws IOException {
        String s[] = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        bytes = new int[n];
        costs = new int[n];

        s = br.readLine().split(" ");
        String s2[] = br.readLine().split(" ");
        for(int i=0; i<n; i++) {
            bytes[i] = Integer.parseInt(s[i]);
            costs[i] = Integer.parseInt(s2[i]);
            costTotal += costs[i];
        }
        dp = new int[n][costTotal+1];

        int ans = Integer.MAX_VALUE;
        for(int i=0; i<n; i++) {
            for(int j=0; j<=costTotal; j++) {
                if(i==0) {
                    if(j >= costs[i]) dp[i][j] = bytes[i];
                }else {
                    if(j >= costs[i]) {
                        dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-costs[i]]+bytes[i]);
                    }else {
                        dp[i][j] = dp[i-1][j];
                    }
                }
                

                if(dp[i][j] >= m) {
                    ans = Math.min(ans, j);
                }
            }
        }

        System.out.println(ans);
    }
}
