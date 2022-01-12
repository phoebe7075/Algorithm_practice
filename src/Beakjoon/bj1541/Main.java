package Beakjoon.bj1541;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        String operand[] = s.split("\\D");
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<operand.length; i++) {
            queue.offer(Integer.parseInt(operand[i]));
        }
        String operator[] = s.split("\\d*");
        String tmp = "";
        for(int i=0; i<operator.length; i++) {
            tmp += operator[i];
        }
        int oper1 = 0, oper2 = 0, idx=0;
        oper1 = queue.poll();
        while (!queue.isEmpty()){
            if(tmp.charAt(idx) == '-') {
                oper2 = queue.poll();
                for(int i=idx+1; i<tmp.length(); i++) {
                    if(tmp.charAt(i) == '+') {
                        oper2 += queue.poll();
                    }else {
                        idx = i;
                        break;
                    }
                }
                oper1 = oper1 - oper2;
            }else {
                oper1 += queue.poll();
                idx++;
            }
        }
        System.out.println(oper1);

    }
}
