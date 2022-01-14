package Beakjoon.bj1992;

import java.io.*;

public class Main {
    static int N;
    static int arr[][];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String s;
        arr = new int[N][N];
        for(int i=0; i<N; i++) {
            s = br.readLine();

            for(int j=0; j <N; j++) {
                arr[i][j] = s.charAt(j)-'0';
            }
        }
        cutting(N,0,0);
        System.out.println(sb.toString());
    }

    static boolean isSquare(int n, int x, int y) {
        int a = 2;
        for(int i=x; i<x+n; i++) {
            for(int j=y; j<y+n; j++) {
                if (a > 1) {
                    a = arr[i][j];
                }else {
                    if(a != arr[i][j]) {
                        return false;
                    }
                }
            }
        }
        sb.append(a);
        return true;
    }


    static void cutting(int n, int x, int y) {
        if (!isSquare(n,x,y) && n != 1) {
            sb.append("(");
            cutting(n/2,x,y);
            cutting(n/2,x,y+n/2);
            cutting(n/2,x+n/2,y);
            cutting(n/2,x+n/2,y+n/2);
            sb.append(")");
        }
    }
}

