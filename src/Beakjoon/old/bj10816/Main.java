package Beakjoon.old.bj10816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int[] arr2;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        arr = new int[N];
        String s =bf.readLine();
        StringBuffer ans = new StringBuffer();
        StringTokenizer tk = new StringTokenizer(s);
        for(int i=0; i< N; i++) {
            arr[i] = Integer.parseInt(tk.nextToken());
        }
        M = Integer.parseInt(bf.readLine());

        arr2 = new int[M];
        s =bf.readLine();
        tk = new StringTokenizer(s);
        for(int i=0; i<M; i++){
            arr2[i] = Integer.parseInt(tk.nextToken());
        }

        Arrays.sort(arr);
        int start=0, end=N-1;
        for(int i =0; i< M; i++) {
            int mid = 0, st = 0, e = 0;
            while (start <= end) {
                mid = (start + end) /2;
                if(arr[mid] < arr2[i]) {
                    start = mid+1;
                } else{
                    end = mid-1;
                }
            }
            st = start;
            start = 0; end = N-1;
            while (start <= end) {
                mid = (start + end) /2;
                if(arr[mid] <= arr2[i]) {
                    start = mid+1;
                } else{
                    end = mid-1;
                }
            }
            e = end;
            ans.append(e - st + 1);
            ans.append(" ");
            start = 0; end = N-1;
        }


        System.out.println(ans.toString());

    }
}
