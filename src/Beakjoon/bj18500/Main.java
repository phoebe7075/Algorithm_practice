package Beakjoon.bj18500;


import javafx.util.Pair;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int arr[][];
    static int N, M;
    static boolean visit[][];
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, -1, 0, 1};
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

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
                if(arr[i][j] == 1 && !visit[i][j]) {
                    bfs(i,j);
                }
            }
        }
        return;
    }
    static boolean bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Node> cluster = new ArrayList<>();
        visit = new boolean[N][M];
        queue.add(new Node(x,y));
        visit[x][y] = true;
        int low = -1;
        while (!queue.isEmpty()) {
            Node tmp = queue.poll();
            low = Math.max(tmp.x, low);
            for(int i=0; i<4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];

                if(nx < 0 || nx > N-1 || ny < 0 || ny > M-1)
                    continue;

                if(visit[nx][ny] || arr[nx][ny] == 0)
                    continue;

                queue.add(new Node(nx,ny));
                visit[nx][ny] = true;
            }

            cluster.add(tmp);
        }
        if(low != N-1) {
            fallCluster(cluster);
            return true;
        }

        return true;
    }

    static void fallCluster(ArrayList<Node> cluster) {
        int move = 1;
        for(Node node : cluster) {
            arr[node.x][node.y] = 0;
        }
        outerLoop:
        while (true) {
            for(Node node : cluster) {
                if(node.x + move == N || arr[node.x+move][node.y] == 1) {
                    move--;
                    break outerLoop;
                }
            }
            move++;
        }

        for(Node node : cluster) {
            arr[node.x+move][node.y] = 1;
        }
    }

    static void print() throws IOException {
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
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
class Node{
    int x, y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}