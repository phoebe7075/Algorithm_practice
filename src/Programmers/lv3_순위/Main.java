package Programmers.lv3_순위;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        solution.solution(8, new int[][]{{1, 2},{2, 3},{3, 4}, {5, 6},{6, 7},{7, 8},{4, 5}});
    }
}

class Solution {
    int[][] distance;
    ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    public int solution(int n, int[][] results) {
        int answer = 0;
        distance = new int[n+1][2];
        for(int i=0; i<=n; i++) {
            list.add(new ArrayList<>());
        }
        for(int[] tmp : results) {
            list.get(tmp[0]).add(tmp[1]);
        }


        for(int i=1; i<=n; i++) {
            dfs(new boolean[n+1],i,i);
        }

        for(int i=1; i<=n; i++) {
            if(distance[i][0]+distance[i][1] == n-1) {
                answer++;
            }
        }
        return answer;
    }

    public void dfs(boolean[] visit, int v, int n) {
        visit[v] = true;
        if(v != n) {
            distance[n][1]++;
            distance[v][0]++;
        }
        for(int x : list.get(v)) {
            if(!visit[x]) {
                dfs(visit,x,n);
            }
        }
    }
}