package Beakjoon.bj1707_이분그래프_그래프;
import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<ArrayList<Integer>> graph;
    static int[] visit;
    static int nV, nE;
    public static void main(String[] args) throws NumberFormatException, IOException {

        int tc = Integer.parseInt(br.readLine());

        for(int t=0; t<tc; t++) {
            String s[];
            graph = new ArrayList<>();
            s = br.readLine().split(" ");
            nV = Integer.parseInt(s[0]);
            nE = Integer.parseInt(s[1]);

            for(int i=0; i<=nV; i++) {
                graph.add(new ArrayList<>());
            }
            visit = new int[nV+1];
            Arrays.fill(visit, -1);
            for(int i=0; i<nE; i++) {
                s = br.readLine().split(" ");
                int x, y;
                x = Integer.parseInt(s[0]);
                y = Integer.parseInt(s[1]);

                graph.get(x).add(y);
                graph.get(y).add(x);
            }
            System.out.println(bfs() ? "YES" : "NO");
        }
    }

    static boolean bfs() {
        Queue<Integer> q = new LinkedList<>();

        for(int i=1; i<=nV; i++) {
            if(visit[i] == -1) {
                q.add(i);
                visit[i] = 1;
            }
            
            while(!q.isEmpty()){
                int tmp = q.poll();
    
                for(int x : graph.get(tmp)) {
                    if(visit[x]==-1) {
                        visit[x] = (visit[tmp]+1)%2;
                        q.add(x);
                    }else if(visit[x] == visit[tmp]) {
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
}
