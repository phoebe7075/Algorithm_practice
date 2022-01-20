package Beakjoon.old.bj1463;

import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        int n = Integer.parseInt(s);
        int arr[] = new int[n+1];
        arr[0] = arr[1] = 0;
        for(int i=2; i < n+1; i++) {
            arr[i] = arr[i-1] +1;
            if (i%2 == 0) {
                arr[i] = Math.min(arr[i/2]+1,arr[i]);
            }
            if (i%3 == 0) {
                arr[i] = Math.min(arr[i/3]+1,arr[i]);
            }
        }
        System.out.println(arr[n]);
    }
}
