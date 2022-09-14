package Beakjoon.bj17404_RGB거리2_DP;
import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[][] arr;
    static int[][][] dp;
    public static void main(String[] args) throws NumberFormatException, IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N][3];
        dp = new int[3][N][3];
        String s[];

        for(int i=0; i<N; i++) {
            s = br.readLine().split(" ");
            for(int j=0; j<3; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }

        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                if(i==j) {
                    dp[i][0][j] = arr[0][i];
                }else {
                    dp[i][0][j] = 1001;
                }
            }
        }
        for(int k=0; k<3; k++) {
            for(int i=1; i<N; i++) {
                for(int j=0; j<3; j++) {
                    if(i != N-1) {
                        dp[k][i][j] = Math.min(dp[k][i-1][(j+1)%3]+arr[i][j], dp[k][i-1][(j+2)%3]+arr[i][j]);
                    }else {
                        if(j != k) {
                            dp[k][i][j] = Math.min(dp[k][i-1][(j+1)%3]+arr[i][j], dp[k][i-1][(j+2)%3]+arr[i][j]);
                        }else {
                            dp[k][i][j] = Integer.MAX_VALUE;
                        }
                    }
                }
            }
        }
       
        int ans = 987654321;

        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                ans = Math.min(dp[i][N-1][j], ans);
            }
        }

        System.out.println(ans);
    }
    
}
