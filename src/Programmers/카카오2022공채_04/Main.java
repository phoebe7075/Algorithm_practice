package Programmers.카카오2022공채_04;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new long[]{10});
    }
    
}
class Solution {
    static boolean flag = false;
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        for(int i=0; i<numbers.length; i++) {
            StringBuilder sb = new StringBuilder();
            flag = false;
            long tmp = numbers[i];
            while(tmp > 1) {
                sb.append(Long.toString(tmp%2));
                tmp = tmp/(long)2;
            }
            sb.append("1");
            
            int len = sb.length();
            if(len != 1) {
                for(int j=1; j<7; j++) {
                    if(len > Math.pow(2, j)-1 && len <= Math.pow(2, j+1)-1) {
                        len = (int)Math.pow(2, j+1)-1;
                        break;
                    }
                }
            }
            int len2 = sb.length();
            if(len-sb.length() > 0) {
                for(int j=0; j<len-len2; j++) {
                    sb.append("0");
                }
            }
            
            String s = sb.reverse().toString();
            inorder(s);

            if(flag) {
                answer[i] = 0;
            }else {
                answer[i] = 1;
            }
        }
        return answer;
    }

    static void inorder(String x) {
        int len = x.length();
        if(len != 1) {
            inorder(x.charAt(len/2)-'0', x.substring(0,len/2), x.substring((len/2)+1,x.length()));
        }else {
            if(x.equals("0")) {
                flag = true;
            }
        }
        
    }
    static void inorder(int root, String left, String right) {
        if(flag) {
            return; 
        }
        if(left.length() != 0 && right.length() != 0 && root == 0) { // 자식이 있는데 내가 0일 경우 성립 불가.
            for(int i=0; i<left.length(); i++) {
                if(left.charAt(i)-'0' == 1) {
                    flag = true;
                    return;
                }
            }
            for(int i=0; i<left.length(); i++) {
                if(right.charAt(i)-'0' == 1) {
                    flag = true;
                    return;
                }
            }
        }
        int len = left.length();
        if(len != 1) {
            inorder(left.charAt(len/2)-'0', left.substring(0,len/2), left.substring((len/2)+1,left.length()));
            inorder(right.charAt(len/2)-'0', right.substring(0,len/2), right.substring((len/2)+1,right.length()));
        }
        
    }
}