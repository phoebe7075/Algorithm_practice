package Programmers.Line2022공채_1;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }
    
}
class Solution {
    static int[] arr = new int[1001];
    static int[] size = new int[1001];
    public int solution(int[][] queries) {
        int answer = 0;

        for(int[] q : queries) {
            int idx = q[0];
            int cnt = q[1];
            if(size[idx] < arr[idx]+cnt) {
                size[idx] = power(arr[idx]+cnt);

                if(arr[idx] > 0) {
                    answer += arr[idx];
                }
                arr[idx] += cnt;
            }else {
                arr[idx] += cnt;
            }
        }

        return answer;
    }


    static int power(int x) {
        int result = 1;
        int power2;
        for(int i=0; i<32; i++) {
            power2 = 1 << i;
            if(power2 >= x) {
                return power2;
            }
        }
        return result;
    }
}