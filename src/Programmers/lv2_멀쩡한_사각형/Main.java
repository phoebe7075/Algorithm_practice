package Programmers.lv2_멀쩡한_사각형;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(8,12));
    }
}
class Solution {
    public long solution(int w, int h) {
        long answer = 1;

        int gcd = 0;
        if (h > w) {
            for (int i = 1; i <= w; i++) {
                if (h % i == 0 && w % i == 0) {
                    gcd = i;
                }
            }
        }else {
            for(int i=1; i<=h; i++) {
                if(h%i==0 && w%i ==0) {
                    gcd = i;
                }
            }
        }
        long width = w; long height = h;
        answer = width*height - (width+height-gcd);
        return answer;
    }
}