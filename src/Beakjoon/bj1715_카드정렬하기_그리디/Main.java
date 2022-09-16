package Beakjoon.bj1715_카드정렬하기_그리디;
import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] arr;
    static int n;
    static int total;
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    public static void main(String[] args) throws NumberFormatException, IOException {
        n = Integer.parseInt(br.readLine());

        //arr = new int[n];
        for(int i=0; i<n; i++) {
            int tmp = Integer.parseInt(br.readLine());
            pq.add(new Node(tmp, 0));
            total += tmp;
        }


        while(!pq.isEmpty()) {
            Node x = pq.poll();

            if(x.x == total) {
                System.out.println(x.cost);
                break;
            }

            Node y = pq.poll();

            pq.add(new Node(x.x+y.x, x.cost+y.cost+x.x+y.x));
        }
    }

}

class Node implements Comparable<Node>{
    int x;
    int cost;

    Node(int x, int c) {
        this.x = x;
        this.cost = c;
    }
    @Override
    public int compareTo(Node x) {
        if(this.x == x.x) {
            return x.cost-this.cost;
        }else {
            return this.x-x.x;
        }
    }
}
