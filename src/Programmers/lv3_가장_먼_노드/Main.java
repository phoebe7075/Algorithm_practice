package Programmers.lv3_가장_먼_노드;
import java.util.*;
public class Main {
}

class Solution {
    ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    int[] distance;
    boolean[] visit;
    int INF = 10000000;
    public int solution(int n, int[][] edge) {
        int answer = 0;
        distance = new int[n+1];
        visit = new boolean[n+1];
        for(int i=0; i<=n; i++) {
            list.add(new ArrayList<>());
        }

        for(int[] tmp : edge) {
            list.get(tmp[0]).add(tmp[1]);
            list.get(tmp[1]).add(tmp[0]);
        }

        Arrays.fill(distance, INF);
        distance[0] = 0;
        distance[1] = 0;

        dijkstra();

        Arrays.sort(distance);

        int max = distance[n];
        System.out.println(max);
        for(int i=n; i>0; i--) {
            if(max == distance[i]) answer++;
        }

        return answer;
    }

    public void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.add(new Node(1,0));


        while(!pq.isEmpty()) {
            Node x = pq.poll();

            if(visit[x.y]) continue;
            visit[x.y] = true;
            if(distance[x.y] > x.w) distance[x.y] = x.w;

            for(int tmp : list.get(x.y)) {
                if(!visit[tmp]) {
                    pq.add(new Node(tmp,Math.min(distance[x.y]+1,distance[tmp])));
                }
            }
        }
    }
}

class Node implements Comparable<Node>{
    int y, w;

    Node(int y, int w) {
        this.y = y;
        this.w = w;
    }

    @Override
    public int compareTo(Node x) {
        return this.w - x.w;
    }
}