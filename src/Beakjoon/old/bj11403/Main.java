package Beakjoon.old.bj11403;


import java.io.*;

public class Main {
    static long[][] graph;
    static int[][] ans;
    static int V;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V  = Integer.parseInt(br.readLine());
        graph = new long[V+1][V+1];
        ans = new int[V+1][V+1];



        for(int i=1; i<=V; i++) {
            String s[] = br.readLine().split(" ");
            for(int j=1; j<=V; j++) {
                graph[i][j] = Integer.parseInt(s[j-1]);
            }
        }
        for (int i=1; i<=V; i++) {
            for(int j=1; j<=V; j++) {
                if(graph[i][j] != 1)
                    graph[i][j] = Integer.MAX_VALUE;
            }
        }
        floyd_Warshall();
        StringBuilder sb = new StringBuilder();
        for (int i=1; i<=V; i++) {
            for (int j = 1; j <= V; j++) {
                if(graph[i][j] < Integer.MAX_VALUE) {
                    sb.append("1 ");
                }else {
                    sb.append("0 ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }


    static void floyd_Warshall() {
        for(int k=1; k <= V; k++) {
            for(int i=1; i <= V; i++) {
                for(int j=1; j <= V; j++) {
                    if(graph[i][k] + graph[k][j] < graph[i][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }
    }
}
