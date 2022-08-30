package Beakjoon.bj11066_파일합치기_DP;
import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<t; i++) {
            sb.append(solution() + "\n");
        }
        System.out.println(sb.toString());
    }
    static int[][] dp;
    static int[] arr;
    static int[] subsum;
    static int INF = 1_000_000_000;
    public static int solution() throws IOException{
        int n = Integer.parseInt(br.readLine());
        dp = new int[n+1][n+1];
        arr = new int[n+1];
        subsum = new int[n+1];
        String s[] = br.readLine().split(" ");
        for(int i=1; i<=n; i++) {
            arr[i] = Integer.parseInt(s[i-1]);
            subsum[i] = subsum[i-1] + arr[i]; 
        }
        
        for (int i = 1; i <= n; i++) {
            for (int from = 1; from + i <= n; from++) {
                int to = from + i;
                dp[from][to] = Integer.MAX_VALUE;
                for (int divide = from; divide < to; divide++) {
                    dp[from][to] = Math.min(dp[from][to], dp[from][divide] + dp[divide + 1][to] + subsum[to] - subsum[from - 1]);
                }
            }
        }
        return dp[1][n];
    }
}
