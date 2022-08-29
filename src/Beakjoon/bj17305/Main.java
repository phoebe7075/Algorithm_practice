package Beakjoon.bj17305;
import java.io.*;
import java.util.*;
public class Main {
    static int n, w;
    static ArrayList<Integer> list3 = new ArrayList<>();
    static ArrayList<Integer> list5 = new ArrayList<>();

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        w = Integer.parseInt(s[1]);

        for(int i=0; i<n; i++) {
            s = br.readLine().split(" ");
            if(s[0].equals("3")) {
                list3.add(Integer.parseInt(s[1]));
            }else {
                list5.add(Integer.parseInt(s[1]));
            }
        }

        Collections.sort(list3,Comparator.reverseOrder());
        Collections.sort(list5,Comparator.reverseOrder());
        long[] sum3 = new long[list3.size()+1];
        long[] sum5 = new long[list5.size()+1];
        for(int i=1; i<sum3.length; i++) {
            sum3[i] = sum3[i-1]+list3.get(i-1);
        }
        for(int i=1; i<sum5.length; i++) {
            sum5[i] = sum5[i-1]+list5.get(i-1);
        }


        int x = Math.min(w/3, list3.size()); // 무게제한에 가장 많이 넣을 수 있는 3그램 사탕의 개수를 구함.
        long max = 0;
        while(x >= 0) {
            int y = Math.min((w-3*x)/5, list5.size()); // 현재 무게에서 3그램 사탕의 개수(x) 를 뺀 뒤 5그램 사탕을 넣을 수 있는 갯수와 5그램 사탕의 총 개수중 적은걸 선택.(인덱스 에러 방지)

            if(max < sum3[x]+sum5[y]) {
                max = sum3[x]+sum5[y];
            }
            x--;
        }
        
        System.out.println(max);
    }
}