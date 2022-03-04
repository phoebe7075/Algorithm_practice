package Beakjoon.bj16967;

import java.io.*;
public class Main {
    static int N,M,X,Y;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String s[] = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        X = Integer.parseInt(s[2]);
        Y = Integer.parseInt(s[3]);
        arr = new int[N][M];
        for(int i=0; i<N+X; i++) {
            s = br.readLine().split(" ");
            for(int j=0; j<M+Y; j++) {
                if((i < X && j < M) || (i == X && j < Y) || (i < N && j < Y)) {
                    arr[i][j] = Integer.parseInt(s[j]);
                }else if (i >= X && j >= Y && i < N && j < M) {
                    arr[i][j] = Integer.parseInt(s[j]) - arr[i-X][j-Y];
                }
                if(i < N && j < M) {
                    sb.append(arr[i][j] + " ");
                }
            }
            if(i < N-1) {
                sb.append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
