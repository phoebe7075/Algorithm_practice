package Beakjoon.bj1991;

import java.io.*;
public class Main {
    static int[][] arr;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[26][2];
        String s[];
        for(int i=0; i<N; i++) {
            s = br.readLine().split(" ");
            int root = s[0].charAt(0) - 'A';
            int left=-1, right=-1;
            if(!s[1].equals(".")) {
                left = s[1].charAt(0) - 'A';
            }
            if(!s[2].equals(".")) {
                right = s[2].charAt(0) - 'A';
            }
            arr[root][0] = left;
            arr[root][1] = right;
        }
        inorder(0);
        System.out.println();
        leftorder(0);
        System.out.println();
        rightorder(0);
        System.out.println();
    }

    static void inorder(int n) {
        System.out.print((char)(n + 'A'));
        if(arr[n][0] > 0) {
            inorder(arr[n][0]);
        }
        if(arr[n][1] > 0) {
            inorder(arr[n][1]);
        }
    }

    static void leftorder(int n) {
        if(arr[n][0] > 0) {
            leftorder(arr[n][0]);
        }
        System.out.print((char)(n + 'A'));
        if(arr[n][1] > 0) {
            leftorder(arr[n][1]);
        }
    }

    static void rightorder(int n) {
        if(arr[n][0] > 0) {
            rightorder(arr[n][0]);
        }

        if(arr[n][1] > 0) {
            rightorder(arr[n][1]);
        }
        System.out.print((char)(n + 'A'));
    }
}
