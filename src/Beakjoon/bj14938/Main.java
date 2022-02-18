package Beakjoon.bj14938;

import java.io.*;
import java.util.ArrayList;

public class Main {
    static int items[];
    static ArrayList<Node> graph[];
    static int N, M, range;
    static int cost[][];
    static int INF = 10000000;
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[2]);
        range = Integer.parseInt(s[1]);
        items = new int[N+1];
        graph = new ArrayList[N+1];
        graph[0] = new ArrayList<>();
        s = br.readLine().split(" ");
        for(int i=1; i<=N; i++) {
            items[i] = Integer.parseInt(s[i-1]);
            graph[i] = new ArrayList<>();
        }


        for(int i=0; i<M; i++) {
            s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            int w = Integer.parseInt(s[2]);

            graph[x].add(new Node(y,w));
            graph[y].add(new Node(x,w));
        }
        cost = new int[N+1][N+1];
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                if(i == j) {
                    cost[i][j] = 0;
                }else {
                    cost[i][j] = INF;
                }
            }
        }

        for(int i=1; i<=N; i++) {
            for (Node x : graph[i]) {
                cost[i][x.y] = x.weight;
            }
        }
        floyd_warshall();

        for(int i=1; i<=N; i++) {
            int tmp = 0;
            for(int j=1; j<=N; j++) {
                if(cost[i][j] <= range) {
                    tmp += items[j];
                }
            }
            if(tmp > ans) {
                ans = tmp;
            }
        }
        System.out.println(ans);
    }

    static void floyd_warshall() {
        for(int k=1; k<=N; k++) {
            for(int i=1; i<=N; i++) {
                for(int j=1; j<=N; j++) {
                    if(cost[i][k] + cost[k][j] < cost[i][j]) {
                        cost[i][j] = cost[i][k]+cost[k][j];
                    }
                }
            }
        }
    }
}
class Node {
    int y, weight;
    Node(int y, int weight) {
        this.y = y;
        this.weight = weight;
    }
}