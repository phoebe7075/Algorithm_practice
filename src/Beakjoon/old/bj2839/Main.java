package Beakjoon.old.bj2839;

import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        int n = Integer.parseInt(s);
        int c1 = n / 5, c2 = 0;

        while (true) {
            if (n % 5 == 0) {
                System.out.println(c1);
                return;
            }

            if ((n - c1 * 5 )%3 == 0) {
                c2 = (n - c1 * 5 )/3;
                System.out.println(c1+c2);
                return;
            } else {
                c1--;
            }

            if (c1 < 0) {
                System.out.println(-1);
                return;
            }
        }

    }
}
