package Beakjoon.old.bj11724;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] graph;
    static boolean[] visit;
    static int V, E;
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        graph = new int[V+1][V+1];
        visit = new boolean[V+1];
        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = 1;
            graph[y][x] = 1;
        }
        dfs();
        System.out.println(ans);
    }
    static void dfs() {
        for(int i=1; i < V+1; i++) {
            if (!visit[i]) {
                dfs(i);
                ans++;
            }
        }
    }

    static void dfs(int x) {
        visit[x] = true;
        for(int i=1; i < V+1; i++) {
            if (graph[x][i] != 0 && !visit[i]) {
                dfs(i);
            }
        }
    }
}
