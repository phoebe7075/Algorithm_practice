package Beakjoon.old.bj17626;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();

        int arr[] = new int[50001];
        arr[1] = 1; arr[2] = 2; arr[3] = 3;
        for(int i=4; i<=N; i++) {
            arr[i] = arr[i-1]+1;
            for(int j=2; j*j <= i; j++) {
                arr[i] = Math.min(arr[i], arr[i-j*j]+1);
            }
        }

        System.out.println(arr[N]);
    }
}
