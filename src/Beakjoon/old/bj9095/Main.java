package Beakjoon.old.bj9095;


import java.io.*;

public class Main {
    static int[] arr = new int[11];
    static int[] target = {1, 2, 3};
    static int x=0, count=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int a = Integer.parseInt(br.readLine());
        arr[1] = 1; arr[2] = 2; arr[3] = 4;
        for(int x = 0; x < a; x++) {
            int n = Integer.parseInt(br.readLine());
            if (n > 3) {
                perm(n);
            }
            bw.write(Integer.toString(arr[n]));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
    static void perm(int n) {
        if (x == n) {
            arr[x]++;
            return;
        }else if (x > n || count >= n) {
            return;
        }

        for(int i=0; i<3; i++) {
            x += target[i];
            count++;
            perm(n);
            x -= target[i];
            count--;
        }
    }
}
