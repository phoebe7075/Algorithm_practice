package Beakjoon.bj16234;


import java.util.*;
public class Main {
    static int N, L, R;
    static int[][] arr;
    static int[][] visit;
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
            int[] carr = new int[N*N];
            for(int a=1; a < N*N; a++) {
                for (int i=0; i<N; i++) {
                    for(int j=0; j < N; j++) {
                        if (a == visit[i][j]) {
                            carr[a]++;
                        }
                    }
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
                ans++;
            }
        }

        System.out.println(ans);
    }
    static void calc() {
        int tmp = 0;
        int sum=0, count=0;
        for (int i=0; i<N; i++) {
            for(int j=0; j < N; j++) {
                if (visit[i][j] > 0) {
                    //print();
                    tmp = visit[i][j];
                    sum = 0; count = 0;
                    for (int l = 0; l <N; l++) { // 같은 연합의 총 합과 나라 개수 세기
                        for(int k = 0; k < N; k++) {
                            if (tmp == visit[l][k]) {
                                sum += arr[l][k];
                                count++;
                            }
                        }
                    }
                    sum = sum / count;
                    for (int l = 0; l <N; l++) { // 연합의 인구 이동
                        for(int k = 0; k < N; k++) {
                            if (tmp == visit[l][k]) {
                                visit[l][k] = 0; //이동한 나라 체크
                                arr[l][k] = sum; //인구 이동
                            }
                        }
                    }
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
    static void print() {
        System.out.println("arr ================");
        for(int i=0; i < N; i++) {
            for(int j=0; j< N; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("visit ================");
        for(int i=0; i < N; i++) {
            for(int j=0; j< N; j++) {
                System.out.print(visit[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x; this.y = y;
    }
}