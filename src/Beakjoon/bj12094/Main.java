package Beakjoon.bj12094;

import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static int arr[][];
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        String s[];
        for(int i=0; i<N; i++) {
            s = br.readLine().split(" ");
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
                if(ans < arr[i][j]) {
                    ans = arr[i][j];
                }
            }
        }
        crash(0,arr,new boolean[4]);
        System.out.println(ans);
    }


    static void crash(int turn, int[][] x, boolean[] change) {
        if(turn == 10) {
            return;
        }
        int[][] tmp = new int[N][N];
        boolean[] tmp2 = new boolean[4];
        int a, idx;

        for(int i=0; i<N; i++) { // 위
            a=0; idx = 0;
            for(int j=0; j<N; j++) {
                if(x[j][i] == 0)
                    continue;
                if(a == x[j][i]) {
                    if(ans == a) {
                        ans *= 2;
                    }
                    tmp[idx-1][i]*=2;
                    a = 0;
                    tmp2[0] = true;
                }else {
                    tmp[idx++][i] = x[j][i];
                    a = x[j][i];
                    tmp2[0] = true;
                }
            }
        }
        if(tmp2[0] || change[0])
            crash(turn+1, tmp, tmp2);

        tmp = new int[N][N];
        for(int i=0; i<N; i++) { //좌
            a = 0; idx = 0;
            for(int j=0; j<N; j++) {
                if(x[i][j] == 0)
                    continue;
                if(a == x[i][j]) {
                    if(ans == a) {
                        ans *= 2;
                    }
                    tmp[i][idx-1]*=2;
                    a = 0;
                    tmp2[1] = true;
                }else {
                    tmp[i][idx++] = x[i][j];
                    a = x[i][j];
                    tmp2[1] = true;
                }
            }
        }
        if(tmp2[1] || change[1])
            crash(turn+1, tmp, tmp2);

        tmp = new int[N][N];
        for(int i=0; i<N; i++) {
            a = 0; idx = N-1;
            for(int j=N-1; j>=0; j--) {
                if(x[i][j] == 0)
                    continue;
                if(a == x[i][j]) {
                    if(ans == a) {
                        ans *= 2;
                    }
                    tmp[i][idx+1]*=2;
                    a = 0;
                    tmp2[2] = true;
                }else {
                    tmp[i][idx--] = x[i][j];
                    a = x[i][j];
                    tmp2[2] = true;
                }
            }
        }
        if(tmp2[2] || change[2])
            crash(turn+1, tmp, tmp2);

        tmp = new int[N][N];
        for(int i=0; i<N; i++) {
            a = 0; idx = N-1;
            for(int j=N-1; j>=0; j--) {
                if(x[j][i] == 0)
                    continue;
                if(a == x[j][i]) {
                    if(ans == a) {
                        ans *= 2;
                    }
                    tmp[idx+1][i]*=2;
                    a = 0;
                    tmp2[3] = true;
                }else {
                    tmp[idx--][i] = x[j][i];
                    a = x[j][i];
                    tmp2[3] = true;
                }
            }
        }
        if(tmp2[3] || change[3])
            crash(turn+1, tmp, tmp2);
    }


    static void print(int[][] x, int d) {
        System.out.println("===========" + d + "===========");
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                System.out.print(x[i][j] + " ");
            }
            System.out.println();
        }
    }
}
