package Beakjoon.bj11659;

import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        int[] arr = new int[N];
        s = br.readLine().split(" ");
        arr[0] = Integer.parseInt(s[0]);
        for(int i=1; i<N; i++) {
            arr[i] = arr[i-1]+ Integer.parseInt(s[i]);
        }

        for(int i=0; i<M; i++) {
            s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0])-1;
            int y = Integer.parseInt(s[1])-1;
            if(x > 0) {
                System.out.println(arr[y] - arr[x-1]);
            }else {
                System.out.println(arr[y]);
            }

        }
    }
}
