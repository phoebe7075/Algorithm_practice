package Programmers.lv2_디펜스게임;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(7, 3, new int[]{4, 2, 4, 5, 3, 3, 1}));
    }
}
class Solution {
    static int answer = 0;
    static int len;
    public int solution(int n, int k, int[] enemy) {
        len = enemy.length;
        
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i=0; i<k; i++) {
            q.add(0);
        }
        for(int i=0; i<enemy.length; i++) {
            if(enemy[i] > q.peek()) {
                n -= q.poll();
                q.add(enemy[i]);
            }else {
                n -= enemy[i];
            }
            if(n < 0) {
                return i;
            }
        }
        return len;
    }
}