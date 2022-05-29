package Programmers.Line2022_02;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(4,new int[]{2,3});
    }
}
class Solution {
    public int solution(int n, int[] times) {
        int answer = 0;
        int[] dp = new int[n+1];
        dp[0] = 0; dp[1] = 0;

        for(int i=2; i<=n; i++) {
            dp[i] = dp[i-1]+times[0];
            int x = i/2;
            for(int j=1; j<=x; j++) {
                if(dp[i-j]+times[j-1] < dp[i]) {
                    dp[i] = dp[i-j]+times[j-1];
                }
            }
        }

        return dp[n];
    }
}