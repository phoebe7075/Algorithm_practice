package Beakjoon.old.bj1107;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int chanel =100;
    static int ans = 0;
    static boolean[] num; //고장난 번호
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = new boolean[10];
        String s = br.readLine();
        int n = Integer.parseInt(s);
        arr = new int[s.length()];
        int x = Integer.parseInt(br.readLine());
        if (x != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i< x; i++) {
                num[Integer.parseInt(st.nextToken())] = true;
            }
        }

        if(chanel == n) {
            System.out.println(ans);
            return;
        }
        if(Math.abs(chanel - n) < 3) {
            System.out.println(Math.abs(chanel - n));
            return;
        }

        ans = 500001;
        for(int i=0; i< Math.pow(10,s.length()+1); i++) {
            char[] chars = Integer.toString(i).toCharArray();
            boolean flag = false;
            for(int j=0; j<chars.length; j++) {
                if(num[chars[j] - '0']) {
                    flag = true;
                    break;
                }
            }
            if(flag){
                continue;
            }
            int tmp = Math.abs(n - i) + chars.length;
            ans = Math.min(ans,tmp);
        }

        ans = Math.min(ans,Math.abs(n-100));
        System.out.println(ans);
    }
}
