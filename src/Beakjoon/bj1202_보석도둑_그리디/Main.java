package Beakjoon.bj1202_보석도둑_그리디;
import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, k;
    static int[] bag;
    static PriorityQueue<Integer> pq;
    static ArrayList<Node> list = new ArrayList<>();
    static long ans = 0;
    public static void main(String[] args) throws NumberFormatException, IOException {
        String s[];
        s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        k = Integer.parseInt(s[1]);

        bag = new int[k];

        for(int i=0; i<n; i++) {
            s = br.readLine().split(" ");
            list.add(new Node(Integer.parseInt(s[0]), Integer.parseInt(s[1])));
        }

        for(int i=0; i<k; i++) {
            bag[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(bag);
        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.x == o2.x) {
                    return o2.y - o1.y;
                }
                return o1.x-o2.x;
            }
        });
        pq = new PriorityQueue<>(Collections.reverseOrder());
        int idx = 0;
        for(int i=0; i<k; i++) {
            while(idx < n && list.get(idx).x <= bag[i]) {
                pq.add(list.get(idx++).y);
            }
            if(!pq.isEmpty()) {
                ans += pq.poll();
            }
        }
        System.out.println(ans);
    }
}
class Node{
    int x, y;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}