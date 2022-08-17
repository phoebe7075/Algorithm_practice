package Beakjoon.bj1253;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        String[] s = br.readLine().split(" ");

        for(int i=0; i<n; i++) {
            list.add(Integer.parseInt(s[i]));
        }
        
        int ans = 0;

        Collections.sort(list);
        for(int i=0; i<n; i++) {
            int front = 0, end = n-1;

            while(front < end) {
                if(front == i) {
                    front++;
                }else if(end == i) {
                    end--;
                }
                if(front >= end) {
                    break;
                }
                if(list.get(i) < list.get(front) + list.get(end)) {
                    end--;
                }else if(list.get(i) > list.get(front) + list.get(end)) {
                    front++;
                }else {
                    ans++;
                    break;
                }
            }
        }
        
        System.out.println(ans);
    }
}
