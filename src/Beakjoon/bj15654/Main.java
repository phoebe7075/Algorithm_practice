package Beakjoon.bj15654;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static int[] output;
    static boolean visit[];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s[] = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        visit = new boolean[N];
        arr = new int[N];
        output = new int[M];
        s = br.readLine().split(" ");
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        Arrays.sort(arr);
        Backtracking(0);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void Backtracking(int m) {
        if(m == M) {
            print();
            return;
        }

        for(int i=0; i<N; i++) {
            if(!visit[i]) {
                visit[i] = true;
                output[m] = arr[i];
                Backtracking(m+1);
                visit[i] = false;
            }
        }
    }

    static void print() {
        for(int i=0; i<M; i++) {
            sb.append(output[i] + " ");
        }
        sb.append("\n");
    }
}
