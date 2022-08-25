package Beakjoon.bj1520_내리막길_DP;
import java.io.*;
import java.util.*;

/*
 * 그냥 dfs로 하면 모든 구간을 탐색하기 때문에 시간초과가 남. 예를 들어 5,5 에 도달하는 경우의 수가 상하좌우 하나씩이 아니라 거기까지 왔던 경로들(불필요한)이  로드되고 
 * 그 결과로 상하좌우의 값을 구하는데 완전탐색 후 구하게 되는데, 메모이제이션으로 -1은 아직 방문x, 0은 방문했지만 없는 경우로 구분하여 
 * 0 이상 이라면 재탐색할 필요없이 그 결과만 리턴해주면 말 그대로 상하좌우 계산값만 가지고 dfs를 하기때문에 시간이 훨씬 줄어들게 된다.
 */
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