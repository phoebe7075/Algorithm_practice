package Beakjoon.bj1937_욕심쟁이판다_DP;

import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[][] dp;
    static int[][] arr;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};
    public static void main(String[] args) throws NumberFormatException, IOException {
        N = Integer.parseInt(br.readLine());

        String s[];
        dp = new int[N][N];
        arr = new int[N][N];
        for(int i=0; i<N; i++) {
            s = br.readLine().split(" ");
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
                dp[i][j] = -1;
            }
        }
        int ans=1;

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                ans = Math.max(ans, recursion(i,j));
            }
        }

        System.out.println(ans);
    }
    public static int recursion(int x, int y) {
        if(x < 0 || x > N-1 || y < 0 || y > N-1) {
            return 0;
        }

        if(dp[x][y] != -1) {
            return dp[x][y];
        }

        dp[x][y] = 1;

        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx > N-1 || ny < 0 || ny > N-1) continue;
            if(arr[nx][ny] < arr[x][y]) {
                dp[x][y] = Math.max(dp[x][y], recursion(nx, ny)+1);
            }
        }
        return dp[x][y];
    }
}
