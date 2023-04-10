package Programmers.lv2_테이블해시함수;
import java.io.*;
import java.util.*;
public class Main {
    
}

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        
        Arrays.sort(data, (a, b)-> {
            if(a[col-1] == b[col-1]) {
                    return b[0] - a[0];
            }
            return a[col-1] - b[col-1];
        });
        
        
        for(int i=row_begin-1; i<row_end; i++) {
            int tmp = 0;
            for(Integer x : data[i]) {
                tmp += x % (i+1);
            }
            
            answer = (answer ^ tmp);
        }

        return answer;
    }
}