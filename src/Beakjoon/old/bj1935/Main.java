package Beakjoon.old.bj1935;

import java.util.Stack;
import java.util.Scanner;
import java.text.DecimalFormat;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        scanner.nextLine();
        Stack<Double> stack = new Stack<Double>();
        String s = scanner.nextLine();
        char[] arr = s.toCharArray();
        double[] arr2 = new double[26];

        for(int i=0; i<count; i++){
            double a = scanner.nextDouble();
            arr2[i] = a;
            scanner.nextLine();
        }

        for(int i=0; i < arr.length; i++){
            if(arr[i] - 'A' >=0 && arr[i] - 'A' <= 26) {
                stack.push(arr2[arr[i] - 'A']);
            }
            if(arr[i] == '*'){
                double x = stack.pop();
                double y = stack.pop();
                stack.push(y*x);
            }else if(arr[i] == '/'){
                double x = stack.pop();
                double y = stack.pop();
                stack.push(y/x);
            }else if(arr[i] == '+'){
                double x = stack.pop();
                double y = stack.pop();
                stack.push(x+y);
            }else if(arr[i] == '-'){
                double x = stack.pop();
                double y = stack.pop();
                stack.push(y-x);
            }
        }
        DecimalFormat df = new DecimalFormat("#######.00");
        System.out.println(df.format(stack.pop()));
        return;
    }
}
