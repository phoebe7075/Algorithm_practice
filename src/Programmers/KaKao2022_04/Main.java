package Programmers.KaKao2022_04;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(6, new int[][]{{1, 2, 3}, {2, 3, 5}, {2, 4, 2}, {2, 5, 4}, {3, 4, 4}, {4, 5, 3}, {4, 6, 1}, {5, 6, 1}},
                new int[]{1,3}, new int[]{5});
    }
}

class Solution {
    static ArrayList<ArrayList<Node>> list = new ArrayList<>();
    static int dest[];
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = new int[]{-1,10000001};
        for(int i=0; i<=n; i++) {
            list.add(new ArrayList<Node>());
        }
        for(int i=0; i<paths.length; i++) {
            list.get(paths[i][0]).add(new Node(paths[i][1],paths[i][2]));
            list.get(paths[i][1]).add(new Node(paths[i][0],paths[i][2]));
        }
        boolean[] visit = new boolean[n+1];
        dest = new int[n+1];
        Arrays.fill(dest,10000001);

        Arrays.sort(summits);
        bfs(n,summits,gates);

        for(int i=0; i<summits.length; i++) {
            if(dest[summits[i]] < answer[1]) {
                answer[0] = summits[i];
                answer[1] = dest[summits[i]];
            }
        }


        return answer;
    }

    public void bfs(int size, int[] summits, int[] gates) {
        PriorityQueue<Node> queue = new PriorityQueue<>();


        boolean[] visit = new boolean[size+1];
        for(int i=0; i<gates.length; i++) {
            queue.add(new Node(gates[i],0));
            dest[gates[i]] = 0;
        }
        while(!queue.isEmpty()) {
            Node tmp = queue.poll();
            if(visit[tmp.x]) continue;
            visit[tmp.x] = true;
            if(dest[tmp.x] > tmp.w) dest[tmp.x] = tmp.w;

            if(isSummit(summits,tmp.x)) continue;
            for(Node x : list.get(tmp.x)) {
                if(!visit[x.x]) {
                    queue.add(new Node(x.x,Math.max(x.w,tmp.w)));
                }
            }
        }
    }


    public boolean isSummit(int[] summit, int x) {
        for(int i=0; i<summit.length; i++) {
            if(summit[i] == x) {
                return true;
            }
        }
        return false;
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
        return w - o.w;
    }
}