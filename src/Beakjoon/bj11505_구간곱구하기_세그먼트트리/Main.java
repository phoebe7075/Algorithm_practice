package Beakjoon.bj11505_구간곱구하기_세그먼트트리;

import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, m, k;
    static long[] arr;
    static long[] segment;
    static int mod = 1_000_000_007;
    public static void main(String[] args) throws NumberFormatException, IOException {
        String s[];

        s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        k = Integer.parseInt(s[2]);

        arr = new long[n+1];
        segment = new long[n*4];


        for(int i=1; i<=n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        init(1,n,1);
        
        for(int i=0; i<m+k; i++) {
            s = br.readLine().split(" ");
            int b = Integer.parseInt(s[1]);
            int c = Integer.parseInt(s[2]);
            if(s[0].equals("1")) {
                arr[b] = c;
                update(1, n, 1, b, c);
            }else {
                System.out.println(calc(1,n,1,b,c));
            }
        }
    }

    static long init(int start, int end, int node) {
        if(start == end) return segment[node] = arr[start];
        int mid = (start+end)/2;

        return segment[node] = (init(start, mid, node*2) * init(mid+1, end, node*2+1)) % mod;
    }

    static long update(int start, int end, int node, int index, int change) {

        if(index < start || index > end) return segment[node];
        if(start == end) {
            return segment[node] = change;
        } 
        int mid = (start+end)/2;
        
        return segment[node] = (update(start,mid,node*2,index,change) *update(mid+1,end,node*2+1,index,change))%mod;
    }

    static long calc(int start, int end, int node, int left, int right) {
        if(end < left || right < start) return 1;

        if(start >= left && end <= right) return segment[node];

        int mid = (start+end)/2;

        return (calc(start, mid, node*2, left, right) * calc(mid+1, end, node*2+1, left, right)) % mod;
    }
}
