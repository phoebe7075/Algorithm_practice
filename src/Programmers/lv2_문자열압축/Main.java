package Programmers.lv2_문자열압축;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int answer = s.length();
        int len = s.length();

        for(int i=1; i<len; i++) {
            StringBuilder tmp = new StringBuilder();
            StringBuilder tmp2 = new StringBuilder();
            int count = 0;
            int x = 0;
            for(int j=0; j<len; j+=i) {
                if(tmp.length() < i) {
                    tmp.append(s, j, j+i);
                }else if(tmp2.length() < i) {
                    if(len-j < i) {
                        tmp2.append(s, j, s.length());
                    }else {
                        tmp2.append(s, j, j+i);
                    }
                }

                if(tmp.length()==i && tmp2.length()==i){
                    if(tmp2.toString().equals(tmp.toString())) {
                        count++;
                        tmp2 = new StringBuilder();
                    }else {
                        if(count > 0) {
                            x += i+(Integer.toString(count+1).length());
                        }else {
                            x += i;
                        }
                        tmp = new StringBuilder(tmp2.toString());
                        tmp2 = new StringBuilder();
                        count = 0;
                    }
                }
            }
            if(count != 0) {
                x += i+(Integer.toString(count+1).length());
                tmp = new StringBuilder();
            }
            if (tmp.length() > 0) {
                x += tmp.length();
            }
            if (tmp2.length() > 0) {
                x += tmp2.length();
            }
            if(answer > x) {
                answer = x;
            }
        }

        System.out.println(answer);
    }
}
