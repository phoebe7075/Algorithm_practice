package Beakjoon.bj15652;

import java.io.*;

public class Main {
    static int N, M;
    static boolean visit[];
    static StringBuilder sb = new StringBuilder();
    static int[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        result = new int[M];
        Backtracking(0);
        System.out.println(sb.toString());
    }

    static void Backtracking(int n) {
        if(n == M) {
            print();
            return;
        }
        for(int i=1; i<=N; i++) {
            if(n != 0) {
                if(result[n-1] <= i) {
                    result[n] = i;
                    Backtracking(n+1);
                }
            }else {
                result[n] = i;
                Backtracking(n+1);
            }
        }
    }
    static void print() {
        for(int i=0; i<M; i++) {
            sb.append(result[i]+ " ");
        }
        sb.append("\n");
    }
}

