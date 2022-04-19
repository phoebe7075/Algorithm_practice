package Programmers.Webdev03;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(8,new int[][]{{0,1}, {1,2}, {2,3}, {4,0}, {5,1},{6,1},{7,2},{7,3},{4,5},{5,6},{6,7}},4,0,3));
    }
}
class Solution {
    static boolean[] edgevisit;
    static int cap, endNode;
    static ArrayList<ArrayList<Integer>> arr;
    static int[][] edge;
    public int solution(int n, int[][] edges, int k, int a, int b) {
        int answer = 0;
        edgevisit = new boolean[edges.length];
        cap = k;
        endNode = b;
        arr = new ArrayList<>();
        edge = edges;

        for(int i=0; i<n; i++) {
            arr.add(new ArrayList<>());
        }
        for(int i=0; i<edges.length; i++) {
            arr.get(edges[i][0]).add(edges[i][1]);
            arr.get(edges[i][1]).add(edges[i][0]);
        }

        backT(a,1,new boolean[edges.length], new boolean[n]);
        for(int i=0; i<edges.length; i++) {
            if(edgevisit[i])
                answer++;
        }
        return answer;
    }

    public void backT(int node, int n, boolean[] visit, boolean[] nodes) {
        if(n > cap) {
            return;
        }

        if(node == endNode) {
            for(int i=0; i<visit.length; i++) {
                if(visit[i]) edgevisit[i] = true;
            }
            return;
        }
        nodes[node] = true;
        for(int x : arr.get(node)) {
            if(!nodes[x]) {
                visit[search(node,x)] = true;
                backT(x,n+1,visit, nodes.clone());
            }

        }

    }

    public int search(int node, int next) {
        for(int i=0; i<edge.length; i++) {
            if( (edge[i][0] == node && edge[i][1] == next) || (edge[i][1] == node && edge[i][0] == next)) {
                return i;
            }
        }

        return -1;
    }
}