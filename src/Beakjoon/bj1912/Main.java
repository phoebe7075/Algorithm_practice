package Beakjoon.bj1912;


import java.io.*;
public class Main {
    static int N;
    static int[] arr;
    static int ans;
    static int total;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        String s[] = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(s[i]);
            ans = Math.min(ans,arr[i]);
        }
        total = 0;

        for(int i=0; i<N; i++) {
            if(total+arr[i] < ans) {
                total = 0;
                continue;
            }else {
                total += arr[i];
            }

            if(ans < total) {
                ans = total;
            }
        }

        System.out.println(ans);
    }
}
