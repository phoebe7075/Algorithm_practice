package Programmers.lv2_행렬_테두리_회전하기;

public class Main {
}
class Solution {
    static int[][] arr;
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        arr = new int[rows][columns];
        for(int i=0; i<rows; i++) {
            for(int j=0; j<columns; j++) {
                arr[i][j] = (i* columns) + (j+1);
            }
        }
        for(int i=0; i<queries.length; i++) {
            answer[i] = Circular(queries[i][0]-1,queries[i][1]-1,queries[i][2]-1,queries[i][3]-1);
        }
        return answer;
    }

    public int Circular(int x, int y, int nx, int ny) {
        int next = arr[x][y];
        int min = next;
        int idx1=x, idx2=y;
        int tmp;
        for(int i=y; i<ny; i++) {
            tmp = arr[idx1][idx2+1];
            arr[idx1][idx2+1] = next;
            if(next < min) {
                min = next;
            }
            next = tmp;

            idx2++;
        }
        for(int i=x; i<nx; i++) {
            tmp = arr[idx1+1][idx2];
            arr[idx1+1][idx2] = next;
            if(next < min) {
                min = next;
            }
            next = tmp;
            idx1++;
        }

        for(int i=ny; i>y; i--) {
            tmp = arr[idx1][idx2-1];
            arr[idx1][idx2-1] = next;
            if(next < min) {
                min = next;
            }
            next = tmp;

            idx2--;
        }

        for(int i=nx; i>x; i--) {
            tmp = arr[idx1-1][idx2];
            arr[idx1-1][idx2] = next;
            if(next < min) {
                min = next;
            }
            next = tmp;
            idx1--;
        }


        return min;
    }
}