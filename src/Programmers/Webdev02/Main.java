package Programmers.Webdev02;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new String[]{"??b", "abc", "cc?"}));
    }
}


class Solution {
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, -1, 0, 1};
    static int count = 0;
    static char[] arr;
    static char[] x = {'a','b','c'};
    static int w,h;
    static String[] grids;
    static int ans = 0;
    public int solution(String[] grid) {
        int answer = -1;
        h = grid.length;
        w = grid[0].length();
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j < grid[i].length(); j++) {
                if(grid[i].charAt(j) == '?') count++;
            }
        }
        arr = new char[count];
        grids = grid;

        backT(0);
        answer = ans;
        return answer;
    }


    public void backT(int n) {
        if(n == count) {
            int tmp[][] = new int[h][w];
            int idx = 0;
            for(int i=0; i<h; i++) {
                for(int j=0; j < w; j++) {
                    if(grids[i].charAt(j) == 'a') {
                        tmp[i][j] = 1;
                    }else if (grids[i].charAt(j) == 'b') {
                        tmp[i][j] = 2;
                    }else if (grids[i].charAt(j) == 'c') {
                        tmp[i][j] = 3;
                    }else if (grids[i].charAt(j) == '?') {
                        tmp[i][j] = arr[idx++]-'a'+1;
                    }
                }
            }

            if(dfs(tmp)){
                ans++;
            }
            return;
        }


        for(int i=0; i<3; i++) {
            arr[n] = x[i];
            backT(n+1);
        }
    }

    public boolean dfs(int[][] tmp) {
        boolean flag = false;
        outerLoop :
        for(int i=0; i<h; i++) {
            for(int j=0; j<w; j++) {
                if(tmp[i][j] == 1) {
                    flag = dfs(tmp, i,j, 1);
                    break outerLoop;
                }
            }
        }

        if(flag) {
            return false;
        }
        outerLoop :
        for(int i=0; i<h; i++) {
            for(int j=0; j<w; j++) {
                if(tmp[i][j] == 2) {
                    flag = dfs(tmp, i,j, 2);
                    break outerLoop;
                }
            }
        }

        if(flag) {
            return false;
        }
        outerLoop :
        for(int i=0; i<h; i++) {
            for(int j=0; j<w; j++) {
                if(tmp[i][j] == 3) {
                    flag = dfs(tmp, i,j, 3);
                    break outerLoop;
                }
            }
        }

        if(flag) {
            return false;
        }

        return true;
    }


    public boolean dfs(int[][] tmp, int x, int y, int n) {
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visit = new boolean[h][w];
        queue.add(new Node(x,y));
        tmp[x][y] = 0;
        visit[x][y] = true;

        while(!queue.isEmpty()) {
            Node next = queue.poll();

            for(int i=0; i<4; i++) {
                int nx = next.x + dx[i];
                int ny = next.y + dy[i];

                if(nx <0 || nx > h-1 || ny < 0 || ny > w-1)
                    continue;

                if(visit[nx][ny] || tmp[nx][ny] != n)
                    continue;

                queue.add(new Node(nx,ny));
                tmp[nx][ny] = 0;
                visit[nx][ny] = true;
            }
        }

        if(search(tmp, n)) {
            return true;
        }else {
            return false;
        }
    }

    public boolean search(int[][] tmp, int n) {
        for(int i=0; i<h; i++) {
            for(int j=0; j<w; j++) {
                if(tmp[i][j] == n) {
                    return true;
                }
            }
        }
        return false;
    }
}

class Node{
    int x, y;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
