package Beakjoon.old.bj16401;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int p, count;
    static int[] arr;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        p = scanner.nextInt();
        count = scanner.nextInt();
        scanner.nextLine();
        arr = new int[count];
        for(int i=0; i < count; i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.nextLine();

        Arrays.sort(arr);
        int start=1, end = arr[count-1];
        int ans = 0;

        while(start <= end) {
            int mid = (start + end)/2;

            if(check(mid) == 1) {
                ans =mid;
                start = mid+1;
            } else if(check(mid) == 2) {
                end = mid-1;
            } else {
                System.out.println(0);
                return;
            }
        }

        System.out.println(ans);
    }

    static int check(long mid) {
        long sum = 0 , sum2 = 0;

        for(int i=0; i<count; i++) {
            sum2 += arr[i];
            if(arr[i] >= mid) {
                sum += arr[i] / mid;
            }

            if(sum >= p) {
                return 1;
            }
        }

        if(sum2 < p) {
            return 3;
        }
        return 2;
    }
}