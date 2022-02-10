package Beakjoon.bj10830;

import java.io.*;

public class Main {
    static long B;
    static int N;
    static int mod = 1000;
    static long[][] origin;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        B = Long.parseLong(s[1]);

        long[][] A = new long[N][N];
        for(int i=0; i<N; i++) {
            s = br.readLine().split(" ");
            for(int j=0; j<N; j++) {
                A[i][j] = Long.parseLong(s[j]) % 1000;
            }
        }
        origin = A;
        A = pow(A,B);
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
    }

    static long[][] pow(long[][] A, long exp) {
        if(exp == 1 || exp == 0) {
            return A;
        }

        long[][] tmp = pow(A, exp/2);
        tmp = multiply(tmp, tmp);

        if(exp %2 == 1L) {
            tmp = multiply(tmp, origin);
        }

        return tmp;
    }

    static long[][] multiply(long[][] a, long[][] b) {
        long[][] tmp = new long[N][N];
        for(int k=0; k<N; k++) {
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    tmp[i][j] += a[i][k] * b[k][j];
                    tmp[i][j] %= mod;
                }
            }
        }
        return tmp;
    }
}
