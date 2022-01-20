package Beakjoon.old.bj14499;

import java.io.*;

public class Main {
    static int[][] arr;
    static int[] square = new int[6];
    static int N,M;
    static int ans = 0;
    static int x=0, y=0;
    static int dir = 0;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");
        int K;
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        x = Integer.parseInt(s[2]);
        y = Integer.parseInt(s[3]);
        K = Integer.parseInt(s[4]);
        arr = new int[N][M];
        for(int i=0; i<N; i++) {
            s = br.readLine().split(" ");
            for(int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }

        s = br.readLine().split(" ");
        for(int i=0; i<K; i++) {
            int n = Integer.parseInt(s[i]);

            int nextX = x +dx[n-1];
            int nextY = y + dy[n-1];

            if(nextX < 0 || nextX > N-1 || nextY < 0 || nextY > M-1)
                continue;

            int tmp[] = new int[6];
            if(n==1) {
                tmp[0] = square[3];
                tmp[1] = square[1];
                tmp[2] = square[0];
                tmp[3] = square[5];
                tmp[4] = square[4];
                tmp[5] = square[2];
                for(int j=0; j<6; j++) {
                    square[j] = tmp[j];
                }
            }else if(n==2) {
                tmp[0] = square[2];
                tmp[1] = square[1];
                tmp[2] = square[5];
                tmp[3] = square[0];
                tmp[4] = square[4];
                tmp[5] = square[3];
                for(int j=0; j<6; j++) {
                    square[j] = tmp[j];
                }
            }else if (n==3) {
                tmp[0] = square[4];
                tmp[1] = square[0];
                tmp[2] = square[2];
                tmp[3] = square[3];
                tmp[4] = square[5];
                tmp[5] = square[1];
                for(int j=0; j<6; j++) {
                    square[j] = tmp[j];
                }
            }else {
                tmp[0] = square[1];
                tmp[1] = square[5];
                tmp[2] = square[2];
                tmp[3] = square[3];
                tmp[4] = square[0];
                tmp[5] = square[4];
                for(int j=0; j<6; j++) {
                    square[j] = tmp[j];
                }
            }
            if(arr[nextX][nextY] == 0) {
                arr[nextX][nextY] = square[5];
                //print();
            }else{
                square[5] = arr[nextX][nextY];
                arr[nextX][nextY] = 0;
            }
            x = nextX; y = nextY;
            //print(n);
            System.out.println(square[0]);
        }

    }
    static void print(int n) {
        System.out.println("명령 " + n + "에 대한 주사위 ================");
        for(int j=0; j<6; j++) {
            System.out.print(square[j] + " ");
        }
        System.out.println();
    }

    static void print() {
        System.out.println("판 숫자가 바뀜 ==============");
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("========================");
    }
}
