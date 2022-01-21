package Beakjoon.bj1753;


import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Pair> graph[];
    static int V,E;
    static int start;
    static int cost[];
    static boolean visit[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s[] = br.readLine().split(" ");
        V = Integer.parseInt(s[0]);
        E = Integer.parseInt(s[1]);
        graph = new ArrayList[V+1];
        visit = new boolean[V+1];
        for(int i=0; i<V+1; i++) {
            graph[i] = new ArrayList<>();
        }
        start = Integer.parseInt(br.readLine());
        cost = new int[V+1];
        int u, v, w;
        for(int i=0; i<E; i++) {
            s = br.readLine().split(" ");
            u = Integer.parseInt(s[0]);
            v = Integer.parseInt(s[1]);
            w = Integer.parseInt(s[2]);
            graph[u].add(new Pair(v,w));
        }

        for(int i=0; i<V+1; i++) {
            cost[i] = Integer.MAX_VALUE;
        }
        cost[start] = 0;
        StringBuilder sb = new StringBuilder();
        dijkstra();
        for(int i=1; i<V+1; i++) {
            if(cost[i] == Integer.MAX_VALUE) {
                sb.append("INF\n");
            }else{
                sb.append(cost[i]+"\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void dijkstra() {
        PriorityQueue<Pair> queue = new PriorityQueue<>();
        queue.add(new Pair(start,0));
        while (!queue.isEmpty()) {
            Pair tmp = queue.poll();
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