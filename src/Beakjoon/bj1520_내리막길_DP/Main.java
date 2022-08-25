package Beakjoon.bj1520_내리막길_DP;
import java.io.*;
import java.util.*;
public class Main {
    static int[][] dp;
    static int n, m;
    static int[][] arr;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        dp = new int[n][m];
        arr = new int[n][m];

        for(int i=0; i<n; i++) {
            s = br.readLine().split(" ");
            for(int j=0; j<m; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
                dp[i][j] = -1;
            }
        }
        int ans = recursion(0, 0);
        System.out.println(ans);
    }

    static int recursion(int x, int y) {
        if(x == n-1 && y == m-1) {
            return 1;
        }
        if(dp[x][y] != -1) {
            return dp[x][y];
        }
        dp[x][y] = 0;
        if(x > 0 && arr[x-1][y] < arr[x][y]) {
            dp[x][y] += recursion(x-1,y);
        }
        if(x < n-1 && arr[x+1][y] < arr[x][y]) {
            dp[x][y] += recursion(x+1,y);
        }
        if(y > 0 && arr[x][y-1] < arr[x][y]) {
            dp[x][y] += recursion(x, y-1);
        }
        if(y < m-1 && arr[x][y+1] < arr[x][y]) {
            dp[x][y] += recursion(x, y+1);
        }
        return dp[x][y];
    }
}