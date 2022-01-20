package Beakjoon.old.bj20004;


import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i=1; i<=n; i++) {
            if((30%(i+1)) == 0) {
                System.out.println(i);
            }
        }
    }
}
