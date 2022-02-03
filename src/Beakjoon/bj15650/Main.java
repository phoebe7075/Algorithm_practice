package Beakjoon.bj15650;

import java.io.*;

public class Main {
    static int N, M;
    static boolean visit[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        visit = new boolean[N+1];
        Backtracking(1,0);
    }

    static void Backtracking(int n, int m) {
        if(m == M) {
            print();
        }

        for(int i=n; i<=N; i++) {
            visit[i] = true;
            Backtracking(i+1,m+1);
            visit[i] = false;
        }
    }

    static void print() {
        for(int i=1; i<=N; i++) {
            if(visit[i]){
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}
