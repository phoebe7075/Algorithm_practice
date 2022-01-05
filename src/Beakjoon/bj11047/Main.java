package Beakjoon.bj11047;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int ans;
    static int arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        int N = Integer.parseInt(st.nextToken());
        int total = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int tmp = N-1;

        while (total > 0) {
            if(total >= arr[tmp]) {
                int a = total / arr[tmp];
                ans += a;
                total -= arr[tmp] * a;
            }else {
                tmp--;
            }
        }

        System.out.println(ans);
    }
}
