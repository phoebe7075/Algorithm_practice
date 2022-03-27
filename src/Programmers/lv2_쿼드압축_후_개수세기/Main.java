package Programmers.lv2_쿼드압축_후_개수세기;

public class Main {
}

class Solution {
    static int zerocount = 0, onecount = 0;
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        counting(arr,0,0,arr.length);
        answer[0] = zerocount;
        answer[1] = onecount;
        return answer;
    }


    public void counting(int[][] arr, int x, int y, int n) {
        boolean flag = false;

        boolean flag2;
        if(arr[x][y] == 0) {
            flag2 = false;
        }else {
            flag2 = true;
        }
        outerLoop :
        for(int i=x; i<x+n; i++) {
            for(int j=y; j<y+n; j++) {
                if(arr[i][j] == 0 && flag2) {
                    flag = true;
                    break outerLoop;
                }else if (arr[i][j] == 1 && !flag2) {
                    flag = true;
                    break outerLoop;
                }
            }
        }

        if(flag) {
            counting(arr,x,y,n/2);
            counting(arr,x,y+(n/2),n/2);
            counting(arr,x+(n/2),y,n/2);
            counting(arr,x+(n/2),y+(n/2),n/2);
        }else {
            if(flag2) onecount++;
            else zerocount++;
        }
    }
}