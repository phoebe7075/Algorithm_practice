package Beakjoon.old.bj9019;


import java.io.*;
import java.util.*;
public class Main {
    static int[][] arr;
    static int N,E;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int a=0; a<T; a++) {
            String s[] = br.readLine().split(" ");
            N = Integer.parseInt(s[0]);
            E = Integer.parseInt(s[1]);
            arr = new int[10000][2];
            bfs();
            print(E);
        }
    }

    static void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        while (!queue.isEmpty()){
            int a = queue.poll();

            if(a==E){
                break;
            }

            if(a < 5000) {
                if (arr[a*2][1] == 0) {
                    queue.add(a*2);
                    arr[a*2][0] = a;
                    arr[a*2][1] = 1;
                }
            }else if (arr[(a*2)%10000][1] == 0) {
                queue.add((a*2)%10000);
                arr[(a*2)%10000][0] = a;
                arr[(a*2)%10000][1] = 1;
            }

            if(a > 0) {
                if(arr[a-1][1] == 0){
                    queue.add(a-1);
                    arr[a-1][0]= a;
                    arr[a-1][1] = 2;
                }
            }else if (arr[9999][1] == 0){
                queue.add(9999);
                arr[9999][0] = 0;
                arr[9999][1] = 2;
            }

            int Shift1 = leftShift(a);
            if (arr[Shift1][1] == 0) {
                queue.add(Shift1);
                arr[Shift1][0] = a;
                arr[Shift1][1] = 3;
            }


            int Shift2 = rightShift(a);
            if (arr[Shift2][1] == 0) {
                queue.add(Shift2);
                arr[Shift2][0] = a;
                arr[Shift2][1] = 4;
            }

        }
    }


    static int leftShift(int num) {
        num *= 10;
        num += num / 10000;
        return num % 10000;

    }
    static int rightShift(int num) {
        num += (num % 10) * 10000;
        return num /= 10;
    }

    static void print(int n) {
        int a = arr[n][1];
        int idx = n;
        StringBuilder sb = new StringBuilder();
        while (idx != N){
            if(a == 1) {
                sb.append("D");
            }else if (a==2) {
                sb.append("S");
            }else if(a==3) {
                sb.append("L");
            }else {
                sb.append("R");
            }
            idx = arr[idx][0];
            a = arr[idx][1];

        }

        System.out.println(sb.reverse().toString());
    }
}
