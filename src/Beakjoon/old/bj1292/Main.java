package Beakjoon.old.bj1292;


import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int r = scanner.nextInt();
        scanner.nextLine();

        solusion1(n, r);
    }

    static void solusion1(int n, int r) {
        int total = 0;
        int tmp1 = 1;
        int radix1 = 1;
        while (n > tmp1) {

            radix1 += 1;
            tmp1 += radix1;
        }
        for(int i =n; i <= r; i++) {
            if(i < tmp1) {
                total += radix1;
            } else{
                total += radix1;
                radix1++;
                tmp1 += radix1;

            }
        }
        System.out.println(total);
    }
}
