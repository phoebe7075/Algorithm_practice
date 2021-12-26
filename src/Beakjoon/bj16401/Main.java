package Beakjoon.bj16401;

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
        int answer = 0;
        arr = new int[count];
        for(int i=0; i < count; i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.nextLine();

        Arrays.sort(arr);
        int start=1, end = arr[count-1];

        while(start <= end) {
            int mid = (start + end)/2;
            int sum = 0;
            for(int i=0; i<count; i++) {
                sum += arr[i] / mid;
            }

            if(sum >= p) {
                answer = mid;
                start = mid+1;
            } else {
                end = mid-1;
            }
        }

        System.out.println(answer);
    }


}
