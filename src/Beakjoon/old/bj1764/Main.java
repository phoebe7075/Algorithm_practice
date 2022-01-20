package Beakjoon.old.bj1764;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split(" ");
        int N = Integer.parseInt(strings[0]);
        int M = Integer.parseInt(strings[1]);
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        for(int i=1; i<= N; i++) {
            map1.put(br.readLine(),i);
        }
        for(int i=1; i<= M; i++) {
            map2.put(br.readLine(),i);
        }
        TreeSet<String> set = new TreeSet<>(map1.keySet());
        set.retainAll(map2.keySet());


        System.out.println(set.size());
        for(String s : set) {
            System.out.println(s);
        }
    }
}
