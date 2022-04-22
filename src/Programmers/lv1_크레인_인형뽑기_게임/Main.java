package Programmers.lv1_크레인_인형뽑기_게임;

import java.util.ArrayList;
import java.util.Stack;

public class Main {
}
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        int len = board.length;
        ArrayList<Stack<Integer>> list = new ArrayList<>();
        for(int i=0; i<len; i++) {
            list.add(new Stack<Integer>());

            for(int j=len-1; j>=0; j--) {
                if(board[j][i] > 0) {
                    list.get(i).push(board[j][i]);
                }else {
                    break;
                }
            }
        }

        Stack<Integer> basket = new Stack<>();

        for(int x : moves) {
            if(list.get(x-1).isEmpty()) continue;
            int tmp = list.get(x-1).pop();
            if(!basket.isEmpty()) {
                if(basket.peek() == tmp) {
                    basket.pop();
                    answer+=2;
                }else {
                    basket.push(tmp);
                }
            }else {
                basket.push(tmp);
            }
        }


        return answer;
    }
}