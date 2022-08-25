package Beakjoon.bj2565_전깃줄_DP;
import java.io.*;
import java.util.*;

public class Main {
    static int[] dp;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Node> list = new ArrayList<>();
        
        String s[];
        for(int i=0; i<n; i++) {
            s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);

            list.add(new Node(x,y));
        }
        dp = new int[n+1];
        Collections.sort(list);

        int idx = 0;

        for(int i=0; i<n; i++) {
            if(dp[idx] < list.get(i).y) {
                dp[++idx] = list.get(i).y;
            }else {
                dp[search(list.get(i).y,idx)] = list.get(i).y;
            }
        }

        System.out.println(list.size()-idx);
    }
    static int search(int x, int idx) {
        for(int i=idx; i>=1; i--) {
            if(dp[i] < x) {
                return i+1;
            }
        }
        return 1;
    }
}

class Node implements Comparable<Node>{
    int x,y;
    Node(int x, int y) {
        this.x =x;
        this.y =y;
    }

    @Override
    public int compareTo(Node o) {
        return this.x - o.x;
    }
}
