package Beakjoon.bj17144;

import java.io.*;
public class Main {
    static int R,C,T;
    static int arr[][];
    static int aircleaner;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,-1,0,1};
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");
        R = Integer.parseInt(s[0]);
        C = Integer.parseInt(s[1]);
        T = Integer.parseInt(s[2]);
        arr = new int[R][C];
        for(int i=0; i<R; i++) {
            s = br.readLine().split(" ");
            for(int j=0; j<C; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
                if(arr[i][j] == -1) {
                    aircleaner = i;
                }
            }
        }


        for(int i=0; i<T; i++) {
            diffusion();
            circulation();
        }

        calc();
        System.out.println(ans);
    }


    static void diffusion() {
        int tmp[][] = new int[R][C];

        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(arr[i][j] > 0) {
                    for(int k=0; k<4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if(nx < 0 || nx > R-1 || ny < 0 || ny > C-1)
                            continue;

                        if(arr[nx][ny] == -1)
                            continue;

                        tmp[nx][ny] += arr[i][j]/5;
                        tmp[i][j] -= arr[i][j]/5;
                    }
                }
            }
        }

        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(arr[i][j] != -1) {
                    arr[i][j] += tmp[i][j];
                }
            }
        }
    }


    static void circulation() {
        int a = arr[aircleaner-1][1];
        arr[aircleaner-1][1] = 0;
        int tmp;
        for(int i=2; i<C; i++) {
            tmp = arr[aircleaner-1][i];
            arr[aircleaner-1][i] = a;
            a = tmp;

        }
        for(int i=aircleaner-2; i >=0; i--) {
            tmp = arr[i][C-1];
            arr[i][C-1] = a;
            a = tmp;
        }
        for(int i=C-2; i >=0; i--) {
            tmp = arr[0][i];
            arr[0][i] =a;
            a = tmp;
        }
        for(int i=1; i<aircleaner-1; i++) {
            tmp = arr[i][0];
            arr[i][0] = a;
            a = tmp;
        }
        a = arr[aircleaner][1];
        arr[aircleaner][1] = 0;
        for(int i=2; i<C; i++) {
            tmp = arr[aircleaner][i];
            arr[aircleaner][i] = a;
            a = tmp;
        }
        for(int i=aircleaner+1; i <R; i++) {
            tmp = arr[i][C-1];
            arr[i][C-1] = a;
            a = tmp;
        }
        for(int i=C-2; i >=0; i--) {
            tmp = arr[R-1][i];
            arr[R-1][i] =a;
            a = tmp;
        }
        for(int i=R-2; i>aircleaner; i--) {
            tmp = arr[i][0];
            arr[i][0] = a;
            a = tmp;
        }
    }

    static void calc() {
        int tmp = 0;
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                tmp += arr[i][j];
            }
        }
        tmp += 2;

        ans = tmp;
    }
    static void print() {
        System.out.println("================");
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
