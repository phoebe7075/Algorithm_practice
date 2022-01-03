package Beakjoon.bj1193;

import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        int n = Integer.parseInt(s);
        int k = 1, radix=1;
        while (k < n) {
            radix++;
            k += radix;
        }
        k -= (radix-1);
        int minus = n - k;

        int len = 1 + minus;
        if(radix%2 == 1) {
            System.out.println((radix-len+1) + "/" + len);
        }else{
            System.out.println(len + "/" + (radix-len+1));
        }
    }
}
