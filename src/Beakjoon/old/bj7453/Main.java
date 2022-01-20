package Beakjoon.old.bj7453;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[] A;
    static int[] B;
    static int[] C;
    static int[] D;
    static int[] arr1;
    static int[] arr2;
    static int N;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        scanner.nextLine();
        A = new int[N];
        B = new int[N];
        C = new int[N];
        D = new int[N];
        arr1 = new int[N*N];
        arr2 = new int[N*N];
        for(int i=0; i<N; i++) {
            A[i] = scanner.nextInt();
            B[i] = scanner.nextInt();
            C[i] = scanner.nextInt();
            D[i] = scanner.nextInt();
            scanner.nextLine();
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                arr1[i*N + j] = A[i] + B[j];
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                arr2[i*N + j] = C[i] + D[j];
            }
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int start=0, end=(N*N)-1;
        double count=0;
        for(int i =0; i<N*N; i++) {
            int s1=0,e=0;
            while(start <= end) {
                int mid = (start + end) /2;

                if(arr1[i] + arr2[mid] < 0) {
                    start = mid+1;
                }else {
                    end = mid-1;
                }
            }
            s1 = start;
            start = 0; end = (N*N)-1;

            while(start <= end) {
                int mid = (start + end) /2;

                if(arr1[i] + arr2[mid] <= 0) {
                    start = mid+1;
                }else {
                    end = mid-1;
                }
            }
            e = end;
            start = 0; end = (N*N)-1;
            count += (e-s1+1);
        }

        System.out.println(count);
    }
}
