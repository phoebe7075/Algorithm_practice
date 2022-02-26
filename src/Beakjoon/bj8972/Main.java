package Beakjoon.bj8972;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class Main {
    static int R,C;
    static int arr[][];
    static int dx[] = {0, 1, 1, 1, 0, 0, 0, -1, -1, -1};
    static int dy[] = {0, -1, 0, 1, -1, 0, 1, -1, 0, 1};
    static Node js;
    static ArrayList<Node> madAdu = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s[] = br.readLine().split(" ");
        R = Integer.parseInt(s[0]);
        C = Integer.parseInt(s[1]);
        arr = new int[R][C];
        String s2;
        for(int i=0; i<R; i++) {
            s2 = br.readLine();
            for(int j=0; j<C; j++) {
                if(s2.charAt(j) == 'I') {
                    js = new Node(i,j);
                    arr[i][j] = -1;
                }else if(s2.charAt(j) == 'R') {
                    madAdu.add(new Node(i,j));
                    arr[i][j] = 1;
                }
            }
        }
        s2 = br.readLine();
        int turn = 0;

        while (turn < s2.length()) {
            turn++;
            int dir = s2.charAt(turn-1) - '0';
            arr[js.x][js.y] = 0;
            int nx = js.x+dx[dir], ny= js.y+dy[dir];
            if(arr[nx][ny] == 1) {
                System.out.println("kraj " + turn);
                return;
            }
            js.x = nx; js.y = ny;
            arr[js.x][js.y] = -1;
            for(Node adu : madAdu) {
                int shortest = 1000;
                for(int i=1; i<=9; i++) {
                    int tmpx = adu.x + dx[i], tmpy = adu.y + dy[i];

                    if(tmpx < 0 || tmpx > R-1 || tmpy < 0 || tmpy > C-1)
                        continue;
                    if(shortest > (Math.abs(js.x-tmpx) + Math.abs(js.y-tmpy))) {
                        shortest = (Math.abs(js.x-tmpx) + Math.abs(js.y-tmpy));
                        nx = tmpx; ny = tmpy;
                    }
                }
                arr[adu.x][adu.y]--;

                if(nx == js.x && ny == js.y) {
                    System.out.println("kraj " + turn);
                    return;
                }

                arr[nx][ny]++;
                adu.x = nx; adu.y = ny;
            }

            for(int i=0; i<R; i++) {
                for(int j=0; j<C; j++) {
                    if(arr[i][j] > 1) {
                        aduinoBoom(i,j);
                        arr[i][j] = 0;
                    }
                }
            }

        }
        print();
    }


    static void aduinoBoom(int x, int y) {
        ArrayList<Node> list = new ArrayList<>();
        for(Node adu : madAdu) {
            if(adu.x == x && adu.y == y) {
                list.add(new Node(adu.x,adu.y));
            }
        }

        madAdu.removeAll(list);
    }

    static void print(){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                if(arr[i][j] == 0) {
                    sb.append(".");
                }else if (arr[i][j] == -1) {
                    sb.append("I");
                }else {
                    sb.append("R");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}

class Node {
    int x, y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return x == node.x &&
                y == node.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
