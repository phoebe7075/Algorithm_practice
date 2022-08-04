package Programmers.lv4_징검다리;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(25, new int[]{2, 14, 11, 21, 17},2);
    }
}

class Solution {
    int size = 0;
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        Arrays.sort(rocks);
        int s = 0;
        size = rocks.length;

        int start = 0, end = distance;
        int mid;
        while(start <= end) {
            mid = (start+end)/2;
            int count = check(mid, n, rocks);
            if(count <= n) {
                start = mid+1;
                answer = mid;
            }else {
                end = mid;
            }
        }
        return answer;
    }

    public int check(int m, int count, int[] r) {
        

        return size;
    }
}
