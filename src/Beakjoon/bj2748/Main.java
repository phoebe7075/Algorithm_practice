package Beakjoon.bj2748;

import java.util.Scanner;

public class Main {
    static long[] arr;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();
        arr = new long[N+1];
        arr[0] = 0; arr[1] = 1; arr[2] = 1;
        if(N < 3) {
            System.out.println(arr[N]);
        }else {
            for(int i = 3; i <=N; i++) {
                arr[i] = arr[i-1]+arr[i-2];
            }
            System.out.println(arr[N]);
        }
    }
}
