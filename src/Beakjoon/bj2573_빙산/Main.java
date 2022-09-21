package Beakjoon.bj2573_빙산;

import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] arr;
    static int n, m;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};
    static boolean[][] visit;
    static boolean flag =false;
    public static void main(String[] args) throws IOException {
        String s[];
        s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        arr = new int[n][m];

        for(int i=0; i<n; i++) {
            s = br.readLine().split(" ");

            for(int j=0; j<m; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }
        int year = 0;
        while(true) {
            bfs();

            if(flag) {
                break;
            }
            nextYear();
            if(checkNull()) break;
            year++;
        }

        System.out.println(flag ? year : 0);
    }
    static boolean checkNull() {
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(arr[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    static void nextYear() {
        int[][] tmparr = new int[n][m];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                for(int k=0; k<4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if(nx < 0 || nx > n-1 || ny < 0 || ny > m-1) continue;
                    if(arr[nx][ny] != 0) continue;

                    tmparr[i][j]--;
                }
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                arr[i][j] = Math.max(arr[i][j] + tmparr[i][j], 0);
            }
        }
    }

    static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        visit = new boolean[n][m];
        outerLoop:
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(arr[i][j] != 0) {
                    queue.add(new Node(i,j));
                    visit[i][j] = true;
                    break outerLoop;
                }
            }
        }

        while(!queue.isEmpty()) {
            Node x = queue.poll();

            for(int i=0; i<4; i++) {
                int nx = x.x + dx[i];
                int ny = x.y + dy[i];

                if(nx < 0 || nx > n-1 || ny < 0 || ny > m-1) continue;
                if(arr[nx][ny] == 0) continue;
                if(visit[nx][ny]) continue;

                queue.add(new Node(nx,ny));
                visit[nx][ny] = true;
            }
        }



        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(arr[i][j] != 0 && !visit[i][j]) {
                    flag = true;
                }
            }
        }
    }
}

class Node {
    int x,y;
    Node(int x, int y) {
        this.x =x;
        this.y =y;
    }
}
