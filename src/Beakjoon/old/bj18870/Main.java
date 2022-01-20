package Beakjoon.old.bj18870;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String s[] = br.readLine().split(" ");
        int arr1[] = new int[N];
        int arr2[] = new int[N];
        for(int i=0; i< N; i++) {
            arr1[i] = Integer.parseInt(s[i]);
            arr2[i] = arr1[i];
        }
        Arrays.sort(arr2);
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i< N; i++) {
            if(map.getOrDefault(arr2[i],-1) == -1) {
                map.put(arr2[i],count++);
            }
        }

        for(int i=0; i< N; i++) {
            bw.write(map.get(arr1[i]) + " ");
        }
        bw.newLine();
        bw.flush();
        bw.close();
    }
}
