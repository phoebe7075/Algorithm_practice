package Beakjoon.bj16236;

import com.sun.org.apache.xpath.internal.objects.DTMXRTreeFrag;

import java.io.*;
import java.util.*;
public class Main {
    static int[][] arr;
    static boolean[][] visit;
    static int N;
    static int x, y; //아기상어의 좌표
    static int scale = 2, eatCount = 0;
    static int ans;
    static int[][] cost;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    static boolean flag = false;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        String s[];
        for(int i=0; i<N; i++){
            s = br.readLine().split(" ");
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
                if(arr[i][j] == 9) {
                    x = i;
                    y = j;
                    arr[i][j] = 0;
                }
            }
        }

        while (!flag){
            bfs();
        }

        System.out.println(ans);
    }

    static void bfs() {
        isEmpty();
        if(flag)
            return;
        Queue<Dot> queue = new LinkedList<>();
        queue.add(new Dot(x,y));
        cost = new int[N][N];
        visit = new boolean[N][N];
        visit[x][y] = true;
        Dot end = new Dot(0,0);
        while (!queue.isEmpty()){
            Dot dot = queue.poll();

            for(int i=0; i<4; i++) {
                int nextX = dot.x + dx[i];
                int nextY = dot.y + dy[i];

                if(nextX <0 || nextX > N-1 || nextY < 0 || nextY > N-1)
                    continue;
                if(visit[nextX][nextY])
                    continue;
                if(arr[nextX][nextY] > scale)
                    continue;

                queue.add(new Dot(nextX,nextY));
                cost[nextX][nextY] = cost[dot.x][dot.y] +1;
                visit[nextX][nextY] = true;
            }
        }

        end = search();
        if(flag) {
            return;
        }
        ans += cost[end.x][end.y];
        eatCount++;

        if(eatCount == scale) {
            eatCount = 0;
            scale++;
        }
        arr[end.x][end.y] = 0;
        x = end.x; y = end.y;
    }

    static boolean isEmpty() {
        flag = true;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(arr[i][j] != 0 && arr[i][j] < scale){
                    flag = false;
                    return flag;
                }
            }
        }
        return flag;
    }

    static Dot search() {
        int tmp = 9999999;
        Dot dot = new Dot(0,0);
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(cost[i][j] != 0 && arr[i][j] > 0 && arr[i][j] < scale){
                    if(tmp > cost[i][j]) {
                        tmp = cost[i][j];
                        dot.x = i;
                        dot.y = j;
                    }
                }
            }
        }
        if(tmp == 9999999) {
            flag = true;
            return dot;
        }
        return dot;
    }
}

class Dot {
    int x, y;

    Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
