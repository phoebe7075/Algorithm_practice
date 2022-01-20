package Beakjoon.old.bj2531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, d, k, c;
    static int[] arr;
    static boolean[] visit;
    static int x;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        StringTokenizer st = new StringTokenizer(s);
        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }
        int idx1 = 0, count = 0;

        int ans = 0;
        while (idx1 < N) {
            visit = new boolean[d+1];
            count =0;
            for(int i=0; i<k; i++) {
                if (!visit[arr[(idx1 + i) % N]]) {
                    visit[arr[(idx1+i)%N]] = true;
                }
            }

            for(int i=0; i<d+1; i++) {
                if(visit[i]) {
                    count++;
                }
            }
            if (!visit[c]) {
                count++;
            }
            if (ans < count) {
                ans = count;
            }
            idx1++;
        }

        System.out.println(ans);
    }
}
