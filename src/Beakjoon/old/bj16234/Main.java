package Beakjoon.old.bj16234;


import java.util.*;
public class Main {
    static int N, L, R;
    static int[][] arr;
    static int[][] visit;
    static int[] carr;
    static int[] ctotal;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int ans = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        L = scanner.nextInt();
        R = scanner.nextInt();
        scanner.nextLine();
        arr = new int[N][N];
        visit = new int[N][N];
        carr = new int[N*N+1];
        ctotal = new int[N*N+1];
        for(int i=0; i < N; i++) {
            for(int j=0; j<N; j++) {
                arr[i][j] = scanner.nextInt();
            }
            scanner.nextLine();
        }
        bfs();

    }
    static void bfs() {
        int c = 1;
        while (true){
            c = 1;

            for (int i=0; i<N; i++) {
                for(int j=0; j < N; j++) {
                    if (visit[i][j] == 0) {
                        bfs(i,j,c);
                        c++;
                    }
                }
            }
            for (int i=0; i<N; i++) {
                for(int j=0; j < N; j++) {
                    carr[visit[i][j]]++;
                    ctotal[visit[i][j]] += arr[i][j];
                }
            }

            boolean flag = true;
            for(int a=1; a < N*N; a++) {
                if(carr[a] > 1) {
                    flag = false;
                }
            }

            if (flag)
                break;
            if(c > 1) {
                calc();
                for(int a=1; a < N*N; a++) {
                    carr[a] = 0;
                    ctotal[a] = 0;
                }
                ans++;
            }


        }

        System.out.println(ans);
    }
    static void calc() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (carr[visit[i][j]] > 0){
                    arr[i][j] = ctotal[visit[i][j]] / carr[visit[i][j]];
                    visit[i][j] = 0;
                }
            }
        }
    }
    static void bfs(int n, int m, int a) {
        Queue<Point> queue = new LinkedList<Point>();
        queue.add(new Point(n,m));
        visit[n][m] = a;

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for(int i=0; i < 4; i++) {
                int x = p.x + dx[i];
                int y = p.y + dy[i];

                if (x < 0 || y < 0 || x >= N || y >= N)
                    continue;
                if (visit[x][y] != 0)
                    continue;
                if (Math.abs(arr[p.x][p.y]-arr[x][y]) >= L &&  Math.abs(arr[p.x][p.y]-arr[x][y]) <= R) {
                    queue.add(new Point(x,y));
                    visit[x][y] = a;
                }
            }
        }
    }
}

class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x; this.y = y;
    }
}