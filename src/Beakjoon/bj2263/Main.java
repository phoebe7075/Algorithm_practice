package Beakjoon.bj2263;

import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static ArrayList<Integer> inorder = new ArrayList<>();
    static ArrayList<Integer> postorder = new ArrayList<>();
    static int N;
    static int start,end;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String s[] = br.readLine().split(" ");
        for(int i=0; i<N; i++) {
            inorder.add(Integer.parseInt(s[i]));
        }
        s = br.readLine().split(" ");
        for(int i=0; i<N; i++) {
            postorder.add(Integer.parseInt(s[i]));
        }
        arr = new int[N][3]; // left me right
        arr[0][1] = postorder.get(postorder.size()-1);
        start = 0; end = N-1;
        search(0,end,arr[0][1],postorder.subList(0,end));
        System.out.println(sb.toString());
    }


    static void search(int s, int e, int n, List<Integer> tree) {
        sb.append(n + " ");
        int idx = inorder.indexOf(n)-s;
        List<Integer> left = tree.subList(0,idx);
        int rightsize = tree.size()-left.size();
        int size = left.size();
        List<Integer> right = tree.subList(size,size+rightsize);
        if (left.size() > 0) {
            search(s,inorder.indexOf(left.get(left.size()-1)),left.get(left.size()-1),left.subList(0,size-1));
        }
        if(right.size() > 0) {
            search(inorder.indexOf(n)+1,inorder.indexOf(n)+rightsize,right.get(right.size()-1),right.subList(0,right.size()-1));
        }
    }
}
