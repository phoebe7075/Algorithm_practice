package Programmers.lv2_리코쳇로봇;
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new String[]{"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."}));
    }
}

class Solution {
    static int[][] arr;
    static int gx, gy, sx, sy;
    static int w,h;
    static int[][] visit;
    static int ans = 0;
    public int solution(String[] board) {
        int answer = 0;
        w = board.length;
        h = board[0].length();
        arr = new int[w][h];
        visit = new int[w][h];
        for(int i=0; i<w; i++) {
            for(int j=0; j<h; j++) {
                if(board[i].charAt(j) == 'D') {
                    arr[i][j] = -1;
                } 
                if(board[i].charAt(j) == 'R') {
                    sx = i; sy = j;
                }
                if(board[i].charAt(j) == 'G'){
                    gx = i; gy = j;
                } 
            }
        }
        
        bfs();
        return visit[gx][gy]-1;
    }
    
    static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(sx,sy));
        visit[sx][sy] = 1;
        
        while(!q.isEmpty()) {
            Node tmp = q.poll();
            
            for(int i=0; i<4; i++) {
                int[] next_axis = slip(tmp.x, tmp.y, i);
                if(visit[next_axis[0]][next_axis[1]] > 0) continue;
                
                q.add(new Node(next_axis[0],next_axis[1]));
                visit[next_axis[0]][next_axis[1]] = visit[tmp.x][tmp.y]+1;
            }
        }
    }
    
    static int[] slip(int x, int y, int d) {
        int[] dx = {-1, 0, 1, 0}, dy={0, -1, 0, 1};
        int nx=x, ny=y;
        do {
            x = nx; y = ny;
            nx = nx + dx[d]; ny= ny + dy[d];
            if(nx < 0 || nx >= w || ny < 0 || ny >= h) break;
        }while(arr[nx][ny] != -1);
        
        return new int[]{x, y};
        
    }
}

class Node{
    int x, y;
    Node(int x, int y) {
        this.x=x;
        this.y=y;
    }
}