package Beakjoon.bj1918;

import java.io.*;
import java.util.Stack;

public class Main {
    static Stack<Character> stack = new Stack<>();
    static String s;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<s.length(); i++) {
            char x = s.charAt(i);
            if(x >= 'A' && x <= 'Z') {
                sb.append(x);
            }else {
                if(x == '(') {
                    stack.push(x);
                }else if (x == ')') {
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        sb.append(stack.pop());
                    }
                    if(!stack.isEmpty()) stack.pop();
                }else {
                    while (!stack.isEmpty() && operand(stack.peek()) >= operand(x)) {
                        sb.append(stack.pop());
                    }
                    stack.push(x);
                }
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb.toString());
    }
    static int operand(char a) {
        if(a == '*' || a=='/') return 2;
        else if(a == '+' || a == '-') return 1;
        else return 0;
    }
}
