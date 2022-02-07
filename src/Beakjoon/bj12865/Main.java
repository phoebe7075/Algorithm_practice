package Beakjoon.bj12865;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();

        int[] max=new int[k+1];

        for(int i=0;i<n;i++) {
            int w=sc.nextInt();
            int v=sc.nextInt();

            for(int j=k;j>=w;j--) {
                max[j]=Math.max(max[j],max[j-w]+v);
            }
        }
        System.out.println(max[k]);
    }
}
