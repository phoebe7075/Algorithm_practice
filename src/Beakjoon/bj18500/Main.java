package Beakjoon.bj18500;


import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int arr[][];
    static int N, M;
    static boolean visit[][];
    static int cluster[][];
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        arr = new int[N][M];
        String s2;

        for(int i=0; i<N; i++) {
            s2 = br.readLine();
            for(int j=0; j<M; j++) {
                if(s2.charAt(j) == '.') {
                    arr[i][j] = 0;
                }else {
                    arr[i][j] = 1;
                }
            }
        }

        int Num;
        boolean dir = false; // false: 왼쪽 true: 오른쪽

        Num = Integer.parseInt(br.readLine());
        s = br.readLine().split(" ");

        for(int i=0; i<Num; i++) {
            visit = new boolean[N][M];
            cluster = new int[N][M];
            int height = Integer.parseInt(s[i]);
            height = N-height;
            if(!dir) {
                for(int j = 0; j < M; j++) {
                    if(arr[height][j] == 1) {
                        arr[height][j] = 0;
                        break;
                    }
                }
            }else {
                for(int j = M-1; j >=0; j--) {
                    if(arr[height][j] == 1) {
                        arr[height][j] = 0;
                        break;
                    }
                }
            }

            clusterSearch();
            dir = !dir;
        }
        print();
    }
    static void clusterSearch() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(arr[i][j] == 1 && cluster[i][j] != 1) {
                    boolean fallableCluster = bfs(i,j);
                    if(fallableCluster) {
                        fallCluster();
                        return;
                    }
                }
            }
        }
        return;
    }
    static boolean bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        visit = new boolean[N][M];
        cluster = new int[N][M];
        queue.add(new Node(x,y));
        visit[x][y] = true;
        cluster[x][y] = 1;
        while (!queue.isEmpty()) {
            Node tmp = queue.poll();

            for(int i=0; i<4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];

                if(nx < 0 || nx > N-1 || ny < 0 || ny > M-1)
                    continue;

                if(visit[nx][ny] || arr[nx][ny] == 0)
                    continue;
                if(nx == N-1)
                    return false;
                queue.add(new Node(nx,ny));
                visit[nx][ny] = true;
                cluster[nx][ny] = 1;
            }
        }

        return true;
    }

    static boolean fallCluster() {
        boolean isfallable = true;
        boolean reallyFall = false;
        while (isfallable) {
            for(int i=N-1; i >= 0; i--) {
                for(int j=0; j<M; j++) {
                    if(visit[i][j]) {
                        if(i == N-1) {//바닥이면 더 떨어질 수 없다.
                            isfallable = false;
                        }else if(arr[i+1][j] == 1 && !visit[i+1][j]) { // 찾은 지점의 떨어질 곳이 클러스터가 아닌데 미네랄이 있을경우 멈춤
                            isfallable = false;
                        }
                    }
                }
            }

            if(isfallable) {
                for(int i=N-2; i >= 0; i--) {
                    for (int j = 0; j < M; j++) {
                        if(visit[i][j]) {
                            visit[i+1][j] = true;
                            visit[i][j] = false;
                            arr[i+1][j] = 1;
                            arr[i][j] = 0;
                        }
                    }
                }
                reallyFall = true;
            }
        }

        return reallyFall;
    }

    static void print() {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(arr[i][j] == 1) {
                    sb.append("x");
                }else {
                    sb.append(".");
                }
            }
            if(i != N-1) {
                sb.append(" \n");
            }
        }
        System.out.println(sb.toString());
    }
}
class Node{
    int x, y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}