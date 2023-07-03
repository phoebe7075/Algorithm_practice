package HackerRank.CREAMA.2;

public class Main {
    
}


/* 10억대 까지 숫자에 대해 숫자들을 다른 숫자로 바꾸었을 때 그 숫자들의 최소값과 최대값의 차이를 리턴해야함. 
 * 그래서 매개변수는 int이지만 결과는 long이 나올 수 있음 (21억까지 int이지만 2100000000에서 2를 9로 바꾼다면 9100000000은 long의 범위)
 * 간단하게 0-9의 숫자를 0-9로 바꿔보고 (2중 for문) 먼저 이 값이 자리수가 변동(앞자리를 0으로 바꾸었다 등)이 되었거나, 값이 0일 경우(불가능)
 * 엣지케이스를 거르고 나머지 값에 대해 min값과 max값을 계속 비교해서 나온 값에 대해
 * 리턴하는 방식으로 작성.
 */

class Result {

    /*
     * Complete the 'findRange' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts INTEGER num as parameter.
     */

    public static long findRange(int num) {
        long min = 1999999999, max =0;
        
        for(int i=0; i<=9; i++) {
            String tmp = Integer.toString(num);
            for(int j=0; j<=9; j++) {
                if(j != i) {
                    String x = tmp.replaceAll(Integer.toString(i), Integer.toString(j));
                    if(Long.toString(Long.parseLong(x)).length() != tmp.length() || Long.parseLong(x) == 0) {
                        continue;
                    }
                    
                    min = Math.min(min, Long.parseLong(x));
                    max = Math.max(max, Long.parseLong(x));
                }
            }
        }
        
        return max-min;
    }

}