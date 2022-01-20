package Beakjoon.old.bj1389;


import java.io.*;

public class Main {
    static int[][] graph;
    static boolean[] visit;
    static int[] bacon;
    static int V,E;
    static int idx;
    static boolean end = false;
    static int ans[] = new int[2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");
        V = Integer.parseInt(s[0]);
        E = Integer.parseInt(s[1]);
        graph = new int[V+1][V+1];
        visit = new boolean[V+1];
        bacon = new int[V+1];
        for(int i=0; i<E; i++) {
            s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            graph[x][y] = graph[y][x] = 1;
        }
        for(int i=1; i<=V; i++){
            for(int j=1; j <= V; j++) {
                if(i != j && graph[i][j] == 0) {
                    graph[i][j] = graph[j][i] = 1000000;
                }
            }
        }
        ans[1] = Integer.MAX_VALUE;
        floyd_Warshall();
        for(int i=1; i<=V; i++){
            for(int j=1; j <= V; j++) {
                bacon[i] += graph[i][j];
            }
        }
        for(int i=1; i<=V; i++){
            if(ans[1] > bacon[i]) {
                ans[0] = i;
                ans[1] = bacon[i];
            }
        }

        System.out.println(ans[0]);
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
