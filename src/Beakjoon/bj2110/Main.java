package Beakjoon.bj2110;

import java.io.*;
import java.util.*;
public class Main {
    static int n, c;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        c = Integer.parseInt(s[1]);
        arr = new int[n];

        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int start = 1, end = arr[n-1]-arr[0];
        int mid=0;
        while(start <= end) {
            mid = (start+end)/2;
            
            if(check(mid)) {
                start = mid+1;
            }else {
                end = mid-1;
            }
        }

        System.out.println(end);
    }

    public static boolean check(int m) {
        int count = 1;

        for(int i=0; i<n-1; i++) {
            for(int j=i+1; j<n; j++) {
                if(arr[j]-arr[i] >= m) {
                    count++;
                    i = j-1;
                    break;
                }
            }
            if(count == c) {
                return true;
            }
        }
        
        return false;
    }
}
