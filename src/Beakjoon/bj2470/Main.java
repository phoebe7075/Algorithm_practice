package Beakjoon.bj2470;

import java.io.*;
import java.util.*;
public class Main {
    static int[] arr;
    static int n;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        String s[] = br.readLine().split(" ");
        
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        Arrays.sort(arr);
        int[] ans = new int[2];
        int mingap = 2000000001;
        for(int i=0; i<n; i++) {
            int start = 0, end = n-1;
            int mid = 0;
            while(start <= end) {
                mid = (start+end)/2;
                if(mid == i) {
                    if(arr[i] < 0) {
                        start = i+1;
                    }else {
                        end = i-1;
                    }
                    continue;
                }
                if(Math.abs(arr[mid]+arr[i]) < mingap) {
                    ans[0] = Math.min(arr[i],arr[mid]);
                    ans[1] = Math.max(arr[i],arr[mid]);
                    mingap = Math.abs(arr[mid]+arr[i]);
                }

                if(arr[mid]+arr[i] < 0 ) {
                    start = mid+1;
                }else {
                    end = mid-1;
                }
            }
        }
        System.out.println(ans[0] + " " + ans[1]);
    }
    
}