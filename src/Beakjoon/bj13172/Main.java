package Beakjoon.bj13172;

import java.io.*;
public class Main {
    static int N;
    static int mod = 1000000007;
    static long total;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        String s[];
        for(int i=0; i<N; i++) {
            s = br.readLine().split(" ");
            long a = Long.parseLong(s[1]);
            long b = Long.parseLong(s[0]);
            long x = multyply(b,mod-2)* a % mod;
            total = (total + x) % mod;
        }
        System.out.println(total);
    }

    static long multyply(long n, int exp) {
        if(exp == 1) {
            return n % mod;
        }

        long tmp = multyply(n,exp/2);

        if(exp%2 == 1) {
            return (tmp*tmp % mod)* n % mod;
        }
        return tmp * tmp % mod;
    }
}
