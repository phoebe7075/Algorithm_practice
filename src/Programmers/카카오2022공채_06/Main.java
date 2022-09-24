package Programmers.카카오2022공채_06;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(3, 4, 2, 3, 3, 1, 5);
    }
    
}
class Solution {
    static ArrayList<String> list = new ArrayList<>();
    static int startx, starty, endx, endy, height, width;
    static boolean[][] visit;
    static String[] slist = {"d","l","r","u"}, elist = {"u","r","l","d"};
    static String ans;
    static int[] dx = {1, 0, 0, -1}, dy = {0, -1, 1, 0};
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        startx =x-1; starty=y-1; endx=r-1; endy=c-1; height = n; width = m;
        bfs(k);
        return ans;
    }

    static void bfs(int k) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(startx, starty));
        visit = new boolean[height][width];
        visit[startx][starty] = true;

        while(!queue.isEmpty()) {
            Node x = queue.poll();

            if(x.x == endx && x.y == endy) {
                ans = x.sb.toString();
                if(ans.length() != k) {
                    if(k%2 != ans.length()%2) {
                        ans = "impossible";
                        return;
                    }else {
                        String tmpstr = "";
                        String start="", end="";
                        int repeat = 1;
                        for(int i=0; i<4; i++) {
                            int nx = x.x+dx[i], ny = x.y+dy[i];
                            if(nx < 0 || nx > height-1 || ny <0 || ny > width-1) continue;
                            start = slist[i]; end = elist[i];

                            if(i==0) { // 아래
                                repeat = height - nx;
                            }else if (i==1) {// 왼쪽
                                repeat = ny;
                            }else if(i==2) {
                                repeat = width - ny;
                            }else {
                                repeat = nx;
                            }
                            break;
                        }
                        int repeat2 = 1;
                        if(k/2 < repeat) {
                            repeat2 = k/2;
                        }
                        for(int i=0; i<repeat2; i++) {
                            tmpstr += start;
                        }
                        if(repeat < k/2) {
                            for(int i=0; i<(k-repeat*2)/2; i++) {
                                tmpstr += end;
                                tmpstr += start;
                            }
                        }
                        
                        for(int i=0; i<repeat2; i++) {
                            tmpstr += end;
                        }

                        String tmpstr2 = "";
                        String start2="", end2="";
                        repeat = 1;
                        for(int i=0; i<4; i++) {
                            int nx = startx+dx[i], ny = starty+dy[i];
                            if(nx < 0 || nx > height-1 || ny <0 || ny > width-1) continue;
                            start = slist[i]; end = elist[i];

                            if(i==0) { // 아래
                                repeat = height - nx;
                            }else if (i==1) {// 왼쪽
                                repeat = ny;
                            }else if(i==2) {
                                repeat = width - ny;
                            }else {
                                repeat = nx;
                            }
                            break;
                        }
                        
                        
                        for(int i=0; i<repeat; i++) {
                            tmpstr2 += start;
                        }

                        for(int i=0; i<(k-repeat*2)/2; i++) {
                            tmpstr2 += end;
                            tmpstr2 += start;
                        }

                        for(int i=0; i<repeat; i++) {
                            tmpstr2 += end;
                        }

                        ans += tmpstr;
                        String comp = tmpstr2;
                        comp += ans;

                        if(comp.compareTo(ans) < 0) {
                            ans = comp;
                        }



                        return;
                    }
                }
            }


            for(int i=0; i<4; i++) {
                int nx = x.x+dx[i], ny = x.y+dy[i];
                if(nx < 0 || nx > height-1 || ny <0 || ny > width-1) continue;
                if(visit[nx][ny]) continue;
                Node tmp = new Node(nx,ny);
                tmp.sb.append(x.sb.toString());
                tmp.sb.append(slist[i]);
                visit[nx][ny] = true;
                queue.add(tmp);
            }
        }
    }
}


class Node{
    int x, y;
    StringBuilder sb;
    Node(int x, int y) {
        this.x=x;
        this.y=y;
        sb = new StringBuilder();
    }
    
}