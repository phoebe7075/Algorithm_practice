package Beakjoon.old.bj2869;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        StringTokenizer st = new StringTokenizer(s);
        double A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken()), V = Integer.parseInt(st.nextToken());
        System.out.println((int)Math.ceil((V-A)/(A-B)) + 1);
    }
}
