package Beakjoon.bj15961;


import java.io.*;


public class Main {
    static int N, d, k, c;
    static int[] arr;
    static int x;
    static int[] sushi;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        d = Integer.parseInt(s[1]);
        k = Integer.parseInt(s[2]);
        c = Integer.parseInt(s[3]);
        arr = new int[N];
        sushi = new int[d+1];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int idx = 0, count = 0, size = 0;

        int ans = 0;

        while (idx < N+k) {
            int tmp = arr[idx%N];
            if(size < k) {
                size++;
            }else {
                sushi[arr[(idx+N-k)%N]]--;
                if(sushi[arr[(idx+N-k)%N]] == 0) {
                    count--;
                }
            }
            if(sushi[tmp] > 0) {
                sushi[tmp]++;
            }else {
                sushi[tmp]++;
                count++;
            }

            if(sushi[c] == 0) {
                ans = Math.max(ans, count+1);
            }else {
                ans = Math.max(ans, count);
            }

            idx++;
        }

        System.out.println(ans);
    }
}
