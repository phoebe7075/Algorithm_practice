package Beakjoon.old.bj6236;

import java.util.Scanner;

public class Main {
    static int[] arr;
    static int N, M;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        scanner.nextLine();
        arr = new int[N];
        int start = 0, end = 0;
        int ans;
        for(int i=0; i < N; i++){
            arr[i] = scanner.nextInt();
            scanner.nextLine();

            if(start < arr[i]) {
                start = arr[i];
            }

            end += arr[i];
        }
        ans = end;
        while(start <= end){
            int mid = (start + end) /2;

            if(check(mid)) {
                ans = mid;
                end = mid -1;
            } else {
                start = mid +1;
            }
        }

        System.out.println(ans);
    }

    static boolean check(int m) {
        int count = 0, sum = 0;

        for(int i=0; i<N; i++) {
            if(sum+arr[i] > m) {
                count++;
                sum = arr[i];
                //System.out.println(m + " " + count + " " + sum);
            } else {
                sum += arr[i];
            }
        }

        return (count >= M ) ? false : true;
    }
}
