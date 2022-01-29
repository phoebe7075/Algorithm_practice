package Beakjoon.bj2096;

import java.io.*;
public class Main {
    static int N;
    static int arr[][];
    static int matrix[];
    static int Min = 1000000, Max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][3];
        matrix = new int[3];
        String s[];
        for(int i=0; i<N; i++) {
            s = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(s[0]);
            arr[i][1] = Integer.parseInt(s[1]);
            arr[i][2] = Integer.parseInt(s[2]);
        }
        matrix[0] = arr[0][0]; matrix[1] = arr[0][1]; matrix[2] = arr[0][2];

        int tmp1, tmp2, tmp3;
        for(int i=1; i<N; i++) {
            tmp1 = Math.max(matrix[0]+arr[i][0],matrix[1]+arr[i][0]);
            tmp2 = Math.max(Math.max(matrix[0]+arr[i][1],matrix[1]+arr[i][1]),matrix[2]+arr[i][1]);
            tmp3 = Math.max(matrix[1]+arr[i][2],matrix[2]+arr[i][2]);
            matrix[0] =tmp1;
            matrix[1] = tmp2;
            matrix[2] = tmp3;
        }
        Max = Math.max(Math.max(matrix[0],matrix[1]),matrix[2]);
        matrix[0] = arr[0][0]; matrix[1] = arr[0][1]; matrix[2] = arr[0][2];
        for(int i=1; i<N; i++) {
            tmp1 = Math.min(matrix[0]+arr[i][0],matrix[1]+arr[i][0]);
            tmp2 = Math.min(Math.min(matrix[0]+arr[i][1],matrix[1]+arr[i][1]),matrix[2]+arr[i][1]);
            tmp3 = Math.min(matrix[1]+arr[i][2],matrix[2]+arr[i][2]);
            matrix[0] =tmp1;
            matrix[1] = tmp2;
            matrix[2] = tmp3;
        }

        Min = Math.min(Math.min(matrix[0],matrix[1]),matrix[2]);
        System.out.println(Max + " " + Min);
    }
}
