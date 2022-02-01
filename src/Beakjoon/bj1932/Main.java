package Beakjoon.bj1932;

import java.io.*;
import java.util.Arrays;

public class Main {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String s[];
        arr = new int[(N * (N+1))/2];
        int index = 0;
        arr[index++] = Integer.parseInt(br.readLine());
        if(N > 1) {
            for(int i=1; i<N; i++) {
                s = br.readLine().split(" ");
                for(int j=0; j<=i; j++) {
                    arr[index++] = Integer.parseInt(s[j]);
                }
            }
        }else {
            System.out.println(arr[0]);
            return;
        }
        int cost[] = new int[arr.length];
        int total = 2;
        cost[0] = arr[0];
        cost[1] = cost[0]+arr[1];
        cost[2] = cost[0]+arr[2];
        for(int i=3; i<=N; i++) {
            cost[total+1] = cost[total- (i-2)] + arr[total+1];
            total++;
            for(int j=total+1; j < total+i-1; j++) {
                cost[j] = Math.max((cost[j-(i-1)] + arr[j]),(cost[j-i] + arr[j]));
            }
            total += i-1;
            cost[total] = cost[total-i] + arr[total];
        }

        int max = 0;

        for(int i=total-(N-1); i <= total; i++) {
            if(max < cost[i]) {
                max = cost[i];
            }
        }
        System.out.println(max);
    }
}
