package Beakjoon.old.bj9655;

import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if(n%2 == 0){
            System.out.println("CY");
        }else {
            System.out.println("SK");
        }
    }
}
