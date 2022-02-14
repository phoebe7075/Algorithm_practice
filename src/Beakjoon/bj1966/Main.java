package Beakjoon.bj1966;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++) {
            solusion();
        }
    }

    static void solusion() throws IOException {
        String s[] = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        Queue<Doc> queue = new LinkedList<>();

        if(N == 1) {
            br.readLine();
            System.out.println(1);
            return;
        }else {
            s = br.readLine().split(" ");
            for(int i=0; i<N; i++) {
                queue.add(new Doc(i,Integer.parseInt(s[i])));
            }
        }

        int idx = 1;

        while (!queue.isEmpty()) {
            Doc doc = queue.peek();
            boolean flag = false;
            for(Doc x : queue) {
                if(doc.priority < x.priority) {
                    queue.poll();
                    queue.add(doc);
                    flag = true;
                    break;
                }
            }

            if(flag) {
                continue;
            }else {
                queue.poll();
                if(doc.x == M) {
                    System.out.println(idx);
                    return;
                }
                idx++;
            }
        }

    }
}
class Doc{
    int x;
    int priority;
    Doc(int x, int p) {
        this.x = x;
        this.priority = p;
    }
}
