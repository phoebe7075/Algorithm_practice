package Programmers.카모2022공채_01;

/*
 * 입력값 〉
[[2, 5], [3, 7], [10, 11]]
기댓값 〉
6

입력값 〉
[[3, 4], [4, 5], [6, 7], [8, 10]]
기댓값 〉
5
 */



import java.util.*;
class Solution {
    public int solution(int[][] flowers) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int[] x : flowers){
            for(int i=x[0]; i<x[1]; i++) {
                map.put(i, 0);
            }
        }
        return map.size();
    }
}
