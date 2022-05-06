package Programmers.lv2_양궁대회;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(10, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3});
    }
}
class Solution {
    static int[] answer = new int[11];
    static int rion = 0;
    static int apeach = 0;
    public int[] solution(int n, int[] info) {

        apeach = 0;
        for(int i=0; i<11; i++) {
            if(info[i] > 0) {
                apeach += (10-i);
            }
        }

        for(int i=n-1; i>=0; i--) {
            int arr[] = new int[11];
            arr[10] = i;
            dfs(n,i,9,arr, info);
        }


        if(rion ==0) {
            return new int[]{-1};
        }
        return answer;
    }


    public void dfs(int n, int r,int start ,int[] arr, int[] info) {
        if(n == r) {
            int total = 0;
            int apch = apeach;
            for(int i=0; i<11; i++) {
                if(arr[i] > 0) {
                    total += (10-i);
                    if(info[i] > 0) {
                        apch -= (10 - i);
                    }
                }
            }

            if(total - apch > rion) {
                rion = total - apch;

                for(int i=0; i<11; i++) {
                    answer[i] = arr[i];
                }
            }
        }

        for(int i=start; i>=0; i--) {
            if(info[i]+1 <= n-r) {
                arr[i] = info[i]+1;
                dfs(n,r+arr[i],i-1,arr,info);
                arr[i] = 0;
            }
        }

    }
}