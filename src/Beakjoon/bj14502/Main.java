package Beakjoon.bj14502;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[][] arr;
    static int N, M;
    static boolean[][] visit;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int ans = 0;
    static int virus[][] = new int[10][2];
    static int vCount = 0;
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
                if(arr[i][j] == 2) {
                    virus[vCount][0] = i;
                    virus[vCount][1] = j;
                    vCount++;
                }
            }
        }

        Backt(0,0,0);
        System.out.println(ans);
    }


    static void bfs() {
        Queue<Node> queue = new LinkedList<>();

        for(int i=0; i<vCount; i++) {
            queue.add(new Node(virus[i][0],virus[i][1]));
            visit[virus[i][0]][virus[i][1]] = true;
        }


        while (!queue.isEmpty()) {
            Node node = queue.poll();
            visit[node.x][node.y] = true;
            for(int i=0; i<4; i++) {
                int nextX = node.x + dx[i];
                int nextY = node.y + dy[i];

                if(nextX < 0 || nextX > N-1 || nextY < 0 || nextY > M-1)
                    continue;

                if(visit[nextX][nextY])
                    continue;

                if(arr[nextX][nextY] == 1)
                    continue;

                queue.add(new Node(nextX,nextY));
            }
        }
        zeroCount();
    }


    static void Backt(int x, int y, int d) {
        if(d == 3) {
            visit = new boolean[N][M];
            bfs();
            return;
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(arr[i][j] == 0) {
                    if(d > 0) {
                        if(i == x && j > y) {
                            arr[i][j] = 1;
                            Backt(i,j,d+1);
                            arr[i][j] = 0;
                        }else if (i > x){
                            arr[i][j] = 1;
                            Backt(i,j,d+1);
                            arr[i][j] = 0;
                        }
                    }else {
                        arr[i][j] = 1;
                        Backt(i,j,d+1);
                        arr[i][j] = 0;
                    }
                }
            }
        }


    }


    static void zeroCount() {
        int tmp = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(arr[i][j] == 0 && !visit[i][j]) {
                    tmp++;
                }
            }
        }

        ans = Math.max(ans,tmp);
    }
}

class Node{
    int x, y;
    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
