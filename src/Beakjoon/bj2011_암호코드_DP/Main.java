package Beakjoon.bj2011_암호코드_DP;



// 숫자를 하나씩 본다.

// 만약 앞 숫자를 쓸 수 있다면, 현재 전의 경우의 수와 전전의 경우의 수 (= dp[i] = dp[i-1] +dp[i-2])
// 앞 숫자를 쓰지 못하는 숫자라면 전의 경우와 동일 (= dp[i] = dp[i-1])하다.

// 이유 : 전 숫자가 연관이 없다면 전의 경우의 수에 현재 숫자를 붙이는 경우밖에 안되기 때문.
// 전 숫자를 사용 가능하다면, 내 숫자만 쓰는 경우(i-1의 경우의수)와 내 숫자와 내 전 숫자를 같이 쓴 상태의 경우의 수(전 숫자까지 제외해야 하므로 i-2의 경우의 수) 를 모두 사용 가능하니 그렇다.
import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String s;
    static int[] dp;
    static int len;
    static int MOD = 1_000_000;
    public static void main(String[] args) throws IOException {
        s = br.readLine();
        len = s.length();
        if(s.charAt(0) == '0') {
            System.out.println(0);
            return;
        }
        dp = new int[len+1];
        dp[0] = dp[1] = 1;

        for(int i=2; i<=len; i++) {
            if(s.charAt(i-1) == '0') {
                if(s.charAt(i-2) == '1' || s.charAt(i-2) == '2' ) {
                    dp[i] = dp[i-2]%MOD;
                }else {
                    break;
                }
            }else {
                if(s.charAt(i-2) == '0') {
                    dp[i] = dp[i-1]%MOD;
                }else {
                    int tmp = (s.charAt(i-2)-'0')*10 + (s.charAt(i-1)-'0');
                    if(tmp > 0 && tmp <=26) {
                        dp[i] = dp[i-1]%MOD + dp[i-2]%MOD;
                    }else {
                        dp[i] = dp[i-1]%MOD;
                    }
                }
            }
        }
        
        System.out.println(dp[len]%MOD);

    }
}
