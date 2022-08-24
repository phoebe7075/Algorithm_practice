package Beakjoon.bj2294_동전_2_DP;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s[] = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        int[] coins = new int[n];
        int INF = 10000000;
        for(int i=0; i<n; i++){
            coins[i] = Integer.parseInt(br.readLine());
        }
        int[] dp = new int[10010];
        Arrays.fill(dp, INF);
        dp[0] = 0;
        for(int i=1; i<=k; i++) {
            for(int j=0; j<n; j++) {
                if(i-coins[j] >= 0) {
                    dp[i] = Math.min(dp[i], dp[i-coins[j]]+1);
                }
            }
        }
        if(dp[k] >= INF) {
            System.out.println(-1);
        }else {
            System.out.println(dp[k]);
        }
        
    }
}

