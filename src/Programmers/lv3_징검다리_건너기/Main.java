package Programmers.lv3_징검다리_건너기;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{3,2}, 2));
    }
}
class Solution {
    public int solution(int[] stones, int k) {
        int answer = 200000001;
        int left = 0, right = 200000001;
        if(stones.length == 1) {
            return stones[0];
        }
        while (left <= right) {
            int mid = (left+right)/2;
            if(cross(mid,stones,k)) {
                left = mid+1;
                answer = mid;
            }else {
                right = mid-1;
            }
        }

        return answer;
    }

    public boolean cross(int count, int[] stones, int k) {
        int size = 0;
        for(int i=0; i<stones.length; i++) {
            if(size < k) {
                if(stones[i] < count) {
                    size++;
                }else {
                    size = 0;
                }
            }else {
                break;
            }
        }

        if(size < k) {
            return true;
        }
        return false;
    }
}