package Programmers.lv2_미로_탈출_bfs;

import java.io.*;
import java.util.*;


class Solution {
    static int[][] arr;
    static int width, height;
    static int[][] pos = new int[3][2];
    static int[][] visit;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    public int solution(String[] maps) {
        int answer = 0;
        width = maps.length;
        height = maps[0].length();
        arr = new int[width][height];
        for(int i=0; i<width; i++) {
            for(int j=0; j<height; j++) {
                if(maps[i].charAt(j) == 'S') {
                    pos[0][0] = i; pos[0][1] = j;
                }else if(maps[i].charAt(j) == 'L') {
                    pos[1][0] = i; pos[1][1] = j;
                }else if(maps[i].charAt(j) == 'E') {
                    pos[2][0] = i; pos[2][1] = j;
                }else if(maps[i].charAt(j) == 'X') {
                    arr[i][j] = -1;
                }
            }
        }
        
        bfs(pos[0][0], pos[0][1]);
        
        if(visit[pos[1][0]][pos[1][1]] == 0) {
            return -1;
        }
        answer += (visit[pos[1][0]][pos[1][1]]-1);
        
        bfs(pos[1][0], pos[1][1]);
        if(visit[pos[2][0]][pos[2][1]] == 0) {
            return -1;
        }
        
        answer += (visit[pos[2][0]][pos[2][1]]-1);
        
        return answer;
    }
    
    
    static void bfs(int sx, int sy) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(sx, sy));
        visit = new int[width][height];
        
        visit[sx][sy] = 1;
        
        while(!q.isEmpty()){
            Node x = q.poll();
            
            for(int i=0; i<4; i++) {
                int nx = x.x + dx[i];
                int ny = x.y + dy[i];
                
                if(nx < 0 || nx >= width || ny <0 || ny >= height) continue;
                if(visit[nx][ny] > 0 || arr[nx][ny] == -1) continue;
                
                q.add(new Node(nx, ny));
                visit[nx][ny] = visit[x.x][x.y]+1;
            }
        }
        
        return;
    }
}


class Node {
    int x, y;
    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}