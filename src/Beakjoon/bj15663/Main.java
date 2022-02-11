package Beakjoon.bj15663;

import java.io.*;
import java.util.Arrays;

public class Main {
    static int N, M;
    static StringBuilder sb = new StringBuilder();
    static int[] result, target;
    static int[] arr = new int[10001];
    static int idx = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        result = new int[M];
        target = new int[N];
        s = br.readLine().split(" ");
        for(int i=0; i<N; i++) {
            int x = Integer.parseInt(s[i]);
            if(arr[x] != 0) {
                arr[x]++;
            }else {
                target[idx++] = x;
                arr[x]++;
            }
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
        for(int i=N-idx; i<N; i++) {
            if(arr[target[i]] != 0) {
                arr[target[i]]--;
                result[n] = target[i];
                Backtracking(n+1);
                arr[target[i]]++;
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

