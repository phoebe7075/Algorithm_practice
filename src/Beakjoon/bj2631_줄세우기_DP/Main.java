package Beakjoon.bj2631_줄세우기_DP;
import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static ArrayList<Integer> dp = new ArrayList<>();
    static int[] arr;
    public static void main(String[] args) throws NumberFormatException, IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];


        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        for(int i=0; i<N; i++) {
            if(dp.size() == 0) {
                dp.add(arr[i]);
            }else {
                if(dp.get(dp.size()-1) < arr[i]) {
                    dp.add(arr[i]);
                }else {
                    int tmp = search(arr[i]);
                    dp.remove(tmp);
                    dp.add(tmp, arr[i]);
                }
            }
        }

        System.out.println(N - dp.size());
    }
    static int search(int x) {
        int size = dp.size();
        for(int i=size-1; i>=0; i--) {
            if(dp.get(i) < x) {
                return i+1;
            }
        }
        return 0;
    }
}
