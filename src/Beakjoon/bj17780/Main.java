package Beakjoon.bj17780;

import java.io.*;

public class Main {
    static Horse[] horses;
    static int N, K;
    static int ches[][];
    static int dx[] = {0, 0, 0, -1, 1};
    static int dy[] = {0, 1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        K = Integer.parseInt(s[1]);
        ches = new int[N][N];
        horses = new Horse[K];
        for(int i=0; i<N; i++) {
            s = br.readLine().split(" ");
            for(int j=0; j<N; j++) {
                ches[i][j] = Integer.parseInt(s[j]);
            }
        }
        int x,y,d;
        for(int i=0; i<K; i++) {
            s = br.readLine().split(" ");
            x = Integer.parseInt(s[0])-1;
            y = Integer.parseInt(s[1])-1;
            d = Integer.parseInt(s[2]);

            horses[i] = new Horse(x,y,d,i);
        }

        int turn = 0;

        while (turn < 1000) {
            turn++;
            //System.out.println(turn);
            for(int i=0; i<K; i++) {
                Horse tmp = horses[i];
                if(!tmp.isBottom)
                    continue;
                int nx = tmp.x +dx[tmp.dir], ny = tmp.y +dy[tmp.dir];

                if(isBlue(nx,ny)) {
                    tmp.dir = DirectionChange(tmp.dir);
                    nx = tmp.x +dx[tmp.dir]; ny = tmp.y +dy[tmp.dir];
                    if(isBlue(nx,ny))
                        continue;
                }

                if(ches[nx][ny] == 1) {
                    int horseNum = isHorseThere(nx,ny);
                    if(horseNum >= 0) {
                        tmp.isBottom = false;
                        horses[horseNum].top = i;
                        horses[horseNum].count += tmp.count;
                        if(horses[horseNum].count >= 4) {
                            System.out.println(turn);
                            return;
                        }
                    }else { //말이 없는 경우 위와 아래를 뒤집어야 함.
                        tmp.isBottom = false;
                        horses[tmp.top].isBottom = true;
                        horses[tmp.top].top = i;
                        horses[tmp.top].x = nx;
                        horses[tmp.top].y = ny;
                        horses[tmp.top].count = tmp.count;
                    }
                }

                if(ches[nx][ny] == 0) {
                    int horseNum = isHorseThere(nx,ny);
                    if(horseNum >= 0) {
                        tmp.isBottom = false;
                        horses[horseNum].count += tmp.count;
                        horses[horseNum].top = tmp.top;
                        if(horses[horseNum].count >= 4) {
                            System.out.println(turn);
                            return;
                        }
                    }else {
                        tmp.x = nx;
                        tmp.y = ny;
                    }
                }
                //print();
            }
        }
        System.out.println(-1);
    }

    static boolean isBlue(int nx, int ny) {
        if(nx < 0 || nx > N-1 || ny < 0 || ny > N-1) {
            return true;
        }
        if(ches[nx][ny] == 2) {
            return true;
        }
        return false;
    }

    static int DirectionChange(int dir) {
        if(dir%2 == 1)
            return dir+1;
        return dir-1;
    }

    static int isHorseThere(int nx, int ny) {
        for(int i=0; i<K; i++) {
            if(horses[i].x == nx && horses[i].y == ny && horses[i].isBottom) {
                return i;
            }
        }

        return -1;
    }

    static void print() {
        System.out.println("====================");
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                int tmp = isHorseThere(i,j);
                if(tmp >= 0) {
                    System.out.print((tmp+1) + " ");
                }else {
                    if(ches[i][j] == 0)
                        System.out.print("W ");
                    else if(ches[i][j] == 1)
                        System.out.print("R ");
                    else
                        System.out.print("B ");
                }
            }
            System.out.println();
        }
    }
}

class Horse{
    int x, y, dir;
    int count = 1;
    boolean isBottom=true;
    int top;
    Horse(int x, int y, int d, int top) {
        this.x = x;
        this.y = y;
        this.dir =d;
        this.top = top;
    }
}
