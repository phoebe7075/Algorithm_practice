package HackerRank.CREAMA.3;

public class Main {
    
}
/* 너무 어렵게 생각했었음.
 * 이중포문으로 하나씩 오른쪽으로 옮겨가면서, 시작위치를 기준으로 오른쪽으로 하나씩 더해가면서 합계값이 k보다 커진다면
 * 현재 더한값을 제외한 길이를 현재까지 찾은 최대값과 비교하는 방식으로 계속 진행한다.
 * case 1번에서 발생한 엣지 케이스. 오른쪽 끝까지 진행했는데 sum이 k와 같거나 적은경우. 이 경우가 만약 기존의
 * 부분배열보다 크다면 이 값을 넣어줘야함. 그래서 그 부분을 조건문으로 추가했음.
 */


class Result {

    /*
     * Complete the 'maxLength' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER k
     */
    public static int maxLength(List<Integer> a, int k) {
        int len = a.size();
        int[] arr = new int[len];
        int ans = 0;
        for(int i=0; i<len; i++) {
            arr[i] = a.get(i);
        }
        if(len == 1) {
            if(arr[0] <= k) {
                return 1;
            }else {
                return 0;
            }
        }
        
        
        for(int i=0; i<len; i++) {
            int sum = 0;
            
            for(int j=i; j<len; j++) {
                sum += arr[j];
                
                if(sum > k) {
                    ans = Math.max(ans, j-i);
                    break;
                }
                if(j == len-1) {
                    ans = Math.max(ans, j-i+1);
                }
            }
        }
        
        return ans;
        
    }
    
}