package Beakjoon.bj2512;

import java.io.*;
import java.util.*;
public class Main {
    static int[] arr;
    static int n;
    static int totalcap;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        int total=0;
        String[] s = br.readLine().split(" ");
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(s[i]);
            total += arr[i];
        }
        totalcap = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        if(totalcap >= total) {
            System.out.println(arr[n-1]);
            return ;
        }
        int start = totalcap/n, end = arr[n-1];
        int mid = 0;
        while(start <= end){
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
        int tmp = 0;

        for(int i=0; i<n; i++) {
            if(m <= arr[i]) {
                tmp += m; 
            }else {
                tmp += arr[i];
            }

            if(tmp > totalcap) {
                return false;
            }
        }

        return true;
    }
}
