package Beakjoon.bj9661;

import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        int x = 0;
        boolean flag = false; //선공차례
        while (n >= 4) {
            x = (int)(Math.log10(n) / Math.log10(4));
            n = n - (long)Math.pow(4,x);
            flag = !flag; //차례 바꿈
        }
        if ((flag && (n == 1 || n == 3 )) || (flag == false && (n  == 2 || n == 0))) {
            System.out.println("CY");
        }else {
            System.out.println("SK");
        }
    }
}

