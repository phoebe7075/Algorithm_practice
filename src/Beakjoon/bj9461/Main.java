package Beakjoon.bj9461;


import java.io.*;
public class Main {
    static long[] arr = new long[101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        arr[1] = 1; arr[2] = 1; arr[3] = 1; arr[4] = 2; arr[5] = 2; arr[6] = 3;
        for(int a=0; a<T; a++) {
            int n = Integer.parseInt(br.readLine());
            if(arr[n] == 0) {
                dp(n);
            }
            System.out.println(arr[n]);
        }
    }

    static long dp(int n) {
        if(arr[n] != 0)
            return arr[n];

        arr[n] = dp(n-1)+dp(n-5);
        return arr[n];

    }
}
