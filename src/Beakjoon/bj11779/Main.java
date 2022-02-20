package Beakjoon.bj11779;

import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Pair> graph[];
    static int V,E;
    static int start, end;
    static long cost[];
    static boolean visit[];
    static long INF;
    static int[] dest;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s[];
        V = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());
        graph = new ArrayList[V+1];
        visit = new boolean[V+1];
        dest = new int[V+1];
        for(int i=0; i<V+1; i++) {
            graph[i] = new ArrayList<>();
        }
        cost = new long[V+1];
        INF = V * 100000 + 1;
        int u, v;
        long w;
        for(int i=0; i<E; i++) {
            s = br.readLine().split(" ");
            u = Integer.parseInt(s[0]);
            v = Integer.parseInt(s[1]);
            w = Long.parseLong(s[2]);
            graph[u].add(new Pair(v,w));
        }
        s = br.readLine().split(" ");
        start = Integer.parseInt(s[0]);
        end = Integer.parseInt(s[1]);
        for(int i=0; i<V+1; i++) {
            cost[i] = INF;
        }
        cost[start] = 0l;

        dijkstra();
        sb.append(cost[end] + "\n");
        Stack<Integer> stack = new Stack<>();
        int x = end;
        while (x != 0) {
            stack.push(x);
            x = dest[x];
        }
        sb.append(stack.size() + "\n");
        while (!stack.isEmpty()) {
            x = stack.pop();
            sb.append(x + " ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void dijkstra() {
        PriorityQueue<Pair> queue = new PriorityQueue<>();
        queue.add(new Pair(start,0l));
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
                    dest[closeNode.x] = tmp.x;
                }
            }
        }
    }
}

class Pair implements Comparable<Pair>{
    long cost;
    int x;

    Pair(int x, long cost) {
        this.cost = cost;
        this.x = x;
    }

    @Override
    public int compareTo(Pair o) {
        return (int)(cost - o.cost);
    }
}
