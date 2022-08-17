package Beakjoon.bj2143;
import java.util.*;
import java.io.*;
public class Main {
    static ArrayList<Long> list1 = new ArrayList<>();
    static ArrayList<Long> list2 = new ArrayList<>();
    static long[] sum1, sum2;
    static int cap;
    static int n,m;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        cap = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());
        sum1 = new long[n];
        String[] s = br.readLine().split(" ");
        for(int i=0; i<n; i++) {
            if(i > 0) {
                sum1[i] = Long.parseLong(s[i]) + sum1[i-1];
            }else {
                sum1[i] = Long.parseLong(s[i]);
            }
        }
        m = Integer.parseInt(br.readLine());
        sum2 = new long[m];
        s = br.readLine().split(" ");
        for(int i=0; i<m; i++) {
            if(i > 0) {
                sum2[i] = Long.parseLong(s[i]) + sum2[i-1];
            }else {
                sum2[i] = Long.parseLong(s[i]);
            }
        }

        list1.add(sum1[0]);
        if(n > 1) {
            for(int i=1; i<n; i++) {
                list1.add(sum1[i]);
                for(int j=0; j<i; j++) {
                    list1.add(sum1[i]-sum1[j]);
                }
            }
        }
        
        list2.add(sum2[0]);
        if(m > 1) {
            for(int i=1; i<m; i++) {
                list2.add(sum2[i]);
                for(int j=0; j<i; j++) {
                    list2.add(sum2[i]-sum2[j]);
                }
            }
        }
        

        Collections.sort(list1);
        Collections.sort(list2);
        long ans = 0;
        for(int i=0; i<list1.size(); i++) {
            int start = 0, end = list2.size()-1;
            int mid=0;
            while(start<=end) {
                mid=(start+end)/2;
                if(list1.get(i)+list2.get(mid) < cap) {
                    start = mid+1;
                }else {
                    end = mid-1;
                }
            }
            int sidx = start;
            start = 0; end = list2.size()-1;
            mid=0;
            while(start<=end) {
                mid=(start+end)/2;
                if(list1.get(i)+list2.get(mid) <= cap) {
                    start = mid+1;
                }else {
                    end = mid-1;
                }
            }
            ans += (end-sidx)+1;
        }
        System.out.println(ans);
    }
}
