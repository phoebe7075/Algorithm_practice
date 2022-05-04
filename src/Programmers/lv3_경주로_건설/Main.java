package Programmers.lv3_경주로_건설;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[][]{{0, 0, 1, 0}, {0, 0, 0, 0}, {0, 1, 0, 1}, {1, 0, 0, 0}}));
    }
}
class Solution {
    static int list[][][];
    static int len;
    static int INF = 100000;
    static int[][] dir = {{0,1,0},{1,0,1},{0,-1,2},{-1,0,3}};
    public int solution(int[][] board) {
        int answer = 0;
        list = new int[4][board.length][board.length];
        len = board.length;

        for(int i=0; i<4; i++) {
            for(int j=0; j<len; j++) {
                Arrays.fill(list[i][j],98765432);
            }
        }
        answer = bfs(board) * 100;
        return answer;
    }

    public int bfs(int[][] board) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0,0,0,0));
        queue.add(new Node(0,0,0,1));

        while(!queue.isEmpty()) {
            Node x = queue.poll();

            for(int i=0; i<4; i++) {
                int nx = x.x + dir[i][0];
                int ny = x.y + dir[i][1];

                if(nx < 0 || nx > len-1 || ny < 0 || ny > len-1 || board[nx][ny] != 0)
                    continue;

                int nw = x.w + 1;

                if(x.d != dir[i][2]) {
                    nw += 5;
                }

                if(nw < list[dir[i][2]][nx][ny]) {
                    list[dir[i][2]][nx][ny] = nw;
                    if(nx == len-1 && ny == len-1)
                        continue;
                    queue.add(new Node(nx,ny,nw,dir[i][2]));
                }
            }
        }

        return Math.min(Math.min(list[0][len-1][len-1],list[1][len-1][len-1]),Math.min(list[2][len-1][len-1],list[3][len-1][len-1]));
    }
}

class Node{
    int x,y, w, d;

    Node(int x,int y, int w, int d) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.d = d;
    }
}