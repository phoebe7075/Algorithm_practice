package Programmers.KaKao2022_02;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{3, 2, 7, 2},new int[]{4, 6, 5, 1}));
    }
}
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long total = 0;
        long sum = 0;
        int list[] = new int[queue1.length*2+1];
        for(int i=0; i<queue1.length; i++) {
            total += queue1[i];
            list[i] = queue1[i];
        }
        sum = total;

        for(int i=0; i<queue1.length; i++) {
            total += queue2[i];
            list[queue1.length+i] = queue2[i];
        }

        if(total%2==1) {
            return -1;
        }
        total /= 2;
        int px=0, py=queue1.length;

        while(px<=py && py < queue1.length*2) {
            if(sum < total) {
                sum += list[py];
                py++;
            }else if (sum > total) {
                sum -= list[px];
                px++;
            }else if(sum == total){
                return answer;
            }
            answer++;
        }
        return -1;
    }
}