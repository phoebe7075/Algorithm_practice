package Beakjoon.bj12852;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        int n = Integer.parseInt(s);
        int arr[] = new int[n+1];
        arr[0] = arr[1] = 0;
        int list[] = new int[n+1];
        list[1] = 1;
        for(int i=2; i< n+1; i++) {
            arr[i] = arr[i-1]+1;
            list[i] = i-1;
            if (i%2 == 0 && arr[i] > arr[i/2]+1) {
                arr[i] = arr[i/2]+1;
                list[i] = i/2;
            }
            if (i%3 == 0 && arr[i] > arr[i/3]+1) {
                arr[i] = arr[i/3]+1;
                list[i] = i/3;
            }
        }
        System.out.println(arr[n]);
        int tmp = n;
        while (tmp != 1) {
            System.out.print(tmp + " ");
            tmp = list[tmp];
        }
        System.out.println(1);
    }
}
