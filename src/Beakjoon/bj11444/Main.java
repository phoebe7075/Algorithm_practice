package Beakjoon.bj11444;

import java.io.*;

public class Main {
    static int mod = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        long x = Long.parseLong(s);

        long[][] A = {{1 , 1} ,{ 1, 0}};

        System.out.println(pow(A,x-1)[0][0]);
    }

    static long[][] pow(long[][] A, long exp) {
        if(exp == 1 || exp == 0) {
            return A;
        }

        long[][] tmp = pow(A, exp/2);
        tmp = multiply(tmp, tmp);

        if(exp %2 == 1L) {
            tmp = multiply(tmp, new long[][]{{1,1},{1,0}});
        }

        return tmp;
    }

    static long[][] multiply(long[][] a, long[][] b) {
        long[][] tmp = new long[2][2];
        tmp[0][0] = ((a[0][0] * b[0][0]) + (a[0][1] * b[1][0])) % mod;
        tmp[0][1] = ((a[0][0] * b[0][1]) + (a[0][1] * b[1][1]))% mod;
        tmp[1][0] = ((a[1][0] * b[0][0]) + (a[1][1] * b[1][0]))% mod;
        tmp[1][1] = ((a[1][0] * b[0][1]) + (a[1][1] * b[1][1]))% mod;

        return tmp;
    }
}
