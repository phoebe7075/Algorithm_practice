package Beakjoon.bj2150;

import java.io.*;
import java.util.*;
public class Main {
    static ArrayList<Integer> graph[];
    static ArrayList<Integer> revGraph[];
    static boolean visit[];
    static int V, E;
    static int count = 0;
    static Stack<Integer> stack = new Stack<>();
    static List<List<Integer>> arr = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");
        V = Integer.parseInt(s[0]);
        E = Integer.parseInt(s[1]);
        graph = new ArrayList[V+1];
        revGraph = new ArrayList[V+1];
        for(int i=0; i<V+1; i++) {
            graph[i] = new ArrayList<>();
            revGraph[i] = new ArrayList<>();
        }
        int x, y;
        for(int i=0; i<E; i++) {
            s = br.readLine().split(" ");
            x = Integer.parseInt(s[0]);
            y = Integer.parseInt(s[1]);
            graph[x].add(y);
            revGraph[y].add(x);
        }
        visit = new boolean[V+1];
        for(int i=1; i<=V; i++) {
            if(!visit[i])
                dfs(i);
        }
        visit = new boolean[V+1];

        while (!stack.isEmpty()){
            int top = stack.pop();
            if(visit[top]) continue;
            arr.add(new ArrayList<>());
            dfs2(top);
            count++;
        }
        for(List<Integer> arr1 : arr) {
            Collections.sort(arr1);
        }

        Collections.sort(arr, Comparator.comparingInt(o -> o.get(0)));


        System.out.println(arr.size());
        for(List<Integer> tmp : arr) {
            for(int t : tmp) {
                System.out.print(t + " ");
            }
            System.out.println(-1);
        }
    }

    static void dfs(int n) {
        visit[n] = true;
        for(int x : graph[n]) {
            if(visit[x]) continue;
            dfs(x);
        }
        stack.push(n);
    }

    static void dfs2(int n) {
        visit[n] = true;
        arr.get(count).add(n);
        for(int x: revGraph[n]) {
            if(visit[x]) continue;
            dfs2(x);
        }
    }
}
