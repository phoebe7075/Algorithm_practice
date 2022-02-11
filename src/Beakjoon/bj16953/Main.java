package Beakjoon.bj16953;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        int count = 0;

        while (N <= M) {
            if(N==M) {
                System.out.println(count+1);
                return;
            }

            if(M%10 == 1) {
                M/=10;
            }else if(M%2 == 0) {
                M/=2;
            }else{
                System.out.println(-1);
                return;
            }
            count++;
        }
        System.out.println(-1);
    }
}

