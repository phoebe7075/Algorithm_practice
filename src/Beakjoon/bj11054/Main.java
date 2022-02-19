package Beakjoon.bj11054;

import java.io.*;

public class Main {
    static int N;
    static int arr[];
    static int dp[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String s[] = br.readLine().split(" ");
        arr = new int[N];
        dp = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(s[i]);
            dp[i] = 1;
        }
        int ans = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<i; j++) {
                if(arr[i] > arr[j]) {
                    if(dp[j]+1 > dp[i]) {
                        dp[i] = dp[j]+1;
                    }
                }
            }
            if(ans < dp[i]) {
                ans = dp[i];
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<i; j++) {
                if(arr[i] < arr[j]) {
                    if(dp[j]+1 > dp[i]) {
                        dp[i] = dp[j]+1;
                    }
                }
            }
            if(ans < dp[i]) {
                ans = dp[i];
            }
        }


        System.out.println(ans);
    }
}
