package Programmers.lv2_뒤에있는큰수찾기;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{2, 3, 3, 5}));
    }
}

class Solution {
    public int[] solution(int[] n) {
        
        int len = n.length;
        int[] answer = new int[len];
        Stack<Integer> stack = new Stack<>();
        stack.push(n[len-1]);
        
        for(int i=len-2; i>=0; i--) {
            if(n[i] >= stack.peek()) {
                while(!stack.isEmpty() && n[i] >= stack.peek()) {
                    stack.pop();
                }
                if(stack.isEmpty()) {
                    answer[i] = -1;
                    stack.push(n[i]);
                }else {
                    answer[i] = stack.peek();
                    stack.push(n[i]);
                }
            }else {
                answer[i] = stack.peek();
                stack.push(n[i]);
            }
        }
        answer[len-1] = -1;
        return answer;
    }
}