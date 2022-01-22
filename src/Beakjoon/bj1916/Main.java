package Beakjoon.bj1916;

import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Pair> graph[];
    static int V,E;
    static int start, end;
    static int cost[];
    static boolean visit[];
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s[];
        V = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());
        cost = new int[V+1];
        graph = new ArrayList[V+1];
        visit = new boolean[V+1];
        for(int i=0; i<V+1; i++) {
            graph[i] = new ArrayList<>();
        }
        int u, v, w;
        for(int i=0; i<E; i++) {
            s = br.readLine().split(" ");
            u = Integer.parseInt(s[0]);
            v = Integer.parseInt(s[1]);
            w = Integer.parseInt(s[2]);
            graph[u].add(new Pair(v,w));
        }
        s = br.readLine().split(" ");
        start = Integer.parseInt(s[0]);
        end = Integer.parseInt(s[1]);
        for(int i=0; i<V+1; i++) {
            cost[i] = Integer.MAX_VALUE;
        }
        cost[start] = 0;
        dijkstra();
    }

    static void dijkstra() {
        PriorityQueue<Pair> queue = new PriorityQueue<>();
        queue.add(new Pair(start,0));
        while (!queue.isEmpty()) {
            Pair tmp = queue.poll();
            if(tmp.x == end) {
                System.out.println(tmp.cost);
                break;
            }
            if(visit[tmp.x]) {
                continue;
            }
            visit[tmp.x] = true;

            for(Pair closeNode : graph[tmp.x]) {
                if(cost[closeNode.x] > cost[tmp.x] + closeNode.cost) { //만약 다음 노드를 찾는데 현재까지의 최단거리 + 가야할 거리보다 기록된 거리가 길 경우 이 경로가 최소경로가 된다.
                    cost[closeNode.x] = cost[tmp.x] + closeNode.cost;
                    queue.add(new Pair(closeNode.x,cost[closeNode.x]));
                }
            }
        }
    }
}

class Pair implements Comparable<Pair>{
    int cost;
    int x;

    Pair(int x, int cost) {
        this.cost = cost;
        this.x = x;
    }

    @Override
    public int compareTo(Pair o) {
        return cost - o.cost;
    }
}
