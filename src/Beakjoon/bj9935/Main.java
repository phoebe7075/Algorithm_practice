package Beakjoon.bj9935;


import java.io.*;
import java.util.*;

public class Main {
    static Stack<Character> stack = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        String rx = br.readLine();
        int idx = 0;
        int size = rx.length();


        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++) {
            char x = s.charAt(i);
            sb.append(s.charAt(i));
            if(rx.indexOf(x) == idx) {
                idx++;
            }else {
                if(rx.indexOf(x) > 0) {
                    int start = sb.length() - (rx.indexOf(x)+1);
                    if(start < 0) {
                        idx = 0;
                        continue;
                    }
                    idx = 0;
                    for(int j=start; j<sb.length(); j++) {
                        if(rx.indexOf(sb.charAt(j)) == idx) {
                            idx++;
                        }else {
                            idx = 0;
                            break;
                        }
                    }
                }else if (rx.indexOf(x) == 0) {
                    idx = 1;
                }else {
                    idx = 0;
                }
            }
            if(idx == size) {
                sb.delete(sb.length()-idx,sb.length());
                idx = 0;
            }
        }
        if(sb.length() == 0) {
            System.out.println("FRULA");
            return;
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
