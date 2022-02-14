package Beakjoon.bj17141;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[][] arr;
    static int N, M;
    static int[][] visit;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int ans = Integer.MAX_VALUE;
    static int virus[][] = new int[10][2];
    static int vCount = 0;
    static int select[];
    static int Zcount = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        arr = new int[N][N];
        select = new int[M];
        for(int i=0; i<N; i++) {
            s = br.readLine().split(" ");
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
                if(arr[i][j] == 2) {
                    arr[i][j] = 0;
                    virus[vCount][0] = i;
                    virus[vCount][1] = j;
                    vCount++;
                }

                if(arr[i][j] == 0)
                    Zcount++;

            }
        }
        Zcount -= M;
        if(Zcount == 0) {
            ans = 0;
        }else {
            Backt(0,0);
        }

        if(ans == Integer.MAX_VALUE) {
            System.out.println(-1);
        }else {
            System.out.println(ans);
        }

    }


    static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        int time =0, count = Zcount;
        for(int i=0; i<M; i++) {
            queue.add(new Node(virus[select[i]][0],virus[select[i]][1]));
            visit[virus[select[i]][0]][virus[select[i]][1]] = 2;
        }

        while (!queue.isEmpty()) {
            if(ans <= time) {
                break;
            }
            int len = queue.size();
            for(int k = 0; k < len; k++) {
                Node node = queue.poll();
                for(int i=0; i<4; i++) {
                    int nextX = node.x + dx[i];
                    int nextY = node.y + dy[i];

                    if(nextX < 0 || nextX > N-1 || nextY < 0 || nextY > N-1)
                        continue;

                    if(visit[nextX][nextY] > 0)
                        continue;

                    if(arr[nextX][nextY] == 1)
                        continue;
                    visit[nextX][nextY] = 2;
                    queue.add(new Node(nextX,nextY));

                    count--;
                }
            }

            time++;
            if(count == 0) {
                ans = time;
                return;
            }
        }
    }

    static void Backt(int n, int d) {
        if(d == M) {
            visit = new int[N][N];
            bfs();
            return;
        }

        for(int i=n; i<vCount; i++) {
            select[d] = i;
            Backt(i+1,d+1);
        }
    }
}

class Node{
    int x, y;
    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
