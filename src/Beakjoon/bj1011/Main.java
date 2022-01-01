package Beakjoon.bj1011;


import java.util.*;
public class Main {
    static int N;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        scanner.nextLine();
        for(int i=0; i < N; i++) {
            long a = scanner.nextLong();
            a = scanner.nextLong() - a;
            long k = Math.round(Math.sqrt(a)), warp = 0;

            long minus = a - k*k;
            warp += k*2 -1;
            if (minus > 0) {
                if (minus <= k) {
                    warp+= 1;
                } else{
                    warp += 2;
                }
            }
            System.out.println(warp);
        }
    }
}
