package Beakjoon.bj5525;


import java.io.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int itv = N*2+1;
        int m = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int idx = s.indexOf("I");
        int ans = 0;
        int temp = 1;
        char tmpc1 = s.charAt(idx), tmpc2;
        for(int i=idx+1; i<m; i++) {
            tmpc2 = s.charAt(i);
            if(temp == 0) {
                if (tmpc2 == 'I') {
                    tmpc1 = tmpc2;
                    temp = 1;
                    continue;
                }
            }
            if(tmpc1 != tmpc2) {
                tmpc1 = tmpc2;
                temp++;
            }else { // tmpc1 == tmpc2 oo, ii
                if(tmpc1 == 'O') {
                    temp = 0;
                }else {
                    temp = 1;
                }
            }

            if(temp == itv) {
                temp -= 2;
                ans++;
            }
        }
        System.out.println(ans);
    }
}
