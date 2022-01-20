package Beakjoon.old.bj1987;

import java.util.*;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static char[][] arr;
    static boolean[][] visitarr;
    static boolean[] alparr = new boolean[26];
    static int[][] arr2;
    static int ax;
    static int ay;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ax = scanner.nextInt();
        ay = scanner.nextInt();
        scanner.nextLine();
        String s;
        arr = new char[ax][ay];
        visitarr = new boolean[ax][ay];
        arr2 = new int[ax][ay];
        for(int i =0; i < ax; i++){
            s = scanner.nextLine();
            for(int j=0; j < ay; j++){
                arr[i][j] = s.charAt(j);
            }
        }
        Main.dfs(0,0);
        int max = 0;

        for(int i =0; i < ax; i++){
            for(int j=0; j < ay; j++){
                if(max < arr2[i][j]) {
                    max = arr2[i][j];
                }
            }
        }
        for(int i =0; i < ax; i++){
            for(int j=0; j < ay; j++){
                System.out.print(arr2[i][j]);
            }
            System.out.println();
        }

        System.out.println(max);
    }



    static void dfs(int x, int y){
        Stack<Dot> stack= new Stack<Dot>();
        stack.push(new Dot(x,y));
        arr2[x][y]++;
        alparr[arr[x][y]-'A'] = true;
        while(!stack.isEmpty()){
            Dot dot = stack.pop();
            for(int i=0; i<26; i++) {
                System.out.print(alparr[i]);
            }
            System.out.println();
            for(int i=0; i<4; i++){
                int nextX = dot.x + dx[i];
                int nextY = dot.y + dy[i];
                if (nextX < 0 || nextX >= ax || nextY < 0 || nextY >= ay)
                    continue;
                if (arr2[nextX][nextY] != 0 )
                    continue;
                if((arr[dot.x][dot.y] != arr[nextX][nextY]) && alparr[arr[nextX][nextY]-'A'] == false) {
                    arr2[nextX][nextY] = arr2[dot.x][dot.y]+1;
                    System.out.println(arr2[nextX][nextY]);
                    stack.push(new Dot(nextX,nextY));
                    alparr[arr[nextX][nextY]-'A'] = true;
                }
            }
            alparr[arr[dot.x][dot.y]-'A'] = false;
        }

    }


}
class Dot{
    int x;
    int y;

    Dot(int x, int y){
        this.x = x;
        this.y = y;
    }

    int getX(){
        return this.x;
    }

    int getY(){
        return this.y;
    }
}