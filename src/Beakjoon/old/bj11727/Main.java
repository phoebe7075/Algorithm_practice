package Beakjoon.old.bj11727;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long arr[] = new long[1001];
        arr[1] = 1; arr[2] = 3;
        if (N > 2) {
            for(int i=3; i<=N; i++){
                arr[i] = arr[i-1] + arr[i-2]*2;
                arr[i] %= 10007;
            }
        }
        System.out.println(arr[N]%10007);
    }
}
