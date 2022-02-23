package Beakjoon.bj15591;

import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Node> graph[];
    static int[][] usado;
    static int V, E;
    static boolean visit[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");
        V = Integer.parseInt(s[0]);
        E = Integer.parseInt(s[1]);
        graph = new ArrayList[V+1];
        usado = new int[V+1][V+1];

        int u, v, w;
        for(int i=0; i<=V; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i=1; i<=V; i++) {
            Arrays.fill(usado[i],Integer.MAX_VALUE);
        }
        for(int i=0; i<V-1; i++) {
            s = br.readLine().split(" ");
            u = Integer.parseInt(s[0]);
            v = Integer.parseInt(s[1]);
            w = Integer.parseInt(s[2]);
            graph[u].add(new Node(v,w));
            graph[v].add(new Node(u,w));
        }
        for(int i=1; i<=V; i++) {
            bfs(i);
        }
        for(int i=0; i<E; i++) {
            s = br.readLine().split(" ");
            int k = Integer.parseInt(s[0]);
            int vi = Integer.parseInt(s[1]);
            System.out.println(usadocheck(k,vi));
        }
    }

    static void bfs(int start) {
        Queue<Node> queue = new LinkedList<>();
        visit = new boolean[V+1];
        visit[start] = true;
        usado[start][start] = 0;
        for(Node x : graph[start]) {
            queue.add(new Node(x.y,x.weight));
            visit[x.y] = true;
            usado[start][x.y] = x.weight;
        }

        while (!queue.isEmpty()) {
            Node tmp = queue.poll();

            for(Node x : graph[tmp.y]) {
                if(visit[x.y])
                    continue;
                usado[start][x.y] = Math.min(tmp.weight, x.weight);
                visit[x.y] = true;
                queue.add(new Node(x.y,usado[start][x.y]));
            }
        }
    }

    static int usadocheck(int k, int video) {
        int count = 0;
        for(int i=1; i<=V; i++) {
            if(usado[video][i] >= k)
                count++;
        }
        return count;
    }
}

class Node{
    int y, weight;
    Node(int y, int weight) {
        this.y =y;
        this.weight = weight;
    }
}
