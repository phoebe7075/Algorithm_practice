package Beakjoon.old.bj3273;



import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    static int x;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        N = Integer.parseInt(s);
        s = bf.readLine();
        StringTokenizer st = new StringTokenizer(s);
        arr = new int[N];
        for(int i=0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        s = bf.readLine();
        x = Integer.parseInt(s);
        Arrays.sort(arr);
        int tmp = 0, idx1 = 0, idx2 = N-1;
        int ans = 0;
        while (idx1 < N-1) {
            for(int i=N-1; i > idx1; i--) {
                if (arr[idx1] + arr[i] == x) {
                    ans++;
                    break;
                }
            }
            idx1++;
        }
        System.out.println(ans);
    }
}
