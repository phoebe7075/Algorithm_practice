package Programmers.lv2_숫자카드나누기;
import java.util.*;
public class Main {
    
}
class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        for(int i=arrayA[0]; i>0; i--) {
            if(checkAll(i, arrayA) && checkOne(i, arrayB)) {
                answer = Math.max(answer, i);
                break;
            }
        }
        for(int i=arrayB[0]; i>0; i--) {
            if(checkAll(i, arrayB) && checkOne(i, arrayA)) {
                answer = Math.max(answer, i);
                break;
            }
        }
        return answer;
    }
    
    
    static boolean checkAll(int num, int[] arr) {
        for(int i=0; i<arr.length; i++) {
            if(arr[i]%num != 0) {
                return false;
            }
        }
        return true;
    }
    
    static boolean checkOne(int num, int[] arr) {
        for(int i=0; i<arr.length; i++) {
            if(arr[i]%num == 0) {
                return false;
            }
        }
        return true;
    }
}