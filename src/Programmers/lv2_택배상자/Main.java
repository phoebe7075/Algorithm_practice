package Programmers.lv2_택배상자;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{5, 4, 3, 2, 1}));
    }
}
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int[] stack = new int[order.length];
        int top = -1;
        int num = 1;
        for(int i=0; i<order.length; i++) {
            if(num == order[i]) {
                num++;
                answer++;
            }else {
                if(top >= 0) {
                    if(stack[top] == order[i]) {
                        top--;
                        answer++;
                    }else {
                        while(num < order.length && num != order[i]) {
                            stack[++top] = num;
                            num++;
                        }
                        if(num == order[i]) {
                            num++;
                            answer++;
                        }else if(num >= order.length){
                            return answer;
                        }
                    }
                }else {
                    while(num < order.length && num != order[i]) {
                        stack[++top] = num;
                        num++;
                    }
                    if(num == order[i]) {
                        num++;
                        answer++;
                    }else if(num >= order.length){
                        return answer;
                    }
                }
            }
        }
        return answer;
    }
}