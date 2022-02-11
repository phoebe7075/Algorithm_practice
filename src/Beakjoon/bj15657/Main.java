package Beakjoon.bj15657;

import java.io.*;
import java.util.Arrays;

public class Main {
    static int N, M;
    static StringBuilder sb = new StringBuilder();
    static int[] result, target;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        result = new int[M];
        target = new int[N];
        s = br.readLine().split(" ");
        for(int i=0; i<N; i++) {
            target[i] = Integer.parseInt(s[i]);
        }
        Arrays.sort(target);
        Backtracking(0);
        System.out.println(sb.toString());
    }

    static void Backtracking(int n) {
        if(n == M) {
            print();
            return;
        }
        for(int i=0; i<N; i++) {
            if(n != 0) {
                if(result[n-1] <= target[i]) {
                    result[n] = target[i];
                    Backtracking(n+1);
                }
            }else {
                result[n] = target[i];
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

