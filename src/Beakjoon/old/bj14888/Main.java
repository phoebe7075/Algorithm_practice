package Beakjoon.old.bj14888;

import java.util.Scanner;
public class Main {
    static char[] op = {'+','-','*','/'};
    static char[] oper;
    static char[] oparr;
    static int[] arr;
    static int[] opcount;
    static int count;
    static int total,max=-1000000000, min=1000000000;
    static boolean[] visit;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        count = scanner.nextInt();
        scanner.nextLine();
        oparr = new char[count-1];
        opcount = new int[4];
        oper = new char[count-1];
        arr = new int[count];
        visit = new boolean[count-1];
        for(int i=0; i < count; i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.nextLine();

        for(int i=0; i < 4; i++) {
            opcount[i] = scanner.nextInt();
        }
        scanner.nextLine();
        int tmpidx = 0;
        for(int i=0; i < 4; i++) {
            if(opcount[i] > 0) {
                for(int j=0; j< opcount[i]; j++) {
                    oper[tmpidx++] = op[i];
                }
            }
        }
        rePerm(0);

        System.out.println(max + "\n" + min);
    }

    static void rePerm(int r){
        if(r == count-1){
            calc();
            return;
        }

        for(int i=0; i<count-1; i++){
            if (visit[i])
                continue;
            visit[i] = true;
            oparr[r] = oper[i];
            rePerm(r+1);
            visit[i] = false;
        }
    }

    static void calc(){
        int tmp = arr[0];
        for(int i=0; i<count-1; i++) {
            if(oparr[i] == '+') {
                tmp = tmp + arr[i+1];
            }else if(oparr[i] == '-') {
                tmp = tmp - arr[i+1];
            }else if(oparr[i] == '*') {
                tmp = tmp * arr[i+1];
            }else if(oparr[i] == '/') {
                tmp = tmp / arr[i+1];
            }
        }
        total = tmp;
        if(total > max) {
            max = total;
        }
        if (total < min) {
            min = total;
        }
        total = 0;
    }
}
