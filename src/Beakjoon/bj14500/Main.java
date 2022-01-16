package Beakjoon.bj14500;

import java.io.*;
public class Main {
    static int[][] arr;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        arr= new int[N][M];

        for(int i=0; i<N; i++) {
            s = br.readLine().split(" ");
            for(int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }

        int ans = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if (valid(i,j+3)) {
                    ans = compare(widSpace(i,j),ans);
                }
                if(valid(i+3,j)) {
                    ans = compare(heiSpace(i,j),ans);
                }
                if(valid(i+1,j+1)){
                    ans = compare(square(i,j),ans);

                }
                if(valid(i+2,j+1)){
                    ans = compare(L1(i,j),ans);
                    ans = compare(screw1(i,j),ans);
                    ans = compare(fu4(i,j),ans);
                    ans = compare(L6(i,j),ans);
                    ans = compare(L8(i,j),ans);
                }
                if(valid(i+1,j+2)){
                    ans = compare(L2(i,j),ans);
                    ans = compare(L3(i,j),ans);
                    ans = compare(fu1(i,j),ans);
                    ans = compare(L5(i,j),ans);
                    ans = compare(screw3(i,j),ans);
                }
                if(valid(i+2,j-1)){
                    ans = compare(L4(i,j),ans);
                    ans = compare(screw2(i,j),ans);
                    ans = compare(fu3(i,j),ans);
                }
                if(valid(i-1,j+2)) {
                    ans = compare(fu2(i,j),ans);
                    ans = compare(screw4(i,j),ans);
                }
                if(valid(i+1,j-2)){
                    ans = compare(L7(i,j),ans);
                }


            }
        }
        System.out.println(ans);
    }

    static boolean valid(int x, int y) {
        if((x >= 0 && x < N)&& (y >= 0 && y < M) ){
            return true;
        }else {
            return false;
        }
    }
    static int compare(int x, int ans){
        if(x > ans)
            return x;
        else
            return ans;
    }

    static int widSpace(int x, int y) {
        return arr[x][y] + arr[x][y+1] + arr[x][y+2] + arr[x][y+3];
    }
    static int heiSpace(int x, int y) {
        return arr[x][y] + arr[x+1][y] + arr[x+2][y] + arr[x+3][y];
    }
    static int square(int x, int y) {
        return arr[x][y] + arr[x+1][y] + arr[x][y+1] + arr[x+1][y+1];
    }
    static int L1(int x, int y) {
        return arr[x][y] + arr[x+1][y] + arr[x+2][y] + arr[x+2][y+1];
    }
    static int L2(int x, int y){
        return arr[x][y] + arr[x][y+1] + arr[x][y+2] + arr[x+1][y+2];
    }
    static int L3(int x, int y) {
        return arr[x][y] + arr[x+1][y] + arr[x+1][y+1]+arr[x+1][y+2];
    }
    static int L4(int x, int y) {
        return arr[x][y] + arr[x+1][y] + arr[x+2][y] + arr[x+2][y-1];
    }
    static int L5(int x, int y) {
        return arr[x][y] + arr[x+1][y] + arr[x][y+1] + arr[x][y+2];
    }
    static int L6(int x, int y) {
        return arr[x][y] + arr[x][y+1] + arr[x+1][y+1] + arr[x+2][y+1];
    }
    static int L7(int x, int y) {
        return arr[x][y] + arr[x+1][y] + arr[x+1][y-1] + arr[x+1][y-2];
    }
    static int L8(int x, int y) {
        return arr[x][y] + arr[x][y+1] + arr[x+1][y] + arr[x+2][y];
    }
    static int screw1(int x, int y) {
        return arr[x][y] + arr[x+1][y] + arr[x+1][y+1] + arr[x+2][y+1];
    }
    static int screw2(int x, int y) {
        return arr[x][y] + arr[x+1][y] + arr[x+1][y-1] + arr[x+2][y-1];
    }
    static int screw3(int x, int y) {
        return arr[x][y] + arr[x][y+1] + arr[x+1][y+1] + arr[x+1][y+2];
    }
    static int screw4(int x, int y) {
        return arr[x][y] + arr[x][y+1] + arr[x-1][y+1] + arr[x-1][y+2];
    }
    static int fu1 (int x, int y) {
        return arr[x][y] + arr[x][y+1] + arr[x+1][y+1] + arr[x][y+2];
    }
    static int fu2 (int x, int y) {
        return arr[x][y] + arr[x][y+1] + arr[x-1][y+1] + arr[x][y+2];
    }
    static int fu3 (int x, int y) {
        return arr[x][y] + arr[x+1][y] + arr[x+1][y-1] + arr[x+2][y];
    }
    static int fu4 (int x, int y){
        return arr[x][y] + arr[x+1][y] + arr[x+1][y+1] + arr[x+2][y];
    }
}
