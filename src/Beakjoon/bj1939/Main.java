package Beakjoon.bj1939;

import java.util.*;
import java.io.*;
public class Main {
    static ArrayList<ArrayList<Node>> list = new ArrayList<>();
    static int N, M;
    static boolean[] visit;
    static int st, e;
    static boolean flag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        for(int i=0; i<=N; i++) {
            list.add(new ArrayList<Node>());
        }
        for(int i=0; i<M; i++){
            s = br.readLine().split(" ");
            int tmpx = Integer.parseInt(s[0]);
            int tmpy = Integer.parseInt(s[1]);
            int w = Integer.parseInt(s[2]);

            list.get(tmpx).add(new Node(tmpy,w));
            list.get(tmpy).add(new Node(tmpx,w));
        }
        s = br.readLine().split(" ");
        st = Integer.parseInt(s[0]);
        e = Integer.parseInt(s[1]);
        int start = 0, end= 1_000_000_000;
        int mid = 0;
        while(start <= end) {
            mid = (start+end)/2;

            if(check(mid)) {
                start = mid+1;
            }else {
                end = mid-1;
            }
        }

        System.out.println(end);
    }
    public static boolean check(int m) {
        visit = new boolean[N+1];
        flag = false;
        visit[st] = true;
        dfs(st,m);

        return visit[e];
    }

    public static void dfs(int x, int cap){
        if(x == e) {
            flag = true;
            return;
        }
        if(flag) {
            return;
        }

        for(Node tmp : list.get(x)) {
            int tmpy = tmp.y;
            if(!visit[tmpy] && tmp.w >= cap) {
                visit[tmpy] = true;
                dfs(tmpy,cap);
            }
        }
    }
}

class Node {
    int y, w;
    Node(int y, int w) {
        this.y = y;
        this.w = w;
    }
}