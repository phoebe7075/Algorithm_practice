package Beakjoon.bj17626;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();

        int ans = 5, count=0;
        int tmp = N;
        int x = (int)Math.sqrt(N);
        int y = x;
        while (x > (int)Math.sqrt(N)/2) {
            tmp -= y*y;
            y = (int)Math.sqrt(tmp);
            count++;
            if(count > 4) {
                x--;
                count = 0;
                tmp = N;
                y =x;
            }else if(tmp == 0 && count < ans) {
                ans = count;
                tmp = N;
                x--;
                count = 0;
                y = x;
            }
        }
        System.out.println(ans);
    }
}
