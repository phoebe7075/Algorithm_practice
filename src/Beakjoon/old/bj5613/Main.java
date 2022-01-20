package Beakjoon.old.bj5613;


import java.util.Scanner;
import java.util.Stack;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new Stack<Integer>();
        while (true){
            String s = scanner.nextLine();
            if(s.equals("=")) {
                System.out.println(stack.pop());
                return;
            }

            if(s.equals("*")){
                int x = stack.pop();
                int y = scanner.nextInt();
                scanner.nextLine();
                stack.push(x*y);
            }else if(s.equals("/")){
                int x = stack.pop();
                int y = scanner.nextInt();
                scanner.nextLine();
                stack.push(x/y);
            }else if(s.equals("+")){
                int x = stack.pop();
                int y = scanner.nextInt();
                scanner.nextLine();
                stack.push(x+y);
            }else if(s.equals("-")){
                int x = stack.pop();
                int y = scanner.nextInt();
                scanner.nextLine();
                stack.push(x-y);
            }else{
                stack.push(Integer.parseInt(s));
            }
        }
    }
}
