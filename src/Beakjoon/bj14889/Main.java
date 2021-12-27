package Beakjoon.bj14889;


import java.util.Scanner;
public class Main {
    static int[][] arr;
    static int sin1,sin2,equal = 99999;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        scanner.nextLine();

        arr = new int[count][count];
        boolean[] visit = new boolean[count];
        for(int i=0; i < count; i++){
            for(int j=0; j<count; j++){
                arr[i][j] = scanner.nextInt();
            }
            scanner.nextLine();
        }

        combination(visit,0, count,count/2);

        System.out.println(equal);
    }

    static void combination(boolean[] visited, int start, int n, int r) {
        if(r == 0){
            synerge(visited,n);
            return;
        }

        for(int i=start; i < n; i++){
            visited[i] = true;
            combination(visited, i+1, n, r-1);
            visited[i] = false;
        }
    }
    static void synerge(boolean[] visited, int n){
        for(int i=0; i <n; i++){
            if(visited[i]) {
                for(int j=0; j<n; j++){
                    if (i != j && visited[j]) {
                        sin1 = sin1+ arr[i][j];
                    }
                }
            }else{
                for(int j=0; j<n; j++){
                    if (i != j && !visited[j]) {
                        sin2 = sin2+ arr[i][j];
                    }
                }
            }
        }
        if(Math.abs(sin1 - sin2) < equal){
            equal = Math.abs(sin1 - sin2);
        }
        sin1 = 0;
        sin2 = 0;
    }
}
