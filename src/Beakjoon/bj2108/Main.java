package Beakjoon.bj2108;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        scanner.nextLine();
        double avg =0;
        int mid=0,min=4001,max=-4001;
        int[] arr = new int[count];
        int[] arr2 = new int[8002];
        int tmp = 0;
        for(int i=0; i < count; i++) {
            tmp = scanner.nextInt();
            scanner.nextLine();
            arr[i] = tmp;
            avg += tmp;
            if(tmp > max) {
                max = tmp;
            }
            if(tmp < min) {
                min = tmp;
            }

            arr2[tmp+4000]++;

        }

        Arrays.sort(arr);

        if(avg < 0) {
            System.out.println((int)Math.floor((double)avg/count + 0.5));
        }else {
            System.out.println(Math.round(avg/count));
        }
        System.out.println(arr[(count/2)]);
        mode(arr2);
        System.out.println(max-min);


    }

    static void mode(int[] arr) {
        int c2=0;
        for(int i=0; i<8002; i++) { //최빈 갯수 찾기
            if (c2 < arr[i]) {
                c2 = arr[i];
            }
        }
        for(int i=0; i<8002; i++) {
            if(c2 == arr[i]) {
                for(int j=i+1; j<8002; j++) {
                    if (c2 == arr[j]) {
                        System.out.println((j-4000));
                        return;
                    }
                }
                System.out.println(i-4000);
                return;
            }
        }
    }
}
