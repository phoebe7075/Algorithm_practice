package Beakjoon.bj1371;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr2 = new int[26];
        String s;
        while(scanner.hasNextLine()){
            s = scanner.nextLine();
            char[] arr = s.toCharArray();

            for(int i =0; i < arr.length; i++){
                if(arr[i] - 'a' >= 0 && arr[i] - 'a' <= 26){
                    arr2[arr[i] - 'a']++;
                }
            }
        }
        int max = 0;

        for(int i=0; i<26; i++){
            if(max < arr2[i]) {
                max = arr2[i];
            }
        }
        for(int i=0; i<26; i++){
                if(max == arr2[i]) {
                    System.out.print((char)(i+'a'));
                }
        }
    }
}
