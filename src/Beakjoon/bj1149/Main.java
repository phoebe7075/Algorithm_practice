package Beakjoon.bj1149;


/*
한 집만 본다면 그 집의 최저값을,
그 다음집부터는 이 최저값과 비교를 해야함.

각 값의 최저값을 모두 기억해야 함.

 */
import java.io.*;
public class Main {
    static int ans = Integer.MAX_VALUE;
    static int[][] arr;
    static int[][] cost;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][3];
        cost = new int[N][3];
        String s[];
        for(int i=0; i<N; i++) {
            s = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(s[0]);
            arr[i][1] = Integer.parseInt(s[1]);
            arr[i][2] = Integer.parseInt(s[2]);
        }
        cost[0][0] = arr[0][0]; cost[0][1] = arr[0][1]; cost[0][2] = arr[0][2];
        for(int i=1; i<N; i++) {
            cost[i][0] = Math.min(arr[i][0]+cost[i-1][1], arr[i][0]+cost[i-1][2]);
            cost[i][1] = Math.min(arr[i][1]+cost[i-1][0], arr[i][1]+cost[i-1][2]);
            cost[i][2] = Math.min(arr[i][2]+cost[i-1][0], arr[i][2]+cost[i-1][1]);
        }

        for(int i=0; i<3; i++) {
            if(ans > cost[N-1][i]) {
                ans = cost[N-1][i];
            }
        }

        System.out.println(ans);
    }
}
