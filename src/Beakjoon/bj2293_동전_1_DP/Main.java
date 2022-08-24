package Beakjoon.bj2293_동전_1_DP;
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s[] = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        int[] coins = new int[n];
        
        for(int i=0; i<n; i++){
            coins[i] = Integer.parseInt(br.readLine());
        }
        int[] dp = new int[10010];
        dp[0] = 1;
        for(int i=0; i<n; i++) {
            for(int j=coins[i]; j<=k; j++) {
                dp[j] += dp[j-coins[i]];
            }
        }
        System.out.println(dp[k]);
    }
}
