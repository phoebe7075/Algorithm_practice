package Programmers.Line2022공채_2;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        //solution.solution(2, new String[]{"slang", "badword"}, "badword ab.cd bad.ord .word sl.. bad.word");
        solution.solution(3, new String[]{"abcde", "cdefg", "efgij"}, ".. ab. cdefgh .gi. .z.");
    }
    
}
class Solution {
    public String solution(int k, String[] dic, String chat) {
        StringBuilder sb = new StringBuilder();
        String s[] = chat.split(" ");
        for(int i=0; i<s.length; i++) {
            boolean res = false;
            for(String x : dic) {
                res = check(k, x, s[i]);

                if(res) {
                    break;
                }
            }
            if(res) {
                for(int j=0; j<s[i].length(); j++) {
                    sb.append("#");
                }
                sb.append(" ");
            }else {
                sb.append(s[i]);
                sb.append(" ");
            }
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    static boolean check(int k, String dic, String chat) {
        int count = 0;
        int idx = 0;
        for(int i=0; i<dic.length(); i++) {
            if(dic.charAt(i) == chat.charAt(idx)) {
                if(count > 0) {
                    count = 0;
                }
                idx++;
                continue;
            }else {
                if(chat.charAt(idx) != '.') {
                    if(count > 0) {
                        count--;
                        continue;
                    }else {
                        return false;
                    }
                }else {
                    if(count > 0) {
                        count--;
                        continue;
                    }
                    count = k-1;
                    if(idx < chat.length()-1) idx++;
                    
                }
            }
        }

        if(idx < chat.length()) {
            if(chat.charAt(idx) == '.') {
                return true;
            }
            return false;
        }
        return true;
    }
}