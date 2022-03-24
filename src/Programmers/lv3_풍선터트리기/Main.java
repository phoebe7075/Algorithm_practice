package Programmers.lv3_풍선터트리기;

public class Main {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{-16, 27, 65, -2, 58, -92, -71, -68, -61, -33}));
    }
    static public int solution(int[] a) {
        int answer = a.length;
        if(a.length <= 3) {
            return answer;
        }

        int leftmin=a[0], rightmin=a[a.length-1];
        int leftidx=0, rightidx=a.length-1;
        int notSelect = 0;
        while(rightidx-leftidx > 1) {
            boolean leftBigMin = leftmin > rightmin;
            if(leftBigMin) {
                leftidx++;
            }else {
                rightidx--;
            }

            int tmp = a[leftBigMin? leftidx : rightidx];
            boolean leftBig = tmp > leftmin, rightBig = tmp > rightmin;
            if(leftBig && rightBig) notSelect++;

            if(!leftBig && leftBigMin) leftmin = tmp;
            if(!rightBig && !leftBigMin) rightmin = tmp;
        }

        return answer - notSelect;
    }
}
