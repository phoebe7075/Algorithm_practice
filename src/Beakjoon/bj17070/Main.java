package Beakjoon.bj17070;

import java.io.*;
import java.util.*;
public class Main {
    static int arr[][];
    static int N;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        String s[];
        for(int i=0; i<N; i++) {
            s = br.readLine().split(" ");
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }
        if(arr[N-1][N-1] == 1) {
            System.out.println(0);
            return;
        }
        bfs();
        System.out.println(ans);
    }

    static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0,1, 0));

        while (!queue.isEmpty()) {
            Node x = queue.poll();
            if(x.x == N-1 && x.y == N-1) {
                ans++;
                continue;
            }

            switch (x.state) {
                case 0: { //가로
                    if(x.y < N-1) {
                        if(arr[x.x][x.y+1] == 0)
                            queue.add(new Node(x.x,x.y+1,0));
                    }

                    if(x.x < N-1 && x.y < N-1) {
                        if(arr[x.x+1][x.y+1] == 0 && arr[x.x+1][x.y] == 0 && arr[x.x][x.y+1] == 0)
                            queue.add(new Node(x.x+1,x.y+1,2));
                    }
                    break;
                }
                case 1: { //세로
                    if(x.x < N-1) {
                        if(arr[x.x+1][x.y] == 0)
                            queue.add(new Node(x.x+1,x.y,1));
                    }

                    if(x.x < N-1 && x.y < N-1) {
                        if(arr[x.x+1][x.y+1] == 0 && arr[x.x+1][x.y] == 0 && arr[x.x][x.y+1] == 0)
                            queue.add(new Node(x.x+1,x.y+1,2));
                    }
                    break;
                }
                case 2: { //대각선 오른쪽 아래
                    if(x.y < N-1) {
                        if(arr[x.x][x.y+1] == 0)
                            queue.add(new Node(x.x,x.y+1,0));
                    }
                    if(x.x < N-1) {
                        if(arr[x.x+1][x.y] == 0)
                            queue.add(new Node(x.x+1,x.y,1));
                    }
                    if(x.x < N-1 && x.y < N-1) {
                        if(arr[x.x+1][x.y+1] == 0 && arr[x.x+1][x.y] == 0 && arr[x.x][x.y+1] == 0)
                            queue.add(new Node(x.x+1,x.y+1,2));
                    }
                    break;
                }
            }
        }
    }
}

class Node {
    int x, y, state;
    Node(int x, int y, int state) {
        this.x = x;
        this.y = y;
        this.state = state;
    }
}
