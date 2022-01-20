package Beakjoon.old.bj1074;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int r,c;
    static int a;
    static int ans=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String arr[] = br.readLine().split(" ");
        N = Integer.parseInt(arr[0]);
        r = Integer.parseInt(arr[1]);
        c = Integer.parseInt(arr[2]);
        int ans = 0;
        int y = (int) Math.pow(2, N) / 2;
        int x = y;

        while (N-- > 0) {
            int temp = (int) Math.pow(2, N) / 2;
            int skip = (int) Math.pow(4, N);

            if (r < y && c < x) {
                // 1
                x -= temp;
                y -= temp;
            } else if (r < y && x <= c) {
                // 2
                x += temp;
                y -= temp;
                ans += skip;
            } else if (y <= r && c < x) {
                // 3
                x -= temp;
                y += temp;
                ans += skip * 2;
            } else {
                // 4
                x += temp;
                y += temp;
                ans += skip * 3;
            }
        }
        System.out.println(ans);
    }
}
