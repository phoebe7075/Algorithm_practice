package Beakjoon.bj2448;

import java.io.*;

public class Main {
    static int N;
    static int K, E;
    static StringBuilder sb = new StringBuilder();
    static String[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        K = 0;
        E = N/3;
        arr = new String[N];
        for(int i=0; i<N; i++) {
            arr[i] = "";
        }
        arr[0] = "  *  ";
        arr[1] = " * * ";
        arr[2] = "*****";
        for(int i=1; 3*(int)Math.pow(2,i) <= N; ++i) {
            print(i);
        }
        for(int i=0; i<N; i++) {
            bw.write(arr[i]);
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    static void print(int x) {
        int b = 3*(int)Math.pow(2,x);
        int m = b/2;

        for(int i= m; i< b; ++i) {
            arr[i] = arr[i-m] + " " + arr[i-m];
        }
        String space = "";
        for(int i= 0; i< m; i++) {
            space += " ";
        }

        for(int i=0; i<m; ++i) {
            arr[i] = space + arr[i] + space;
        }
    }
}
