package Beakjoon.bj1676;


import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long tmp = 1;
        int ans = 0;
        for(int i=1; i<=n; i++) {
            tmp = tmp * i;
            while (tmp%10 == 0) {
                ans++;
                tmp /= 10;
            }
            if (tmp > 999999) {
                tmp = tmp%1000000;
            }
        }
        System.out.println(ans);
    }
}
