package Programmers.삼각달팽이;

public class Main {
    public static void main(String[] args) {
        int n = 6;
        int[] answer = new int[(n*(n+1))/2];
        int arr[][] = new int[n][n];
        int idx1 = -1, idx2 = 0;
        int count = 0;
        int x = 1;
        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j++) {
                if(i%3 == 0) {
                    idx1++;
                }else if(i%3 == 1) {
                    idx2++;
                }else {
                    idx1--;
                    idx2--;
                }
                arr[idx1][idx2] = x++;
            }
        }
        idx1 = 0;
        for(int i=1; i<n+1; i++) {
            for(int j=0; j<i; j++) {
                answer[idx1] = arr[i-1][j];
                idx1++;
            }
        }
    }
}
