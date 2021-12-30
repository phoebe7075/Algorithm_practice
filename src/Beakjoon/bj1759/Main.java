package Beakjoon.bj1759;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int L, C;
    static int[] gather = {0, 4, 8, 14, 20};
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        L = scanner.nextInt();
        C = scanner.nextInt();
        scanner.nextLine();
        arr = new int[C];
        visited = new boolean[C];
        String s = scanner.nextLine();
        StringTokenizer st = new StringTokenizer(s, " ");
        for(int i=0; i< C; i++) {
            int tmp = st.nextToken().charAt(0) - 'a';
            arr[i] = tmp;
        }
        Arrays.sort(arr);
        comb(0,C,L);
    }


    static boolean isGather(int x) {
        for(int i =0; i < 5; i++) {
            if (x == gather[i]) {
                return true;
            }
        }
        return false;
    }


    static void comb(int start, int n, int r) {
        if (r == 0) {
            print();
        }


        for(int i=start; i < n; i++) {
            visited[i] = true;
            comb(i+1,n,r-1);
            visited[i] = false;
        }
    }

    static void print() {
        int tmp1 = 0, tmp2 = 0;

        for(int i=0; i<C; i++) {
            if(visited[i]) {
                if(isGather(arr[i])) {
                    tmp1++;
                }else {
                    tmp2++;
                }
            }
        }
        if (tmp1 < 1) {
            return;
        }
        if(tmp2 < 2) {
            return;
        }
        for(int i=0; i<C; i++) {
            if (visited[i])
                System.out.print((char)(arr[i]+'a'));
        }
        System.out.println();
    }
}
