package Programmers.lv2_k진수에서_소수개수구하기;

public class Main {
}
class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String x = conv(n,k);
        String list[] = x.split("0");

        for(String tmp : list) {
            if(tmp.equals("")) continue;
            if(is_prime(Long.parseLong(tmp))) {
                answer++;
            }
        }

        return answer;
    }


    public String conv(int num, int k) {
        int n = num;
        StringBuilder sb = new StringBuilder();
        while(n > 0) {
            sb.append(n%k);
            n /= k;
        }

        return sb.reverse().toString();
    }


    public boolean is_prime(long num) {
        if(num == 1) {
            return false;
        }

        if(num == 2) {
            return true;
        }

        for(long i=2; i<Math.sqrt(num)+1; i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
}