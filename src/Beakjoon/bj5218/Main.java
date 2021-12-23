package Beakjoon.bj5218;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = scanner.nextInt();
        scanner.nextLine();

        for(int i=0; i<count; i++){
            String[] strings = scanner.nextLine().split(" ");
            System.out.print("Distances: ");

            for(int j=0; j < strings[0].length(); j++) {
                char a = strings[0].charAt(j);
                char b = strings[1].charAt(j);
                if(b >= a) {
                    System.out.print((b-a)+ " ");
                }else{
                    System.out.print((b-a+26)+ " ");
                }
            }
            System.out.println();
        }
    }
}
