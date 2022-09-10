package Beakjoon.bj1516_게임개발_DP_위상정렬;

import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visit;
    static int[] dp;
    static int[] depth;
    static int[] time;
    static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws NumberFormatException, IOException {
        N = Integer.parseInt(br.readLine());

        String[] s;
        dp = new int[N+1];
        depth = new int[N+1];
        visit = new boolean[N+1];
        time = new int[N+1];
        for(int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<N; i++) {
            s = br.readLine().split(" ");
            dp[i+1] = Integer.parseInt(s[0]);
            time[i+1] = dp[i+1];
            if(s.length > 2) {
                for(int j=1; j<s.length-1; j++) {
                    int tmp = Integer.parseInt(s[j]);
                    graph.get(tmp).add(i+1);
                    depth[i+1]++;
                }
            }
        }


        for(int i=1; i<=N; i++) {
            if(depth[i] == 0) {
                queue.add(i);
                visit[i] = true;
            }
        }


        while(!queue.isEmpty()) {
            int tmp = queue.poll();
            int tmptime = Math.max(time[tmp], dp[tmp]);
            for(Integer x : graph.get(tmp)) {
                if(!visit[x]) {
                    depth[x]--;
                    if(depth[x] == 0) {
                        queue.add(x);
                        visit[x] = true;
                    }
                    dp[x] = Math.max(dp[x], (time[x]+tmptime));
                }
            }
        }



        for(int i=1; i<=N; i++) {
            System.out.println(dp[i]);
        }
    }
}