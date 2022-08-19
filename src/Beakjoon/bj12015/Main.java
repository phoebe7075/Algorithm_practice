package Beakjoon.bj12015;
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n+1];
        int INF = -1_000_000_001;
        int idx = 0;
        String[] s = br.readLine().split(" ");
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(s[i]);
            
        }
        dp[0] = INF;
        for(int i=0; i<n; i++) {
            if(dp[idx] < arr[i]) {
                dp[++idx] = arr[i];
                continue;
            }else {
                int changeIndex = bsearch(dp, 0, idx, arr[i]);
                dp[changeIndex] = arr[i];
            }
        }

        System.out.println(idx);
    }

    public static int bsearch(int[] arr, int s, int e, int target){
        int start = s, end = e;
        int mid = 0;

        while(start < end) {
            mid = (start+end)/2;
            if(arr[mid] == target) {
                return mid;
            }
            if(arr[mid] < target){
                start = mid+1;
            }else {
                end = mid;
            }
        }

        return end;
    }
}