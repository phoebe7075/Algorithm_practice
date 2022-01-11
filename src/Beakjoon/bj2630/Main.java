package Beakjoon.bj2630;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int arr[][];
    static int ans[] = new int[2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String s[];
        arr = new int[N][N];
        for(int i=0; i<N; i++) {
            s = br.readLine().split(" ");

            for(int j=0; j <N; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }
        cutting(N,0,0);
        System.out.println(ans[0]+ "\n" +ans[1]);
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
        ans[a]++;
        return true;
    }


    static void cutting(int n, int x, int y) {
        if (!isSquare(n,x,y) && n != 1) {
            cutting(n/2,x,y);
            cutting(n/2,x+n/2,y);
            cutting(n/2,x,y+n/2);
            cutting(n/2,x+n/2,y+n/2);
        }
    }
}
