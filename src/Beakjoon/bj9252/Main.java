package Beakjoon.bj9252;

import java.io.*;
public class Main {
    static int[][] arr;
    static int[][] visit;
    static int m,n;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();

        m = s1.length();
        n = s2.length();
        arr = new int[m+1][n+1];
        visit = new int[m+1][n+1];
        LCS(s1,s2);
        print(s1,m,n);
        System.out.println(sb.toString().length());
        if(sb.toString().length() != 0){
            System.out.println(sb.toString());
        }
    }
    static void LCS(String x, String y) {
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++) {
                if(x.charAt(i-1) == y.charAt(j-1)) {
                    arr[i][j] = arr[i-1][j-1]+1;
                    visit[i][j] = 3;
                }else if(arr[i-1][j] >= arr[i][j-1]) {
                    arr[i][j] = arr[i-1][j];
                    visit[i][j] = 2;
                }else {
                    arr[i][j] = arr[i][j-1];
                    visit[i][j] = 1;
                }
            }
        }
    }

    static void print(String x, int i, int j) {
        if (i==0 || j == 0) {
            return;
        }

        if(visit[i][j] == 3) {
            print(x,i-1,j-1);
            sb.append(x.charAt(i-1));
        }else if (visit[i][j] == 2) {
            print(x,i-1,j);
        }else {
            print(x, i, j-1);
        }
    }
}
