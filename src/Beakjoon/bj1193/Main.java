package Beakjoon.bj1193;

import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        int n = Integer.parseInt(s);
        int k = (int)Math.sqrt(n);
        int len = 0;
        if (n == 1) {
            System.out.println(1+ "/" + 1);
            return;
        }
        while ((k*(k+1))/2 <= n) {
            k++;
        }
        k--;
        len = n - (k*(k+1))/2;
        k+=2;
        if (k % 2 == 1) {
            System.out.println(len +"/"+ (k-len));
        } else {
            System.out.println(k-len +"/"+ len);
        }
    }
}
