package Beakjoon.bj17837;

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

            horses[i] = new Horse(x,y,d,-1);
        }

        int turn = 0;

        while (turn < 1000) {
            turn++;
            //System.out.println(turn);
            for(int i=0; i<K; i++) {
                Horse tmp = horses[i];
                int nx = tmp.x +dx[tmp.dir], ny = tmp.y +dy[tmp.dir];
                if(isBlue(nx,ny)) {
                    tmp.dir = DirectionChange(tmp.dir);
                    nx = tmp.x +dx[tmp.dir]; ny = tmp.y +dy[tmp.dir];
                    if(isBlue(nx,ny))
                        continue;
                }


                if(ches[nx][ny] == 1) {
                    int horseNum = isHorseThere(nx,ny);
                    int bottomhorse = i;
                    if(tmp.bottom != -1)
                        diconHorse(i,tmp.x,tmp.y);
                    if(tmp.isUpper) {
                        bottomhorse = flipHorse(i,tmp.count);
                        tmp = horses[bottomhorse];
                        UpperHorseMove(tmp.top,nx,ny);
                    }

                    if(horseNum >= 0) {
                        HorseReCount(horseNum,tmp.count,bottomhorse);

                        tmp.isBottom = false;
                        tmp.x = nx; tmp.y = ny;
                        if(horses[horseNum].count >= 4) {
                            System.out.println(turn);
                            return;
                        }
                    }else {
                        tmp.isBottom = true;
                        tmp.x = nx; tmp.y = ny;
                    }
                }else if(ches[nx][ny] == 0) {
                    if(tmp.bottom != -1)
                        diconHorse(i,tmp.x,tmp.y);
                    if(tmp.isUpper)
                        UpperHorseMove(tmp.top,nx,ny);
                    int horseNum = isHorseThere(nx,ny);
                    if(horseNum >= 0) {
                        HorseReCount(horseNum,tmp.count,i);
                        horses[i].isBottom = false;
                        horses[i].x = nx; horses[i].y = ny;
                        if(horses[horseNum].count >= 4) {
                            System.out.println(turn);
                            return;
                        }
                    }else {
                        tmp.isBottom = true;
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

    static void UpperHorseMove(int hn, int nx, int ny) {
        int horseNum = hn;
        while(horses[horseNum].isUpper){
            horses[horseNum].x = nx;
            horses[horseNum].y = ny;
            horseNum = horses[horseNum].top;
        }
        horses[horseNum].x = nx;
        horses[horseNum].y = ny;
    }

    static void HorseReCount(int hn, int count, int nthn) {
        int horseNum = hn;
        while(horses[horseNum].isUpper) {
            horses[horseNum].count += count;
            horseNum = horses[horseNum].top;
        }
        horses[horseNum].count += count;
        horses[horseNum].isUpper = true;
        horses[horseNum].top = nthn;
        horses[nthn].bottom = horseNum;
    }

    static int flipHorse(int hn, int count) {
        int horseNum = hn;
        while (horses[horseNum].isUpper) {
            horseNum = horses[horseNum].top;
        }
        int tmpBottom = -1;
        horses[horseNum].isBottom = true;
        int rhn = horseNum;
        for(int i=count; i>1; i--) {
            horses[horseNum].count = i;
            horses[horseNum].isUpper = true;
            horses[horseNum].top = horses[horseNum].bottom;
            int nextH = horses[horseNum].bottom;
            horses[horseNum].bottom = tmpBottom;
            tmpBottom = horseNum;
            horseNum = nextH;
        }
        horses[horseNum].count = 1;
        horses[horseNum].isUpper = false;
        horses[horseNum].top = -1;
        horses[horseNum].bottom = tmpBottom;
        horses[horseNum].isBottom = false;
        return rhn;
    }

    static void diconHorse(int hn, int x, int y) {
        int nexTop = horses[hn].bottom;
        horses[nexTop].top = -1;
        horses[nexTop].isUpper = false;
        while (nexTop != -1) {
            horses[nexTop].count -= horses[hn].count;
            nexTop = horses[nexTop].bottom;
        }
        horses[hn].bottom = -1;
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
    boolean isUpper =false;
    boolean isBottom = true;
    int top;
    int bottom = -1;
    Horse(int x, int y, int d, int top) {
        this.x = x;
        this.y = y;
        this.dir =d;
        this.top = top;
    }
}
