package Beakjoon.bj1504;

import java.util.*;

public class Main {
    private static final int INF = 200_000_000;
    static List<Point> list[];
    static int N, E;
    static int v1, v2;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        E = scanner.nextInt();
        scanner.nextLine();
        list = new ArrayList[N + 1];
        for(int i = 0; i <= N; i++)
            list[i] = new ArrayList<>();
        for(int i=0; i < E; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            int weight = scanner.nextInt();
            list[start].add(new Point(end, weight));
            list[end].add(new Point(start, weight));
            scanner.nextLine();
        }
        v1 = scanner.nextInt();
        v2 = scanner.nextInt();
        int ans1=0, ans2 = 0;

        ans1 += shortpath(1,v1) + shortpath(v1,v2) + shortpath(v2, N);
        ans2 += shortpath(1,v2) + shortpath(v2,v1) + shortpath(v1, N);
        if (ans1 >= INF && ans2 >= INF) {
            System.out.println(-1);
        } else {
            System.out.println(Math.min(ans1,ans2));
        }
    }

    static int shortpath(int vs, int ve) {
        int distance[] =  new int[N+1];
        boolean[] check = new boolean[N+1];
        Arrays.fill(distance,INF);
        Arrays.fill(check,false);

        PriorityQueue<Point> queue = new PriorityQueue<>();
        queue.add(new Point(vs, 0));
        distance[vs] = 0;

        while (!queue.isEmpty()){
            Point curPoint = queue.poll();
            int curNode = curPoint.end;
            int curWeight = curPoint.weight;

            if(check[curNode] == true) continue;
            check[curNode] = true;

            for(int i = 0; i < list[curNode].size(); i++){
                int nextNode = list[curNode].get(i).end;
                int nextWeight = list[curNode].get(i).weight;
                // 미방문 && 기존의 계산된 거리보다 새로운 거리가 작을 경우
                if(check[nextNode] == false && distance[nextNode] > curWeight + nextWeight){
                    distance[nextNode] = curWeight + nextWeight;
                    queue.add(new Point(nextNode, distance[nextNode]));
                }
            }
        }

        return distance[ve];
    }
}
class Point implements Comparable<Point>{
    int end;
    int weight;

    public Point(int end, int weight){this.end = end; this.weight = weight;}

    @Override
    public int compareTo(Point o) {
        return weight - o.weight;
    }
}




