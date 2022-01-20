package Beakjoon.old.bj1003;

import java.io.*;

public class Main {
    static int arr[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        int N = Integer.parseInt(s);
        arr = new int[41][2];
        arr[0][0] = 1;
        arr[1][1] = 1;
        for(int i=2; i < 41; i++) {
            arr[i][0] = arr[i-2][0] + arr[i-1][0];
            arr[i][1] = arr[i-2][1] + arr[i-1][1];
        }
        for(int a=0; a<N; a++) {
            int x = Integer.parseInt(br.readLine());
            bw.write(arr[x][0] + " " + arr[x][1]);
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
