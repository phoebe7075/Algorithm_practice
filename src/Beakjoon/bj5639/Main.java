package Beakjoon.bj5639;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int[][] arr;
    static ArrayList<Integer> tmp = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s ="";
        while ((s = br.readLine())!=null) {
            int x = Integer.parseInt(s);
            tmp.add(x);
        }
        arr = new int[tmp.size()][3];
        arr[0][1] = tmp.get(0);
        preorderToTree(arr[0][1],tmp.subList(1,tmp.size()));
        System.out.println(sb.toString());
    }


    static void preorderToTree(int root, List<Integer> tree) {
        int x = 0;
        for(int t : tree) {
            if(root < t) {
                x = tree.indexOf(t);
                break;
            }
        }
        List<Integer> left = tree.subList(0,x);
        List<Integer> right = tree.subList(x,tree.size());
        if(left.size() > 0) {
            preorderToTree(tree.get(0),left.subList(1,left.size()));
        }
        if(right.size() > 0){
            preorderToTree(tree.get(x),right.subList(1,right.size()));
        }
        sb.append(root + " ");
    }
}
