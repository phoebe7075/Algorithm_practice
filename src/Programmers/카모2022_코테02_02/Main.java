package Programmers.카모2022_코테02_02;
import java.util.*;


public class Main {
    
}



class Solution {
    static ArrayList<ArrayList<Integer>> parking = new ArrayList<>();
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static int distance, limitnum, size;
    static int ans = 0;
    public int solution(int n, int[][] edges, int[] users, int d, int limit) {
        distance = d; limitnum = limit; size = n;
        for(int i=0; i<=n; i++) {
            parking.add(new ArrayList<Integer>());
            graph.add(new ArrayList<Node>());
        }
        for(int[] edge : edges) {
            graph.get(edge[0]).add(new Node(edge[1], edge[2]));
            graph.get(edge[1]).add(new Node(edge[0], edge[2]));
        }


        for(int i=0; i<n; i++) {
            if(users[i] > 0) {
                bfs(i+1);
            }
        }
        conv(0, 1, n, new boolean[n+1], users);
        return ans;
    }


    static void bfs(int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        boolean[] visit = new boolean[size+1];

        queue.add(new Node(start, 0));
        

        while(!queue.isEmpty()) {
            Node x = queue.poll();
            if(visit[x.x]) continue;
            parking.get(x.x).add(start);
            visit[x.x] = true;

            for(Node tmp : graph.get(x.x)) {
                if(x.w + tmp.w <= distance && visit[tmp.x] != true) {
                    queue.add(new Node(tmp.x, x.w+tmp.w));
                }
            }
        }
    }


    static void conv(int n, int d, int max, boolean[] visit, int[] user) {
        if(n == 2) {
            int[] tmpuser = new int[max];
            int count = 0;
            for(int i=0; i<max; i++) {
                tmpuser[i] = user[i];
            }
            for(int i=1; i<=max; i++) {
                if(visit[i]) {
                    ArrayList<Integer> arr = parking.get(i);

                    int m = limitnum;

                    for(Integer x : arr) {
                        int minus = m - Math.max(0, m-tmpuser[x-1]);
                        m = Math.max(0, m-tmpuser[x-1]);
                        tmpuser[x-1] -= minus;
                    }

                    count += limitnum-m;
                }
            }
            ans = Math.max(ans, count);
            return;
        }

        for(int i=d; i<=max; i++) {
            if(!visit[i]) {
                visit[i] = true;
                conv(n+1, i+1, max, visit, user);
                visit[i] = false;
            }
        }
    }
}

class Node implements Comparable<Node>{
    int x, w;

    Node(int x, int w) {
        this.x = x;
        this.w = w;
    }

    @Override
    public int compareTo(Node o) {
        return o.w - this.w;
    }
}
/*
pq 이용한 bfs를 이용해서 갈 수 있는 거리를 파악하고
출발노드를 각 노드를 처음 방문할때마다 달아줌.
그렇게 해서 각 노드를 2개씩 뽑아서 가장 큰 숫자를 고르면 됨.

*/