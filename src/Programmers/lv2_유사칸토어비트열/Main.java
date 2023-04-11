package Programmers.lv2_유사칸토어비트열;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(4, 1, 125));
    }
}
class Solution {
    static int ans = 0;
    static int arr[] = {1, 1, 0, 1, 1};
    public int solution(int n, long l, long r) {
        calc(n, r);
        int tmp = ans;
        ans = 0;
        calc(n, l-1);
        return tmp - ans;
    }
    
    static void calc(int n, long s) {
        if(n==1) {
            for(int i=0; i<s; i++) {
                if(arr[i] == 1) {
                    ans++;
                }
            }
            return;
        }
        long a = (long)Math.pow(5, n-1);
        
        int x = (int)(s/a);
        int y = (int)(s%a);
        
        for(int i=0; i<x; i++) {
            if(i != 2) {
                ans += (int)Math.pow(4, n-1);
            }
        }
        if(y != 0 && x != 2) {
            calc(n-1, s - (a*x));
        }

    }
}

//1
//11011 4개
//1101111011000001101111011 16개
//11011110110000011011110111101111011000001101111011 64개
//n번째 유사 칸토어 비트열    (n-1번째 유사 칸토어 비트열)*2, 0*(5^(n-1)), (n-1번째 유사 칸토어 비트열)*2
// 총 1의 개수는 4^n만큼 늘어난다.
// 유사 칸토어 비트열 n에서 총 길이는 5^n만큼인데, 여기서 어느 구간에 존재하는지를 알아야함 즉
// n번째 유사 칸토어 비트열은 n-1 , n-1, 0*(5^(n-1)), n-1, n-1 로 존재함
// r까지의 1의 숫자에서 l-1까지 1의 숫자를 빼주면 되는 문제.