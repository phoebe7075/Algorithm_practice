package Beakjoon.bj3190;

import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static int N;
    static int ans = 0;
    static int r=0, c=0;
    static int dir = 0;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean flag = false;
    static Deque<Dot> dq = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        dq.addLast(new Dot(r,c));
        int apple = Integer.parseInt(br.readLine());
        String s[];
        for(int i=0; i<apple; i++) {
            s = br.readLine().split(" ");
            arr[Integer.parseInt(s[0])-1][Integer.parseInt(s[1])-1] = 1;
        }
        int changeDir = Integer.parseInt(br.readLine());
        Map<Integer, String> map = new HashMap<>();
        for(int i=0; i<changeDir; i++) {
            s = br.readLine().split(" ");
            map.put(Integer.parseInt(s[0]), s[1]);
        }

        while (!flag){
            ans++;
            r = r+dx[dir];
            c = c+dy[dir];

            if(r < 0 || r > N-1 || c < 0 || c > N-1){
                flag = true;
                break;
            }
            if(contains(new Dot(r,c))) {
                flag = true;
                break;
            }

            if(arr[r][c] == 1) {
                dq.addLast(new Dot(r,c));
                arr[r][c] = 0;
            }else {
                dq.addLast(new Dot(r,c));
                dq.removeFirst();
            }

            //print();
            String tmp = map.getOrDefault(ans, "none");
            if(tmp.equals("D")) {
                dir = (dir+1)%4;
            }else if (tmp.equals("L")) {
                dir = (dir+3)%4;
            }

        }
        System.out.println(ans);
    }
    static void print() {
        System.out.println("===="+ans+"초 째===========");
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(contains(new Dot(i,j))) {
                    System.out.print("2 ");
                }else{
                    System.out.print(arr[i][j] + " ");
                }
            }
            System.out.println();
        }
        System.out.println("===========================");
    }

    static boolean contains(Dot dot) {
        for (Dot dot1 : dq) {
            if (dot1.x == dot.x && dot1.y == dot.y) {
                return true;
            }
        }
        return false;
    }
}

class Dot{
    int x;
    int y;

    Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
