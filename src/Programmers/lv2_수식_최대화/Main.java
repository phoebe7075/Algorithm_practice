package Programmers.lv2_수식_최대화;

import java.util.ArrayList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("100-200*300-500+20"));
    }
}
class Solution {
    static long ans;
    static char[] list = new char[]{'+','-','*'};
    static String[] operand;
    static String[] operator;
    public long solution(String expression) {
        long answer = 0;
        operand= expression.split("[0-9]+");
        operator = expression.split("[\\+\\-\\*]");
        perm(3,0,new char[3],new boolean[3]);
        answer = ans;
        return answer;
    }
    public void perm(int n, int r, char[] oper, boolean[] check) {
        if(n==r) {
            ArrayList<Long> optr = new ArrayList<>();
            for(String tmp : operator) {
                optr.add(Long.parseLong(tmp));
            }
            ArrayList<Character> oprd = new ArrayList<>();
            for(int i=1; i<operand.length; i++) {
                oprd.add(operand[i].charAt(0));
            }
            for(int k=0; k<3; k++) {
                for(int i=0; i<oprd.size(); i++) {
                    if(oprd.get(i) == oper[k]) {
                        long x = optr.remove(i+1);
                        long y = optr.remove(i);
                        oprd.remove(i);
                        if(oper[k]=='+') {
                            optr.add(i,x+y);
                        }else if(oper[k]=='-') {
                            optr.add(i,y-x);
                        }else if(oper[k]=='*') {
                            optr.add(i,x*y);
                        }
                        i--;
                    }
                }
            }

            if(ans < Math.abs(optr.get(0))) {
                ans = Math.abs(optr.get(0));
            }
            return;
        }

        for(int i=0; i<3; i++) {
            if(!check[i]) {
                check[i] = true;
                oper[i] = list[r];
                perm(n,r+1,oper,check);
                check[i] = false;
            }
        }
    }
}