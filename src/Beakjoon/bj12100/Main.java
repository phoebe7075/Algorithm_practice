package Beakjoon.bj12100;

import java.util.*;
import java.io.*;
public class Main {
    static final int top = 1, left = 2, right = 3, bottom = 4;
    static ArrayList<Integer> select = new ArrayList<>();
    static int N;
    static int arr[][];
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        String s[];
        for(int i=0; i<N; i++) {
            s = br.readLine().split(" ");
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }

        BackT(0);

        System.out.println(ans);
    }
    static void calc() {
        //이동하려는 방향부터 이동되는 반대방향으로 인접한 노드끼리 충돌을 감지한다.
        int[][] tmp = copy(arr);

        for(int i=0; i<5; i++) {
            tmp = crash(copy(tmp),select.get(i));
            //print(copy(tmp), select.get(i));
        }


        int max = 0;

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(max < tmp[i][j]) {
                    max = tmp[i][j];
                }
            }
        }

        ans = Math.max(ans, max);
    }

    static int[][] crash(int[][] x, int dir) {
        int[][] tmp = copy(x);
        if(dir == top) {
            for(int i=0; i<N; i++) {
                int idx = 0;
                for(int j=0; j<N; j++) {
                    if(tmp[j][i] > 0) {
                        boolean flag = false;
                        if(j < N-1) {
                            for(int k=j+1; k<N; k++) {
                                if(tmp[k][i] == tmp[j][i]) {
                                    int a = tmp[j][i];
                                    tmp[j][i] = 0; tmp[k][i] = 0;
                                    tmp[idx][i] = a*2;
                                    j = idx;
                                    idx++;
                                    flag = true;
                                    break;
                                }else if(tmp[k][i] != 0){
                                    break;
                                }
                            }
                        }

                        if(!flag){
                            int a = tmp[j][i];
                            tmp[j][i] = 0;
                            tmp[idx][i] = a;
                            j = idx;
                            idx++;
                        }
                    }
                }
            }
        }else if (dir == left) {
            for(int i=0; i<N; i++) {
                int idx = 0;
                for(int j=0; j<N; j++) {
                    if(tmp[i][j] > 0) {
                        boolean flag = false;
                        if(j <N-1) {
                            for(int k=j+1; k<N; k++) {
                                if(tmp[i][k] == tmp[i][j]) {
                                    int a = tmp[i][j];
                                    tmp[i][j] = 0; tmp[i][k] = 0;
                                    tmp[i][idx] = a*2;
                                    j = idx;
                                    idx++;
                                    flag = true;
                                    break;
                                }else if(tmp[i][k] != 0){
                                    break;
                                }
                            }
                        }
                        if(!flag){
                            int a = tmp[i][j];
                            tmp[i][j] = 0;
                            tmp[i][idx] = a;
                            j = idx;
                            idx++;
                        }
                    }
                }
            }
        }else if(dir == right) {
            for(int i=0; i<N; i++) {
                int idx = N-1;
                for(int j=N-1; j>=0; j--) {
                    if(tmp[i][j] > 0) {
                        boolean flag = false;
                        if (j > 0) {
                            for(int k=j-1; k>=0; k--) {
                                if(tmp[i][k] == tmp[i][j]) {
                                    int a = tmp[i][j];
                                    tmp[i][j] = 0; tmp[i][k] = 0;
                                    tmp[i][idx] = a*2;
                                    j = idx;
                                    idx--;
                                    flag = true;
                                    break;
                                }else if(tmp[i][k] != 0){
                                    break;
                                }
                            }
                        }
                        if(!flag){
                            int a = tmp[i][j];
                            tmp[i][j] = 0;
                            tmp[i][idx] = a;
                            j = idx;
                            idx--;
                        }
                    }
                }
            }
        }else if (dir == bottom) {
            for(int i=0; i<N; i++) {
                int idx = N-1;
                for(int j=N-1; j>=0; j--) {
                    if(tmp[j][i] > 0) {
                        boolean flag = false;
                        if(j > 0) {
                            for(int k=j-1; k>=0; k--) {
                                if(tmp[k][i] == tmp[j][i]) {
                                    int a = tmp[j][i];
                                    tmp[j][i] = 0; tmp[k][i] = 0;
                                    tmp[idx][i] = a*2;
                                    j = idx;
                                    idx--;
                                    flag = true;
                                    break;
                                }else if(tmp[k][i] != 0){
                                    break;
                                }
                            }
                        }
                        if(!flag){
                            int a = tmp[j][i];
                            tmp[j][i] = 0;
                            tmp[idx][i] = a;
                            j = idx;
                            idx--;
                        }
                    }
                }
            }
        }

        return tmp.clone();
    }

    static void BackT(int d) {
        if(d == 5) {
            calc();
            return;
        }

        for(int i=1; i<=4; i++) {
            select.add(i);
            BackT(d+1);
            select.remove(d);
        }
    }

    static void print(int[][] x, int d) {
        System.out.println("===========" + d + "===========");
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                System.out.print(x[i][j] + " ");
            }
            System.out.println();
        }
    }


    static int[][] copy(int[][] tmp) {
        int[][] x = new int[N][N];

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                x[i][j] = tmp[i][j];
            }
        }
        return x;
    }
}
