package Beakjoon.bj2003;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;
    static int x;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        StringTokenizer st = new StringTokenizer(s);
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        s = bf.readLine();
        st = new StringTokenizer(s);
        arr = new int[N];
        for(int i=0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int idx1 = 0,idx2 = 0, ans=0;
        int tmp = 0;
        while (idx2 < N) {
            tmp += arr[idx2];

            if (tmp == M) {
                ans++;
                idx1++;
                idx2 = idx1;
                tmp = 0;
            }else if (tmp > M){
                idx1++;
                idx2 = idx1;
                tmp = 0;
            } else {
                idx2++;
            }
        }
        System.out.println(ans);

    }
}