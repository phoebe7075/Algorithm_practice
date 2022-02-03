package Beakjoon.bj11725;

import java.io.*;
import java.util.ArrayList;

public class Main {
    static ArrayList<ArrayList<Integer>> graph = new java.util.ArrayList<>();
    static int visit[];
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        visit = new int[N+1];
        for(int i=0; i<N+1; i++) {
            graph.add(new ArrayList<>());
        }
        String s[];
        for(int i=0; i<N-1; i++) {
            s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        visit[1] = 1;
        dfs(1);
        StringBuilder sb = new StringBuilder();
        for(int i=2; i<N+1; i++) {
            sb.append(visit[i] + "\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void dfs(int n) {
        for(int x : graph.get(n)) { //x는 자식 혹은 n의 부모
            if(visit[x] == 0) { //n의 부모는 이미 마킹되었기 때문에 정해지지 않았다면 자식이 됨.
                visit[x] = n;
                dfs(x);
            }
        }
    }
}
