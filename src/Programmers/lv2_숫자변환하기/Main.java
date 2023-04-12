package Programmers.lv2_숫자변환하기;
import java.util.*;
public class Main {
    
}

class Solution {
    static int[] arr;
    public int solution(int x, int y, int n) {
        int max = 100000000;
        
        arr = new int[y*3+n+1];
        Arrays.fill(arr, max);
        arr[x] = 0;
        
        for(int i=x; i<y; i++) {
            arr[i+n] = Math.min(arr[i]+1, arr[i+n]);
            arr[i*2] = Math.min(arr[i]+1, arr[i*2]);
            arr[i*3] = Math.min(arr[i]+1, arr[i*3]);
        }
        if(arr[y] < max) {
            return arr[y];
        }else {
            return -1;
        }
    }
}