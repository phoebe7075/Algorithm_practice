package Beakjoon.bj11052_카드구매_DP;
import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws NumberFormatException, IOException {
        int n = Integer.parseInt(br.readLine());

        int arr[] = new int[n];

        String s[] = br.readLine().split(" ");

        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        int dp[] = new int[n+1];

        for(int i=n; i>=0; i--) {
            for(int j=1; j<=i; j++) {
                dp[i-j] = Math.max(dp[i-j], dp[i]+arr[j-1]);
            }
        }
        System.out.println(dp[0]);
    }
}
