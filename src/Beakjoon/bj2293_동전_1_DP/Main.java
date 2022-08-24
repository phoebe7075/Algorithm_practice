package Beakjoon.bj2293_동전_1_DP;
import java.io.*;
import java.util.*;

/*
1원만으로 구성할 때 10원의 경우는
dp[9]에서 내 껄 더해주니까 1이 됨.
그 다음 2원에서 처음부터 동전을 구성해 나감.
그러다가 10원의 경우에서 dp[8]만큼을 더해주는데, 이때 dp[8]은( 즉1원과 2원으로만 이루어진 8원의 경우의 수는) 5임. 그래서 dp[10] = 6이 됨.
그 다음 5원으로 이루어진 경우를 구성. dp[10] += dp[5](=4) 가 되므로, dp[10] = 10이 된다.
 */


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
