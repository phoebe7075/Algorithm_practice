package Beakjoon.bj6064;

import java.io.*;

public class Main {
    static int A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        A = Integer.parseInt(br.readLine());
        for(int i=0; i<A; i++) {
            String s[] = br.readLine().split(" ");
            boolean search = false;
            int M = Integer.parseInt(s[0]);
            int N = Integer.parseInt(s[1]);
            int x = Integer.parseInt(s[2]);
            int y = Integer.parseInt(s[3]);


            int cycle = M * N / gcd(M,N);
            int ans = -1;

            int tmp = y;
            int n = 0;
            while (n*M+x <= cycle) {
                if((n*M+x-y)%N == 0) {
                    ans = n*M+x;
                    break;
                }
                n++;
            }
            System.out.println(ans);
        }
    }

    static int gcd(int n1, int n2) {
        if (n2 == 0)
            return n1;
        return gcd(n2, n1 % n2);
    }
}
