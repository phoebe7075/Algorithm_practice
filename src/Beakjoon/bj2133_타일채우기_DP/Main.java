package Beakjoon.bj2133_타일채우기_DP;
import java.io.*;
import java.util.*;

/*
 * 점화식을 어떻게 세우는가?
 * 먼저 이 문제에서 홀수는 성립 불가. 1칸씩 남기 때문 1x2, 2x1 로는 채울 수 없음
 * 그렇다면 짝수에서 구해야 하는데, 2칸씩 계산하면 된다. 1줄씩 늘렸을 경우 홀수이기 때문에 채울 수 없음.
 * 현재 칸에서 2칸을 더 늘릴 경우 2칸만 있을때의 경우의 수를 곱해주면 된다. i=2일때 경우의 수는 3이므로  i = 4일때 3*3이 된다.
 * 근데 여기서 특수 케이스가 나오게 되는데, 이건 4칸을 차지한다. 위아래로 2번 나올 수 있어 i-4에 *2를 해준다.
 * 근데 i=10일 경우 i=6일때의 특수케이스, i=4일때의 특수케이스.... 를 계속 더해주어야 점화식이 완성이 됨. 이게 첫 번째 방법
 * 
 * 두 번째 방법에는 i-2를 3만큼 곱하면 정상 경우의 수의 값들만 알게 된다. 여기에 나머지 특수케이스들을 더해주면 되는건데.
 * 그냥 4만큼 곱해준다. 이 말인즉슨 i-2까지의 경우의 수를 한번 더 반복한다. 그렇다면 i-2까지의 정상값들과 특수케이스들이 한번 더 반복되는데,
 * 여기서 i-4를 빼준다면?? 이 값은 i-4~i-2까지의 특수케이스를 계산하지 못한 값만 남고 뺄 수 있게 된다. 왜냐하면 i-2까지의 경우의 수는 i-4를 3번 더하고, 그 뒤의 특수케이스의 합까지 더한
 * 값이기 때문. 즉 i-2*4 - i-4 라는 점화식이 도출되게 된다. 
 */
public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        int dp[] = new int[31];
        dp[0] = 1;
        dp[2] = 3;
        if(n < 3) {
            System.out.println(dp[n]);
            return;
        }
        if(n % 2 == 1) {
            System.out.println(0);
            return;
        }
        for(int i=4; i<=n; i++) {
            dp[i] = dp[i-2]*4 - dp[i-4];
        }

        System.out.println(dp[n]);
    }
}
