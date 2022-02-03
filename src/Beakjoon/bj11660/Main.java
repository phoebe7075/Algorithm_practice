package Beakjoon.bj11660;

import java.io.*;
public class Main {
    static int arr[][];
    static int sum[][];
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s[] = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        arr = new int[N+1][N+1];
        sum = new int[N+1][N+1];
        int columnT = 0;
        for(int i=1; i<=N; i++) {
            s = br.readLine().split(" ");
            columnT = 0;
            for(int j=1; j<=N; j++) {
                arr[i][j] = Integer.parseInt(s[j-1]);
                columnT += arr[i][j];
                if(i > 0) {
                    sum[i][j] = sum[i-1][j] + columnT;
                }else {
                    sum[i][j] = columnT;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++) {
            s = br.readLine().split(" ");
            int x1,y1,x2,y2;
            x1 = Integer.parseInt(s[0]);
            y1 = Integer.parseInt(s[1]);
            x2 = Integer.parseInt(s[2]);
            y2 = Integer.parseInt(s[3]);
            sb.append(sum[x2][y2] - sum[x2][y1-1] - sum[x1-1][y2] + sum[x1-1][y1-1]);
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
