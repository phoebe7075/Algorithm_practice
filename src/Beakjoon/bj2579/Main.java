package Beakjoon.bj2579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        int n = Integer.parseInt(s);
        int arr[] = new int[n+1];
        int count[] = new int[n+1];

        for(int i=1; i<n+1; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }
        if(n == 1) {
            System.out.println(arr[1]);
            return;
        }
        count[1] = arr[1];
        count[2] = arr[1]+arr[2];
        for(int i=3; i<=n; i++) {
            count[i] = Math.max(count[i-3]+arr[i-1]+arr[i], count[i-2]+arr[i]);
        }
        System.out.println(count[n]);
    }
}
