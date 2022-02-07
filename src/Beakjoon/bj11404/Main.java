package Beakjoon.bj11404;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    static int N, M;
    static ArrayList<Node> graph[];
    static int cost[][];
    static int INF = 20000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        cost = new int[N+1][N+1];
        graph = new ArrayList[N+1];
        for(int i=0; i<=N; i++) {
            graph[i] = new ArrayList<>();
            Arrays.fill(cost[i],INF);
        }
        String s[];
        for(int i=0; i<M; i++) {
            s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            int w = Integer.parseInt(s[2]);
            Node node = new Node(y,w);
            graph[x].add(node);
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        floyd_warshall();
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                if(i==j) {
                    sb.append(0 + " ");
                }
                else if(cost[i][j] < INF) {
                    sb.append(cost[i][j] + " ");
                }
                else {
                    sb.append(0 + " ");
                }

            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }

    static void floyd_warshall() {
        for(int i=1; i<=N; i++) { //비용 배열 초기화
            for(Node node : graph[i]) {
                cost[i][node.end] = Math.min(cost[i][node.end],node.weight);
            }
        }


        for(int k=1; k<=N; k++) {
            for(int i=1; i<=N; i++) {
                for(int j=1; j<=N; j++) {
                    if(cost[i][k] + cost[k][j] < cost[i][j]) {
                        cost[i][j] = cost[i][k] + cost[k][j];
                    }
                }
            }
        }
    }
}

class Node{
    int end, weight;

    Node(int end, int weight){
        this.end = end;
        this.weight = weight;
    }
}
