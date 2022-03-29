package Programmers.lv2_카카오프렌즈_컬러링북;
import java.util.*;
public class Main {
}

class Solution {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static boolean[][] visit;
    static int height, width;
    public int[] solution(int m, int n, int[][] picture) {
        int number = 0;
        int max = 0;
        visit = new boolean[m][n];
        int[] answer = new int[2];
        height = m; width = n;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(!visit[i][j] && picture[i][j] != 0) {
                    max = Math.max(max, bfs(i,j, picture));
                    number++;
                }
            }
        }


        answer[0] = number;
        answer[1] = max;
        return answer;
    }


    public int bfs(int x, int y, int[][] arr) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x,y));
        visit[x][y] = true;
        int num = arr[x][y];
        int size = 0;
        while(!queue.isEmpty()){
            size++;
            Node tmp = queue.poll();

            for(int i=0; i<4; i++){
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];

                if(nx <0 || nx > (height-1) || ny < 0 || ny > (width-1))
                    continue;
                if(arr[nx][ny] != num)
                    continue;
                if(visit[nx][ny])
                    continue;

                queue.add(new Node(nx,ny));
                visit[nx][ny] = true;
            }
        }

        return size;
    }
}

class Node{
    int x, y;
    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}