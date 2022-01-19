package Beakjoon.bj14503;

import java.io.*;

public class Main {
    static int[][] arr;
    static boolean[][] visit;
    static int N, M;
    static int r,c,dir;
    static int ans=0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        s = br.readLine().split(" ");
        r = Integer.parseInt(s[0]);
        c = Integer.parseInt(s[1]);
        dir = Integer.parseInt(s[2]);
        if(dir == 1)
            dir = 3;
        else if (dir == 3)
            dir = 1;
        arr = new int[N][M];
        visit = new boolean[N][M];
        for(int i=0; i<N; i++) {
            s = br.readLine().split(" ");
            for(int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }
        boolean flag = false;
        while (!flag) {
            if(!visit[r][c]){
                visit[r][c] = true;
                ans++;
            }
            //print();
            boolean isClearable = false;
            for(int i=dir+1; i<=dir+4; i++){
                int nextR = r+dx[i%4];
                int nextC = c+dy[i%4];

                if(nextR < 0 || nextR > N || nextC <0 || nextC > M)
                    continue;

                if(!visit[nextR][nextC] && arr[nextR][nextC] == 0){
                    dir = i%4;
                    r = nextR;
                    c = nextC;
                    isClearable = true;
                    break;
                }
            }
            if(!isClearable){
                int backR = r+dx[(dir+2)%4];
                int backC = c+dy[(dir+2)%4];
                if(arr[backR][backC] == 1) {
                    flag = true;
                    continue;
                }
                r = backR;
                c = backC;
            }
        }

        System.out.println(ans);
    }

    static void print() {
        System.out.println("===== " + ans + " 번째 =====================");
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                System.out.print(visit[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("================================");
    }
}
