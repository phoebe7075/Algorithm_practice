package Beakjoon.old.bj11399;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        String s[] = br.readLine().split(" ");
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        int ans[] = new int[N+1];
        Arrays.sort(arr);
        ans[0] = arr[0];
        for(int i=1; i<N; i++) {
            ans[i] += arr[i] + ans[i-1];
        }

        for(int i=0; i<N; i++) {
            ans[N] += ans[i];
        }
        System.out.println(ans[N]);
    }
}
