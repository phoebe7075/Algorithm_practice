package Beakjoon.bj12851;

import java.io.*;
import java.util.*;
public class Main {
    static int n, m;
    static boolean visit[];
    static int min = Integer.MAX_VALUE;
    static int ans = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        visit = new boolean[100001];
        if(n > m) {
            System.out.println(n-m);
            System.out.println(1);
        }else {
            bfs();
            System.out.println(min);
            System.out.println(ans);
        }
    }
    public static void bfs() {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(n,0));
        visit[n] = true;
        while (!queue.isEmpty()){
            Pair p = queue.poll();
            int aa = p.a;
            int time = p.time;

            visit[aa] = true;
            if (aa == m){
                if(min > time) {
                    min = time;
                }else if(min == time){
                    ans++;
                }
                continue;
            }
            if(aa-1>0 && !visit[aa-1]) {
                queue.add(new Pair(aa-1,time+1));
            }
            if (aa+1<100001 && !visit[aa+1]){
                queue.add(new Pair(aa+1,time+1));
            }
            if (aa*2<100001 && !visit[aa*2]) {
                queue.add(new Pair(aa*2,time+1));
            }
        }
    }
}
class Pair{
    int a;
    int time;

    Pair(int a, int time) {
        this.a = a;
        this.time = time;
    }
}