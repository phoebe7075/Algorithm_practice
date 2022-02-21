package Beakjoon.bj11058;


import java.io.*;

public class Main {
    static long arr[];
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new long[N+1];
        for(int i=1; i<=N; i++) {
            arr[i] = i;
        }

        if(N > 6) {
            for(int i=7; i<=N; i++) {
                arr[i] = Math.max(arr[i-3]*2, arr[i]);
                arr[i] = Math.max(arr[i-4]*3, arr[i]);
                arr[i] = Math.max(arr[i-5]*4, arr[i]);
            }
        }

        System.out.println(arr[N]);
    }
}