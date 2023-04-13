package Programmers.lv2_시소짝궁;
import java.util.*;
public class Main {
    
}
class Solution {
    public long solution(int[] weights) {
        int[] arr = new int[1001];
        int[] list = new int[4001];
        Arrays.fill(arr, -1); Arrays.fill(list, -1);
        long answer = 0;
        int n = weights.length;
        
        for(int i=0; i<n; i++) {
            arr[weights[i]]++;
            answer += arr[weights[i]];
            
            for(int j=2; j<=4; j++) {
                list[weights[i]*j] += 1;
                answer += (list[weights[i]*j] - arr[weights[i]]);
            }
        }
        
        return answer;
    }
}