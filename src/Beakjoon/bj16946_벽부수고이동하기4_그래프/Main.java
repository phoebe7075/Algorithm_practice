package Beakjoon.bj16946_벽부수고이동하기4_그래프;
import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, m;
    static int[][] arr;
    static int[][] ans;
    static int[][] zeroarr;
    static int[] list = new int[500000];
    static int index=1;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};
    static boolean[][] visit;
    public static void main(String[] args) throws NumberFormatException, IOException {
        String s[];
        s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        arr = new int[n][m];
        ans = new int[n][m];

        String s1;
        for(int i=0; i<n; i++) {
            s1 = br.readLine();
            for(int j=0; j<m; j++) {
                arr[i][j] = s1.charAt(j)-'0';
            }
        }
        visit = new boolean[n][m];
        zeroarr = new int[n][m];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(arr[i][j] == 0 && !visit[i][j]) {
                    bfs(i,j, index++);
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(arr[i][j] == 1) {
                    int tmp1 = 1;
                    int[] tmparr = new int[4];
                    for(int k=0; k<4; k++) {
                        int nx = i+dx[k], ny = j+dy[k];
                        if(nx < 0 || nx > n-1 || ny < 0 || ny > m-1) continue;
                        if(arr[nx][ny] == 1) continue;
                        if(check(tmparr, zeroarr[nx][ny])) continue;
                        tmparr[k] = zeroarr[nx][ny];
                        tmp1 += list[zeroarr[nx][ny]-1];
                    }
                    sb.append(tmp1%10);
                }else {
                    sb.append("0");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    static boolean check(int[] checkarr, int x) {
        for(int i=0; i<3; i++) {
            if(checkarr[i] == x) {
                return true;
            }
        }
        return false;
    }

    static void bfs(int x, int y, int idx) {
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x,y));
        visit[x][y] = true;
        while(!queue.isEmpty()) {
            Node tmp = queue.poll();

            zeroarr[tmp.x][tmp.y] = idx;
            list[idx-1]++;
            for(int i=0; i<4; i++) {
                int nx = tmp.x+dx[i], ny = tmp.y+dy[i];

                if(nx < 0 || nx > n-1 || ny < 0 || ny > m-1) continue;
                if(visit[nx][ny] || arr[nx][ny] == 1) continue;

                visit[nx][ny] = true;
                queue.add(new Node(nx,ny));
            }
        }
    }
    
}
class Node {
    int x, y;
    Node(int x, int y) {
        this.x =x;
        this.y =y;
    }
}
