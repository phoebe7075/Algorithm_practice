package Programmers.lv2_마법의엘리베이터_dp;
import java.io.*;
import java.util.*;
public class Main {
    
}

class Solution {
    static String tmp;
    static int result = Integer.MAX_VALUE;
    public int solution(int storey) {
        tmp = Integer.toString(storey);
        int x = (int)Math.log10(storey);
        
        dfs(x,0,0);
        return result;
    }
    
    
    static void dfs(int cur, int add, int res) {
        if(cur == -1) {
            result = Math.min(result, res+add);
            return;
        }
        
        int num = (tmp.charAt(cur) - '0')+add;
        
        dfs(cur-1, 0, res+num);
        dfs(cur-1, 1, res+(10-num)); // 자리수를 넘겨서 움직이는 경우, +층 이동 일 경우 다음 자리수에 +1을 넘겨줌
    }
}