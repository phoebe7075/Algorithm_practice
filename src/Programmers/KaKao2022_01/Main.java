package Programmers.KaKao2022_01;

public class Main {
}
class Solution {
    public String solution(String[] survey, int[] choices) {
        int[] list = new int[4];
        int[] clist = new int[]{-3,-2,-1,0,1,2,3};
        String answer = "";
        for(int i=0; i<choices.length; i++) {
            char x =survey[i].charAt(0);
            char y =survey[i].charAt(1);
            if(x == 'R' || x == 'T') {
                if(x == 'R') {
                    list[0] += clist[choices[i]-1];
                }else {
                    list[0] += clist[7-choices[i]];
                }
            }else if (x == 'C' || x == 'F') {
                if(x == 'C') {
                    list[1] += clist[choices[i]-1];
                }else {
                    list[1] += clist[7-choices[i]];
                }
            }else if(x == 'J' || x == 'M') {
                if(x == 'J') {
                    list[2] += clist[choices[i]-1];
                }else {
                    list[2] += clist[7-choices[i]];
                }
            }else {
                if(x == 'A') {
                    list[3] += clist[choices[i]-1];
                }else {
                    list[3] += clist[7-choices[i]];
                }
            }
        }


        if(list[0] > 0) {
            answer += "T";
        }else if (list[0] < 0) {
            answer += "R";
        }else {
            answer += "R";
        }
        if(list[1] > 0) {
            answer += "F";
        }else if (list[1] < 0) {
            answer += "C";
        }else {
            answer += "C";
        }

        if(list[2] > 0) {
            answer += "M";
        }else if (list[2] < 0) {
            answer += "J";
        }else {
            answer += "J";
        }

        if(list[3] > 0) {
            answer += "N";
        }else if (list[3] < 0) {
            answer += "A";
        }else {
            answer += "A";
        }


        return answer;
    }
}