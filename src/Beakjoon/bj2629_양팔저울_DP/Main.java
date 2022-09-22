package Beakjoon.bj2629_양팔저울_DP;
import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int weightNum, beadNum;
    static int[] beadarr, weightarr;
    static boolean[][] dp;
    static int totalWeight = 0;
    public static void main(String[] args) throws NumberFormatException, IOException {
        weightNum = Integer.parseInt(br.readLine());
        String s[];
        s = br.readLine().split(" ");
        weightarr = new int[weightNum];
        for(int i=0; i<weightNum; i++) {
            weightarr[i] = Integer.parseInt(s[i]);
            totalWeight += weightarr[i];
        }
        beadNum = Integer.parseInt(br.readLine());
        beadarr = new int[beadNum];
        dp = new boolean[weightNum+1][40001];
        BackT(0,0);
        s = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<beadNum; i++){
            beadarr[i] = Integer.parseInt(s[i]);
            sb.append(dp[weightNum][beadarr[i]] ? "Y " : "N ");
        }
        sb.append("\n");

        System.out.println(sb.toString());


    }
    static void BackT(int count, int weight) {
        if(dp[count][weight]) return;
        dp[count][weight] = true;

        if(count == weightNum) return;
        BackT(count+1, weight+weightarr[count]);
        BackT(count+1, weight);
        BackT(count+1, Math.abs(weight-weightarr[count]));

    }
}
