package Programmers.lv2_무인도여행;
import java.io.*;
import java.util.*;
public class Main {
    
}

class Solution {
    static boolean[][] visit;
    static int w,h;
    static ArrayList<Integer> res = new ArrayList<>();
    static int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};
    public int[] solution(String[] maps) {
        w = maps.length;
        h = maps[0].length();
        visit = new boolean[w][h];
        
        for(int i=0; i<w; i++) {
            for(int j=0; j<h; j++) {
                if(maps[i].charAt(j) != 'X' && !visit[i][j]) {
                    res.add(bfs(i, j, maps));
                }
            }
        }
        
        Collections.sort(res);
        if(res.size() != 0) {
            int[] ans = new int[res.size()];
            for(int i=0; i<ans.length; i++) {
                ans[i] = res.get(i);
            }

            return ans;
        }else {
            return new int[]{-1};
        }
        
    }
    
    static int bfs(int x, int y, String[] map) {
        int sum = 0;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x,y));
        visit[x][y] = true;
        sum += (map[x].charAt(y)-'0');
        
        while(!q.isEmpty()) {
            Node tmp = q.poll();
            
            for(int i=0; i<4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                
                if(nx <0 || nx >= w || ny <0 || ny >= h) continue;
                if(visit[nx][ny] || map[nx].charAt(ny) == 'X') continue;
                
                q.add(new Node(nx,ny));
                visit[nx][ny] = true;
                sum += (map[nx].charAt(ny)-'0');
            }
        }
        
        return sum;
    }
}

class Node{
    int x, y;
    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}