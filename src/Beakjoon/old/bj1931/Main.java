package Beakjoon.old.bj1931;


import java.io.*;
import java.util.*;

public class Main {
    static List<int[]> list = new LinkedList<>();
    static int count = 0;
    static int start = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i =0; i<N; i++) {
            String[] s = br.readLine().split(" ");
            int tmp[] = {Integer.parseInt(s[1]), Integer.parseInt(s[0])};
            list.add(tmp);
        }

        list.sort(((o1, o2) -> {
            if (o1[0] == o2[0]) {
                if (o1[1] == o2[1]) {
                    return 0;
                }else {
                    return o1[1] > o2[1] ? 1 : -1;
                }
            }else{
                if (o1[0] == o2[0]) {
                    return 0;
                }else {
                    return o1[0] > o2[0] ? 1 : -1;
                }
            }
        }));
        start = list.get(0)[1];
        list.forEach((arr)-> {
            if (start <= arr[1]) {
                if (arr[0] == arr[1]){
                    count++;
                }else{
                    start = arr[0];
                    count++;
                }
            }
        });
        System.out.println(count);
    }
}
