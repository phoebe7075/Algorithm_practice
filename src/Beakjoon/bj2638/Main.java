package Beakjoon.bj2638;

import java.io.*;
import java.util.*;
public class Main {
    static int arr[][];
    static int N, M;
    static int ans = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        arr = new int[N][M];
        for(int i=0; i<N; i++) {
            s = br.readLine().split(" ");
            for(int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }
        while (isCheese()) {
            boolean flag = false;
            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    if(arr[i][j] == 0) {
                        dfs(i,j);
                        flag = true;
                    }
                }
                if(flag)
                    break;
            }

            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    if(arr[i][j] == 1) {
                        thawCheese(i,j);
                    }
                }
            }

            for(int i=0; i<N; i++) {
                for (int j = 0; j < M; j++) {
                    if(arr[i][j] == 2) {
                        arr[i][j] = 0;
                    }
                }
            }
            //print();
            ans++;
        }

        System.out.println(ans);
    }

    static void dfs(int x, int y) {
        arr[x][y] = 2;
        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || nx > N-1 || ny < 0 || ny > M-1)
                continue;

            if(arr[nx][ny] != 0)
                continue;

            dfs(nx,ny);
        }
    }

    static boolean isCheese() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(arr[i][j] == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    static void thawCheese(int x, int y) {
        int tmp = 0;

        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx > N-1 || ny < 0 || ny > M-1)
                continue;

            if(arr[nx][ny] == 2)
                tmp++;
        }

        if(tmp > 1) {
            arr[x][y] = 0;
        }
    }

    static void print() {
        System.out.println("===================");
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class Node {
    int x, y;
    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
