package Beakjoon.bj1300;

import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static int k;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        long start = 1, end = k;
        long mid = 0;
        while(start <= end) {
            mid = (start+end)/2;

            if(check(mid)) {
                start = mid+1;
            }else {
                end = mid-1;
            }
        }

        System.out.println(start);
    }

    public static boolean check(long m) {
        long count = 0;
        
        for(int i=1; i<=N; i++){
            count += Math.min(m/i,N);
        }

        if(count < k) {
            return true;
        }else {
            return false;
        }
    }
}