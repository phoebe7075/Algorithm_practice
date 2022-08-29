package Beakjoon.bj1654_랜선자르기_이분탐색;
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s[] = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);

        int[] arr = new int[n];
        long start = 1, end = 0;

        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            end = Math.max(end, arr[i]);
        }

        long mid;
        while(start <= end) {
            mid = (start+end)/2;
            long count = 0;
            for(int i=0; i<n; i++) {
                count += arr[i]/mid;
            }

            if(count >= k) {
                start = mid+1;
            }else {
                end = mid-1;
            }
        }
        System.out.println(end);
    }
}
