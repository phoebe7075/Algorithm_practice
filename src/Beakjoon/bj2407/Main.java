package Beakjoon.bj2407;

import java.io.*;
import java.math.BigInteger;

public class Main {
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        int tmp1 = Math.max(M, (N-M));
        int x = N-tmp1;
        BigInteger tmp = new BigInteger(Integer.toString(N));
        BigInteger B;
        for(int i=N-1; i > tmp1; i--) {
            B = new BigInteger(Integer.toString(i));
            tmp = tmp.multiply(B);
        }

        for(int i=2; i <=x; i++) {
            B = new BigInteger(Integer.toString(i));
            tmp = tmp.divide(B);
        }
        System.out.println(tmp.toString());
    }
}
