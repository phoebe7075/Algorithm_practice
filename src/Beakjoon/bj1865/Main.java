package Beakjoon.bj1865;

import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Node> graph = new ArrayList<>();
    static int cost[];
    static int N, M, W;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TK = Integer.parseInt(br.readLine());
        for(int k=0; k<TK; k++) {
            String s[];
            s = br.readLine().split(" ");
            N = Integer.parseInt(s[0]);
            M = Integer.parseInt(s[1]);
            W = Integer.parseInt(s[2]);
            graph = new ArrayList<>();
            cost = new int[N+1];
            int a,b,w;
            for(int i=0; i<M; i++) {
                s = br.readLine().split(" ");
                a = Integer.parseInt(s[0]);
                b = Integer.parseInt(s[1]);
                w = Integer.parseInt(s[2]);
                graph.add(new Node(a,b,w));
                graph.add(new Node(b,a,w));
            }

            for(int i=0; i<W; i++) {
                s = br.readLine().split(" ");
                a = Integer.parseInt(s[0]);
                b = Integer.parseInt(s[1]);
                w = Integer.parseInt(s[2]);
                graph.add(new Node(a,b,-w));
            }
            if(Bellman_ford(1)) {
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }


    static boolean Bellman_ford(int start) {
        Arrays.fill(cost,500000000);
        cost[start] = 0;
        for(int i=1; i<N; i++) {
            for(int j=0; j<graph.size(); j++) {
                int a = graph.get(j).x;
                int b = graph.get(j).y;
                int w = graph.get(j).weight;

                if(cost[b] > (cost[a] + w)) {
                    cost[b] = cost[a]+w;
                }
            }
        }

        for(int j=0; j<graph.size(); j++) {
            int a = graph.get(j).x;
            int b = graph.get(j).y;
            int w = graph.get(j).weight;

            if(cost[b] > (cost[a] + w)) {
                return true;
            }
        }

        return false;
    }
}
class Node{
    int x;
    int y;
    int weight;
    Node(int x, int y, int w) {
        this.x = x;
        this.y = y;
        this.weight = w;
    }
}
