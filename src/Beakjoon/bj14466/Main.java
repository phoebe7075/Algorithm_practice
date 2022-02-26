package Beakjoon.bj14466;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class Main {
    static boolean visit[][];
    static ArrayList<Node> roads[][];
    static Node[] cows;
    static boolean roadCheck[][];
    static boolean cowCheck[][];
    static int N, K, R;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");
        int x,y,w,z;
        N = Integer.parseInt(s[0]);
        K = Integer.parseInt(s[1]);
        R = Integer.parseInt(s[2]);
        roads = new ArrayList[N+1][N+1];
        cows = new Node[K];
        roadCheck = new boolean[N+1][N+1];
        cowCheck = new boolean[K][K];
        visit = new boolean[N+1][N+1];
        for(int i=0; i<=N; i++) {
            roads[i] = new ArrayList[N+1];
            for(int j=0; j<=N; j++) {
                roads[i][j] = new ArrayList<>();
            }
        }
        for(int i=0; i<R; i++){
            s = br.readLine().split(" ");
            x = Integer.parseInt(s[0]);
            y = Integer.parseInt(s[1]);
            w = Integer.parseInt(s[2]);
            z = Integer.parseInt(s[3]);
            roads[x][y].add(new Node(w,z));
            roads[w][z].add(new Node(x,y));
            roadCheck[x][y] = true;
            roadCheck[w][z] = true;
        }
        for(int i=0; i<K; i++){
            s = br.readLine().split(" ");
            x = Integer.parseInt(s[0]);
            y = Integer.parseInt(s[1]);
            cows[i] = new Node(x,y);
        }
        for(int i=0; i<K; i++){
            bfs(cows[i].x,cows[i].y,i);
        }

        for(int i=0; i<K; i++) {
            for(int j=0; j<K; j++) {
                if(!cowCheck[i][j] && i!=j) {
                    ans++;
                }
            }
        }


        System.out.println(ans/2);
    }


    static int isCow(int x, int y) {
        for(int i=0; i<K; i++){
            if(cows[i].x == x && cows[i].y == y) {
                return i;
            }
        }

        return -1;
    }

    static boolean isRoad(int x, int y,int w, int z) {
        for(Node tmp : roads[x][y]) {
            if(tmp.x == w && tmp.y == z)
                return true;
        }
        return false;
    }


    static void bfs(int x, int y, int order) {
        Queue<Node> queue = new LinkedList<>();
        visit = new boolean[N+1][N+1];
        queue.add(new Node(x,y));
        visit[x][y] = true;
        while (!queue.isEmpty()) {
            Node tmp = queue.poll();

            for(int i=0; i<4; i++) {
                int nx = tmp.x + dx[i], ny = tmp.y + dy[i];

                if(nx < 1 || nx > N || ny < 1 || ny > N)
                    continue;
                if(visit[nx][ny])
                    continue;

                if(roadCheck[tmp.x][tmp.y]) {
                    if(isRoad(tmp.x,tmp.y,nx,ny))
                        continue;
                }

                visit[nx][ny] = true;
                queue.add(new Node(nx,ny));
                int cow = isCow(nx,ny);
                if(cow > -1 && !cowCheck[order][cow]) {
                    cowCheck[order][cow] = true;
                    cowCheck[cow][order] = true;
                }
            }
        }
    }

    static void print() {
        System.out.println("====================");
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                if(visit[i][j])
                    System.out.print(1 + " ");
                else
                    System.out.print(0 + " ");
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return x == node.x &&
                y == node.y;
    }
}