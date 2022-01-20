package Beakjoon.bj13549;

import java.io.*;
import java.util.*;
public class Main {
    static int n, m;
    static int[] arr;
    static boolean visit[];
    static int ans = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        arr = new int[100001];
        visit = new boolean[100001];
        if(n > m) {
            System.out.println(n-m);
        }else {
            bfs();
            System.out.println(arr[m]);
        }
    }
    public static void bfs() {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(n);
        visit[n] = true;
        while (!queue.isEmpty()){
            int p = queue.poll();
            visit[p] = true;
            if (p == m){
                break;
            }
            if (p*2<100001) {
                if(visit[p*2] && arr[p*2] > arr[p]) {
                    queue.addFirst(p*2);
                    arr[p*2] = arr[p];
                }else if(!visit[p*2]){
                    queue.add(p*2);
                    arr[p*2] = arr[p];
                }
            }
            if(p-1>0 && !visit[p-1]) {
                queue.addLast(p-1);
                arr[p-1] = arr[p]+1;
            }
            if (p+1<100001 && !visit[p+1]){
                queue.addLast(p+1);
                arr[p+1] = arr[p]+1;
            }
        }
    }
}