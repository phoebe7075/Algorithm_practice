package Beakjoon.bj2748;

import java.util.Scanner;

public class Main {
    static long[] arr;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();
        arr = new long[91];
        arr[0] = 0; arr[1] = 1;
        if(N < 2) {
            System.out.println(arr[N]);
        }else {
            for(int i = 2; i <=N; i++) {
                arr[i] = arr[i-1]+arr[i-2];
            }
            System.out.println(arr[N]);
        }
    }
}
