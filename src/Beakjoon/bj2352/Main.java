package Beakjoon.bj2352;
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s[] = br.readLine().split(" ");

        int[] arr = new int[n];

        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        int[] dp = new int[n];
        dp[0] = arr[0];
        int idx = 1;
        int tmp = 0;
        for (int i = 1; i < n; i++) {
            if (dp[idx - 1] < arr[i]) {
                dp[idx++] = arr[i];
            } else if (dp[0] > arr[i]) {
                dp[0] = arr[i];
            } else {
                tmp = Arrays.binarySearch(dp, 0, idx, arr[i]);
                dp[tmp < 0 ? (-tmp - 1) : tmp] = arr[i];
            }
        }

        System.out.println(idx);
    }
}