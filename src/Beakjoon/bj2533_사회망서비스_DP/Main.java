package Beakjoon.bj2533_사회망서비스_DP;
import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[][] dp;
    static boolean[] visit;
    public static void main(String[] args) throws NumberFormatException, IOException {
        N = Integer.parseInt(br.readLine());


        String s[];
        dp = new int[N+1][2];
        visit = new boolean[N+1];

        for(int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<N-1; i++) {
            s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        dfs(1);

        System.out.println(Math.min(dp[1][0], dp[1][1]));

    }

    static void dfs(int x) {
        visit[x] = true;
        dp[x][1] = 1;

        for(int tmp : graph.get(x)) {
            if(!visit[tmp]) {
                dfs(tmp);

                dp[x][0] += dp[tmp][1]; // 내가 얼리어답터가 아니라면 무조건 자식은 얼리어답터여야 함. 자식이 얼리어답터 일때까지 도달한 얼리어답터의 개수를 더해준다.
                dp[x][1] += Math.min(dp[tmp][0], dp[tmp][1]); // 내가 얼리어답터라면, 자식이 얼리어답터가 아닐때와 얼리어답터 둘중 아무거나 상관없으니 둘중 최소값을 선택함.
            }
        }
    }
    
}
