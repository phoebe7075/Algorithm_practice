package Beakjoon.bj2473;

import java.io.*;
import java.util.*;
public class Main {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n;
        n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];
        String s[] = br.readLine().split(" ");
        
        for(int i=0; i<n; i++) {
            arr[i] = Long.parseLong(s[i]);
        }

        Arrays.sort(arr);

        long[] ans = new long[3];
        long mingap = (long)2_000_000_001+1_000_000_000;
        for(int i=0; i<n-2; i++) {
            
            int front = i+1, end = n-1;

            while(front < end) {
                long sum = (long)arr[i] + (long)arr[front] + arr[end];
                if(Math.abs(sum) < mingap) {
                    mingap = Math.abs(sum);
                    ans[0] = arr[i];
                    ans[1] = arr[front];
                    ans[2] = arr[end];
                }

                if(sum > 0) {
                    end--;
                }else {
                    front++;
                }
            }
        }
        Arrays.sort(ans);
        System.out.println(ans[0] + " " + ans[1] + " " + ans[2]);
    }
    
}