package Programmers.Line2022_03;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(1000000,new int[]{1, 1}, new int[]{1, 10000});
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");

        for(int i=1; i<=10000; i++){
            stringBuilder.append(i);
            if(i != 10000) {
                stringBuilder.append(", ");
            }

        }
        stringBuilder.append("]");
        System.out.println(stringBuilder.toString());
    }
}
class Solution {
    public int solution(int fuel, int[] powers, int[] distances) {
        int answer = 0;

        PriorityQueue<Node> queue = new PriorityQueue<>();
        for(int i=0; i<powers.length; i++) {
            double v = powers[i];
            double d = distances[i];

            queue.add(new Node(v,d,1,d/v + 0.5));
        }

        fuel = fuel-powers.length;
        while(fuel > 0) {
            Node x = queue.poll();
            double tmp;
            if((x.p*(x.f+1.0)*(x.f+1.0)/2) < x.d) {
                tmp = (x.d-(x.p*(x.f+1.0)*(x.f+1.0)/2))/(x.p*(x.f+1.0)) + (x.f+1.0);
            }else {
                tmp = Math.sqrt(x.d/x.p*2);
            }

            queue.add(new Node(x.p,x.d,x.f+1.0,tmp));
            fuel--;
        }
        answer = (int)Math.ceil(queue.poll().t);
        return answer;
    }
}


class Node implements Comparable<Node> {
    double p, d, f, t;
    Node(double p, double d, double f, double t) {
        this.p = p;
        this.d = d;
        this.f = f;
        this.t = t;
    }

    @Override
    public int compareTo(Node o) {
        return (int)(o.t-t);
    }
}