package Programmers.KaKao2022_05;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new int[][]{{1,2,3},{4,5,6},{7,8,9}}, new String[]{"R","S"});
    }
}
class Solution {
    public int[][] solution(int[][] rc, String[] operations) {
        int[][] answer;
        for(String s : operations) {
            if(s.charAt(0) == 'R') {
                int x=0, y=0;
                int tmp = rc[x][y];
                int tmp2;
                for(int i=0; i<rc[0].length-1; i++) {
                    tmp2 = rc[x][y+1];
                    rc[x][y+1] = tmp;
                    tmp = tmp2;
                    y++;
                }

                for(int i=0; i<rc.length-1; i++) {
                    tmp2 = rc[x+1][y];
                    rc[x+1][y] = tmp;
                    tmp = tmp2;
                    x++;
                }

                for(int i=0; i<rc[0].length-1; i++) {
                    tmp2 = rc[x][y-1];
                    rc[x][y-1] = tmp;
                    tmp = tmp2;
                    y--;
                }

                for(int i=0; i<rc.length-1; i++) {
                    tmp2 = rc[x-1][y];
                    rc[x-1][y] = tmp;
                    tmp = tmp2;
                    x--;
                }
            }else {
                int[] arr = new int[rc[0].length];
                int[] arr2 = new int[rc[0].length];
                for(int j=0; j<rc[0].length; j++) {
                    arr[j] = rc[0][j];
                }
                for(int i=0; i<rc.length; i++) {
                    for(int j=0; j<rc[0].length; j++) {
                        arr2[j] = rc[(rc.length+i+1)%rc.length][j];
                        rc[(rc.length+i+1)%rc.length][j] = arr[j];
                        arr[j] = arr2[j];
                    }
                }
            }
        }
        answer = rc;
        return answer;
    }
}