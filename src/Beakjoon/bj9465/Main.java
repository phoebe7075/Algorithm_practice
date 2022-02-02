package Beakjoon.bj9465;


import java.io.*;
public class Main {
    static int N;
    static int[][] arr;
    static int cost[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++) {
            String s[];
            N = Integer.parseInt(br.readLine());
            arr = new int[N][2];
            cost = new int[N][2];
            s = br.readLine().split(" ");
            for(int i=0; i<N; i++) {
                arr[i][0] = Integer.parseInt(s[i]);
            }
            s = br.readLine().split(" ");
            for(int i=0; i<N; i++) {
                arr[i][1] = Integer.parseInt(s[i]);
            }

            cost[0][0] = arr[0][0];
            cost[0][1] = arr[0][1];
            if(N == 1) {
                System.out.println(Math.max(cost[0][0],cost[0][1]));
                continue;
            }else if (N == 2) {
                cost[1][0] = arr[1][0] + cost[0][1];
                cost[1][1] = arr[1][1] + cost[0][0];
                System.out.println(Math.max(cost[1][0],cost[1][1]));
                continue;
            }
            cost[1][0] = arr[1][0] + cost[0][1];
            cost[1][1] = arr[1][1] + cost[0][0];
            for(int i=2; i<N; i++) {
                cost[i][0] = Math.max(cost[i-1][1], cost[i-2][1]) + arr[i][0];
                cost[i][1] = Math.max(cost[i-1][0], cost[i-2][0]) + arr[i][1];
            }
            System.out.println(Math.max(cost[N-1][0],cost[N-1][1]));
        }
    }
}
