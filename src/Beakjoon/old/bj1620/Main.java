package Beakjoon.old.bj1620;


import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split(" ");
        int N = Integer.parseInt(strings[0]);
        int M = Integer.parseInt(strings[1]);
        Map<Integer, String> map1 = new HashMap<Integer, String>();
        Map<String, Integer> map2 = new HashMap<String, Integer>();
        for(int i=1; i<=N; i++){
            String s1 = br.readLine();
            map1.put(i,s1);
            map2.put(s1,i);
        }

        for(int i=0; i<M; i++) {
            String s = br.readLine();
            if(s.charAt(0)-'0' >= 0 && s.charAt(0)-'0' <= 9) {
                System.out.println(map1.get(Integer.parseInt(s)));
            }else {
                System.out.println(map2.get(s));
            }
        }
    }
}
