package Beakjoon.old.bj1213;
import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        char[] answer = input.toCharArray();
        int[] arr = new int[26];
        for(int i=0; i < input.length(); i++){
            arr[input.charAt(i) - 'A']++;
        }
        int len = input.length();
        int idx1 = 0; int idx2 = len-1;
        int num = 0;
        boolean flag = false;
        for(int i=0; i<26; i++){
            if(arr[i] >0)
                num++;
        }

        if(len%2 == 0) { //길이가 짝수 일 때
            if(num > len/2) { //문자가 전체 문자 길이 절반 이상일때 (문자열 4 문자 3개일때 회문 불가) 회문 불가
                System.out.println("I'm Sorry Hansoo");
                return ;
            }
            for(int i=0; i< arr.length; i++) {
                if(arr[i]%2 == 1) { //개수가 홀수면 안됨.
                    System.out.println("I'm Sorry Hansoo");
                    return ;
                }
                for(int j=0; j < arr[i]/2; j++) { //문자의 개수 절반만큼 반복, 앞뒤로 채운다
                        answer[idx1++] = (char)(i+65);
                        answer[idx2--] = (char)(i+65);
                }
            }
        } else { //길이가 홀수 일 때
            if(num > len/2+1) { //문자가 전체 문자 길이 절반 이상일 때 (문자열 5 문자 4개일때 회문 불가) 회문 불가
                System.out.println("I'm Sorry Hansoo");
                return ;
            }
            for(int i=0; i< arr.length; i++) {
                if(arr[i]%2 == 1 && flag == false) { //문자가 홀수 개일 경우 정 중앙에 한개 채움
                    answer[len/2] = (char)(i+65);
                    arr[i]--;
                    flag = true;
                }
                if(arr[i]%2 == 1 && flag == true){
                    System.out.println("I'm Sorry Hansoo");
                    return ;
                }
            }
            for(int i=0; i< arr.length; i++) {
                for(int j=0; j < arr[i]/2; j++) { //문자의 개수 절반만큼 반복, 앞뒤로 채운다
                    answer[idx1++] = (char)(i+65);
                    answer[idx2--] = (char)(i+65);
                }
            }

        }

        System.out.println(answer);
        return;
    }
}
