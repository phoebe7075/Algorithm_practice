package Programmers.Line2022공채_4;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new String[]{"....HH", "H..H.H"});
    }
    
}
class Solution {
    static int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};
    static int[] dy2 = {2, 3, -2, -3};
    static int[][] arr;
    static int n, m;
    static boolean[][] visit;
    static int[][] ans;
    public int[][] solution(String[] wall) {
        n = wall.length;
        m = wall[0].length();
        arr = new int[n][m];
        ans = new int[n][m];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(wall[i].charAt(j) == 'H') {
                    arr[i][j] = 1;
                }else if(wall[i].charAt(j) == '.') {
                    arr[i][j] = 0;
                }else {
                    arr[i][j] = -1;
                }
            }
        }
        visit = new boolean[n][m];
        bfs();
        return ans;
    }

    static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(n-1,0));
        visit[n-1][0] = true;
        ans[n-1][0] = 1;


        while(!queue.isEmpty()) {
            Node tmp = queue.poll();
            int nx, ny;
            for(int i=0; i<4; i++) {
                nx = tmp.x + dx[i];
                ny = tmp.y + dy[i];

                if(nx < 0 || nx > n-1 || ny < 0 || ny > m-1) continue;
                if(arr[nx][ny] == 0 || arr[nx][ny] == -1 || visit[nx][ny]) continue;
                queue.add(new Node(nx,ny));
                ans[nx][ny] = ans[tmp.x][tmp.y]+1;
                visit[nx][ny] = true;
            }

            for(int i=0; i<4; i++) {
                nx = tmp.x;
                ny = tmp.y + dy2[i];
                if(nx <= 0 || nx > n-1 || ny < 0 || ny > m-1) continue;
                if(arr[nx][ny] == 0 || arr[nx][ny] == -1 || visit[nx][ny]) continue;
                boolean flag = false;
                for(int j=Math.min(tmp.y,ny); j <= Math.max(tmp.y,ny); j++) {
                    if(arr[nx-1][j] != 0) {
                        flag = true;
                        break;
                    }
                }
                if(flag) continue;
                for(int j=Math.min(tmp.y,ny)+1; j < Math.max(tmp.y,ny); j++) {
                    if(arr[nx][j] != 0) {
                        flag = true;
                        break;
                    }
                }
                if(flag) continue;
                queue.add(new Node(nx,ny));
                ans[nx][ny] = ans[tmp.x][tmp.y]+1;
                visit[nx][ny] = true;
            }
            // 바로 위칸이 빈칸이고 그 위칸에 홀드가 있을 경우
            nx = tmp.x-2; ny = tmp.y;
            if(nx >=0 && nx <= n-1) {
                if(arr[tmp.x-1][ny] == 0 && arr[nx][ny] == 1 && !visit[nx][ny]) {
                    queue.add(new Node(nx,ny));
                    ans[nx][ny] = ans[tmp.x][tmp.y]+1;
                    visit[nx][ny] = true;
                }
            }

            // 대각선 왼쪽 위가 홀드가 있을 때
            nx = tmp.x-1; ny = tmp.y-1;
            if((nx >=0 && nx <= n-1) &&(ny >= 0 && ny <= m-1)) {
                if(arr[nx+1][ny] == 0 && arr[nx][ny+1] == 0 && arr[nx][ny] == 1) {
                    if(!visit[nx][ny]) {
                        queue.add(new Node(nx,ny));
                        ans[nx][ny] = ans[tmp.x][tmp.y]+1;
                        visit[nx][ny] = true;
                    }
                }
            }
            // 대각선 오른쪽 위가 홀드가 있을 때
            nx = tmp.x-1; ny = tmp.y+1;
            if((nx >=0 && nx <= n-1) &&(ny >= 0 && ny <= m-1)) {
                if(arr[nx+1][ny] == 0 && arr[nx][ny-1] == 0 && arr[nx][ny] == 1) {
                    if(!visit[nx][ny]) {
                        queue.add(new Node(nx,ny));
                        ans[nx][ny] = ans[tmp.x][tmp.y]+1;
                        visit[nx][ny] = true;
                    }
                }
            }
        }
    }
}

class Node{
    int x,y;
    Node(int x, int y) {
        this.x =x;
        this.y =y;
    }
}

