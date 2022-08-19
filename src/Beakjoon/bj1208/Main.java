package Beakjoon.bj1208;
import java.io.*;
import java.util.*;
public class Main {
    static ArrayList<Integer> list = new ArrayList<>();
    static ArrayList<Integer> list2 = new ArrayList<>();
    static int[] arr;
    static int n;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        int target = Integer.parseInt(s[1]);
        arr = new int[n];
        s = br.readLine().split(" ");
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        subsetSum(0, 0, true);
        subsetSum(n/2, 0, false);
        
        Collections.sort(list);
        Collections.sort(list2);
        long ans = 0;

        for(int i=0; i<list.size(); i++) {
            int t = target - list.get(i);
            ans += overlapNumCount(list2, t);
        }
        if(target == 0) {
            ans--;
        }
        System.out.println(ans);
    }
    public static void subsetSum(int idx, int sum, boolean flag){
        if(flag) {
            if(idx == n/2) {
                list.add(sum);
                return;
            }else {
                subsetSum(idx+1, sum+arr[idx], flag);
                subsetSum(idx+1, sum, flag);
            }
        }else {
            if(idx == n) {
                list2.add(sum);
                return;
            }else {
                subsetSum(idx+1, sum+arr[idx], flag);
                subsetSum(idx+1, sum, flag);
            }
        }

    }


    public static int overlapNumCount(ArrayList<Integer> arr, int target){
        int start = 0, end = arr.size()-1;
        int mid;
        while(start <= end) {
            mid = (start+end)/2;
            if(arr.get(mid) < target){
                start = mid+1;
            }else {
                end = mid-1;
            }
        }

        int lower = start;

        start = 0; end = arr.size()-1;

        while(start <= end) {
            mid = (start+end)/2;
            if(arr.get(mid) <= target){
                start = mid+1;
            }else {
                end = mid-1;
            }
        }

        return (end-lower+1);
    }
}