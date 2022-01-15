package Beakjoon.bj9375;


import java.io.*;
import java.util.*;
public class Main {
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int a=0; a<T; a++) {
            ans = 0;
            int x = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();

            for(int i=0; i<x; i++) {
                String s[] = br.readLine().split(" ");
                int y = map.getOrDefault(s[1],0);
                map.put(s[1],y+1);
            }
            if (map.size() == 1) {
                System.out.println(map.get(map.keySet().toArray()[0].toString()));
                continue;
            }else {
                ans = 1;
                for(int i : map.values()) {
                    ans *= (i+1);
                }
                ans--;
            }

            System.out.println(ans);
        }
    }
}
