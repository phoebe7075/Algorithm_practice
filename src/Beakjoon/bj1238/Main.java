package Beakjoon.bj1238;

import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static boolean[] visit;
    static int cost[];
    static int N, M, X;
    static int Max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[];
        s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        X = Integer.parseInt(s[2]);
        for(int i=0; i<N+1; i++) {
            graph.add(new ArrayList<>());
        }

        cost = new int[N+1];
        for(int i=0; i<M; i++) {
            s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            int w = Integer.parseInt(s[2]);
            graph.get(a).add(new Node(b,w));
        }
        for(int k=1; k<N+1; k++) {
            for(int i=0; i<N+1; i++) {
                cost[i] = Integer.MAX_VALUE;
            }
            cost[k] = 0;
            visit = new boolean[N+1];
            djikstra(k, X);
            for(int i=0; i<N+1; i++) {
                if(i != X) {
                    cost[i] = Integer.MAX_VALUE;
                }
            }
            visit = new boolean[N+1];
            djikstra(X, k);

            if(cost[k] > Max) {
                Max = cost[k];
            }
        }

        System.out.println(Max);
    }


    static void djikstra(int start, int end) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start,0));

        while (!queue.isEmpty()) {
            Node tmp = queue.poll();
            if(tmp.x == end) {
                break;
            }
            if(visit[tmp.x]) {
                continue;
            }

            visit[tmp.x] = true;
            for(Node node : graph.get(tmp.x)) {
                if(cost[node.x] > cost[tmp.x] + node.weight) {
                    cost[node.x] = cost[tmp.x] + node.weight;
                    queue.add(new Node(node.x,cost[node.x]));
                }
            }
        }

    }
}
class Node implements Comparable<Node>{
    int x;
    int weight;

    Node(int x, int w) {
        this.x = x;
        this.weight = w;
    }


    @Override
    public int compareTo(Node o) {
        return weight - o.weight;
    }
}
