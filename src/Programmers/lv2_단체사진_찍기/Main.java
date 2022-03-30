package Programmers.lv2_단체사진_찍기;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(2,new String[]{"N~F=0", "R~T>2"}));
    }
}
class Solution {
    static int[] rocation;
    static String[] condition;
    static int count = 0;
    public int solution(int n, String[] data) {
        int answer = 0;
        count = 0;
        rocation = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1};
        Map<Character, Integer>map = new HashMap<>();
        map.put('A',1);map.put('C',2);map.put('F',3);map.put('J',4);map.put('M',5);map.put('N',6);
        map.put('R',7);map.put('T',8);

        condition = new String[data.length];

        for(int i=0; i<data.length; i++) {
            String[] x = data[i].split("~");
            condition[i] = Integer.toString(map.get(x[0].charAt(0)));
            condition[i] += Integer.toString(map.get(x[1].charAt(0)));
            if(x[1].charAt(1) == '=') {
                condition[i] += "0";
            }else if (x[1].charAt(1) == '>') {
                condition[i] += "1";
            }else {
                condition[i] += "2";
            }
            condition[i] += Integer.toString(x[1].charAt(2) - '0');
        }


        perm(1);
        answer = count;
        return answer;
    }


    public void perm(int n) {
        if(n == 9) {
            count++;
            return;
        }


        for(int i=1; i<9; i++) {
            if(rocation[i] == -1) {
                rocation[i] = n;
                if(conditionCheck()) {
                    perm(n+1);
                }
                rocation[i] = -1;
            }
        }
    }

    public boolean conditionCheck() {
        for(int i=0; i<condition.length; i++) {
            int x1 = condition[i].charAt(0) - '0';
            int x2 = condition[i].charAt(1) - '0';
            int c = condition[i].charAt(2) - '0';
            int n = condition[i].charAt(3) - '0';
            if(rocation[x1] != -1 && rocation[x2] != -1) {
                if(c == 0) {
                    if(Math.abs(rocation[x1]-rocation[x2])-1 != n) {
                        return false;
                    }
                }else if (c==1) {
                    if(Math.abs(rocation[x1]-rocation[x2])-1 <= n) {
                        return false;
                    }
                }else {
                    if(Math.abs(rocation[x1]-rocation[x2])-1 >= n) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}