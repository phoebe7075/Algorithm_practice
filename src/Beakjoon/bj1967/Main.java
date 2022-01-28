package Beakjoon.bj1967;

import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static boolean[] visit;
    static int N;
    static int total, max=0, midx;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i=0; i<N+1; i++) {
            graph.add(new ArrayList<>());
        }
        visit = new boolean[N+1];
        String s[];
        for(int i=0; i<N-1; i++) {
            s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            int w = Integer.parseInt(s[2]);
            graph.get(a).add(new Node(b,w));
            graph.get(b).add(new Node(a,w));
        }
        dfs();
        System.out.println(max);
    }
    static void dfs() {
        dfs(1);
        visit = new boolean[N+1];
        total = 0;
        dfs(midx);
    }

    static void dfs(int v) {
        visit[v] = true;
        if(total > max) {
           max = total;
           midx = v;
        }
        for(Node node : graph.get(v)) {
            if(visit[node.x] == false) {
                total += node.weight;
                dfs(node.x);
                total -= node.weight;
            }
        }
    }
}
class Node{
    int x;
    int weight;

    Node(int x, int w) {
        this.x = x;
        this.weight = w;
    }
}
