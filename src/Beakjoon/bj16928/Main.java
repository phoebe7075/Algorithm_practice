package Beakjoon.bj16928;

import java.io.*;
import java.util.*;
public class Main {
    static int arr[];
    static int ladder[][];
    static int snake[][];
    static int l, sn;
    static boolean visit[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");
        l = Integer.parseInt(s[0]);
        sn = Integer.parseInt(s[1]);
        ladder = new int[l][2];
        snake = new int[sn][2];
        arr = new int[101];
        visit = new boolean[101];
        for(int i=0; i<l; i++) {
            s = br.readLine().split(" ");
            ladder[i][0] = Integer.parseInt(s[0]);
            ladder[i][1] = Integer.parseInt(s[1]);
        }
        for(int i=0; i<sn; i++) {
            s = br.readLine().split(" ");
            snake[i][0] = Integer.parseInt(s[0]);
            snake[i][1] = Integer.parseInt(s[1]);
        }
        bfs();
        System.out.println(arr[100]);
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visit[1] = true;

        while (!queue.isEmpty()){
            int x = queue.poll();

            if(x == 100)
                break;

            for(int i=1; i<=6; i++) {
                int nextX = x+i;
                int y = isSnakeorLadder(nextX);
                if(y != 0) {
                    nextX = y;
                }
                if(valid(nextX) && !visit[nextX]){

                    visit[nextX] = true;
                    arr[nextX] = arr[x]+1;
                    queue.add(nextX);
                }
            }
        }

    }

    static boolean valid(int n) {
        if(n <= 100) {
            return true;
        }else {
            return false;
        }
    }

    static int isSnakeorLadder(int n) {
        for(int i=0; i<sn; i++){
            if(n == snake[i][0]){
              return snake[i][1];
            }
        }
        for(int i=0; i<l; i++) {
            if(n == ladder[i][0]) {
                return ladder[i][1];
            }
        }
        return 0;
    }
}
