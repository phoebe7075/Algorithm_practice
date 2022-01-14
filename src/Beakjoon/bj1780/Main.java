package Beakjoon.bj1780;

import java.io.*;

public class Main {
    static int N;
    static int arr[][];
    static int ans[] = new int[3];
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
        System.out.println(ans[0]+ "\n" +ans[1] + "\n" + ans[2]);
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
        if(a == -1) {
            ans[0]++;
        }else if (a == 0) {
            ans[1]++;
        }else {
            ans[2]++;
        }
        return true;
    }


    static void cutting(int n, int x, int y) {
        if (!isSquare(n,x,y) && n != 1) {
            cutting(n/3,x,y);
            cutting(n/3,x+n/3,y);
            cutting(n/3,x+(n/3)*2,y);
            cutting(n/3,x,y+n/3);
            cutting(n/3,x+n/3,y+n/3);
            cutting(n/3,x+(n/3)*2,y+n/3);
            cutting(n/3,x,y+(n/3)*2);
            cutting(n/3,x+n/3,y+(n/3)*2);
            cutting(n/3,x+(n/3)*2,y+(n/3)*2);
        }
    }
}
