package Beakjoon.bj15686;

import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Node> house = new ArrayList<>();
    static ArrayList<Node> chicken = new ArrayList<>();
    static int N, M;
    static int ans = Integer.MAX_VALUE;
    static ArrayList<Node> select;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        for(int i=0; i<N; i++) {
            s = br.readLine().split(" ");
            for(int j=0; j<N; j++) {
                int x = Integer.parseInt(s[j]);
                if(x == 1)
                    house.add(new Node(i,j));
                else if (x == 2)
                    chicken.add(new Node(i,j));
            }
        }
        select = new ArrayList<>();
        BackT(0,0);
        System.out.println(ans);
    }

    static void calc() {
        int total = 0;

        for(Node h : house) {
            int tmp = Integer.MAX_VALUE;
            for(Node c : select) {
                tmp = Math.min(tmp, (Math.abs(h.x - c.x) + Math.abs(h.y - c.y)));
            }
            total += tmp;
            if(total >= ans) {
                return;
            }
        }

        ans = total;
    }

    static void BackT(int n, int d) {
        if(d == M) {
            calc();
            return;
        }

        for(int i=n; i<chicken.size(); i++) {
            select.add(chicken.get(i));
            BackT(i+1,d+1);
            select.remove(d);
        }
    }
}

class Node{
    int x, y;
    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}