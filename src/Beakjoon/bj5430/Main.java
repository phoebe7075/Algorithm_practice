package Beakjoon.bj5430;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i=0; i< N; i++) {
            String s = br.readLine();
            int idx = Integer.parseInt(br.readLine());
            String astring = br.readLine();
            astring = astring.substring(1,astring.length()-1);
            StringTokenizer st = new StringTokenizer(astring,",");
            Deque<Integer> dq = new ArrayDeque<Integer>();
            while (st.hasMoreTokens()) {
                dq.addLast(Integer.parseInt(st.nextToken()));
            }
            boolean flag = false;
            boolean flip = false; // 정방향
            int idx1=0, idx2=idx-1;
            for(int j=0; j<s.length(); j++) {
                if(s.charAt(j) == 'R') {
                    flip = !flip;
                }else if(s.charAt(j) == 'D') {
                    if(dq.isEmpty()) {
                        System.out.println("error");
                        flag = true;
                        break;
                    }else {
                        if (flip){
                            dq.removeLast();
                        }else {
                            dq.removeFirst();
                        }
                    }
                }
            }
            if (flag) {
                continue;
            }
            StringBuffer sb = new StringBuffer();
            sb.append("[");
            while (!dq.isEmpty()) {
                if(flip) {
                    sb.append(dq.removeLast() + ",");

                }else {
                    sb.append(dq.removeFirst() + ",");
                }
            }
            String ans = sb.toString();
            if (ans.length() > 2) {
                ans = ans.substring(0,ans.length()-1);
                ans = ans.concat("]");
            }else {
                ans = "[]";
            }
            System.out.println(ans);
        }
    }
}
