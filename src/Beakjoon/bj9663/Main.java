package Beakjoon.bj9663;

import java.io.*;
public class Main {
    static int N;
    static int[] column;
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        column = new int[N];
        Backtracking(0);
        System.out.println(ans);
    }


    static void Backtracking(int n) {
        if(n == N) {
            ans++;
            return;
        }

        for(int i=0; i<N; i++) {
            column[n] = i;
            if(valid(n)) {
                Backtracking(n+1);
            }
        }
    }

    static boolean valid(int x) {
        if(x == 0)
            return true;
        for(int i=0; i<x; i++) {
            if(column[i] == column[x] || Math.abs(column[i]-column[x]) == x-i) {
                return false;
            }
        }
        return true;
    }
}
