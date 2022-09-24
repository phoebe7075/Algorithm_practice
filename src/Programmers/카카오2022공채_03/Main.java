package Programmers.카카오2022공채_03;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new int[][]{{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200}, {32, 6900}}, new int[]{1300, 1500, 1600, 4900});
    }
    
}

class Solution {
    static int[] answer = new int[2];
    static int[][] userlist;
    static int[] emoticonlist;
    static int n;
    
    public int[] solution(int[][] users, int[] emoticons) {
        userlist = users;
        emoticonlist = emoticons;
        n = emoticons.length;
        backT(0, new int[n]);
        return answer;
    }


    static void backT(int idx, int[] salearr) {
        if(idx == n) {
            int plus = 0, sales=0;
            int[] tmplist = new int[n];
            for(int i=0; i<n; i++) {
                tmplist[i] = emoticonlist[i]*(100-salearr[i])/100;
            }
            int[] tmpuserlist = new int[userlist.length];
            for(int i=0; i<userlist.length; i++) {
                for(int j=0; j<n; j++) {
                    if(salearr[j] >= userlist[i][0]) {
                        tmpuserlist[i] += tmplist[j];
                    }
                }

                if(tmpuserlist[i] >= userlist[i][1]) {
                    plus++;
                }else {
                    sales += tmpuserlist[i];
                }
            }

            if(answer[0] < plus) {
                answer[0] = plus;
                answer[1] = sales;
            }else if(answer[0] == plus) {
                answer[1] = Math.max(answer[1], sales);
            }
            return;
        }

        salearr[idx] = 10;
        backT(idx+1, salearr);
        salearr[idx] = 20;
        backT(idx+1, salearr);
        salearr[idx] = 30;
        backT(idx+1, salearr);
        salearr[idx] = 40;
        backT(idx+1, salearr);
    }
}