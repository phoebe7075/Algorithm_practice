package Programmers.카모2022_코테02_01;

public class Main {
    
}
class Solution {
    public int solution(int[][] infos, int m) {
        int answer = 0;
        int inf = 99999999;
        int len = infos.length;
        int car_time=0, walk_time=0;
        int bike_time[][] = new int[len][2];
        int bike_strik_walk[] = new int[len];
        int public_time[][] = new int[len][2];
        int public_strik_walk[] = new int[len];
        for(int i=0; i<infos.length; i++){
            int[] info = infos[i];
            car_time += info[0];
            walk_time += info[3];

            if(i == 0) {
                bike_time[0][0] = info[1];
                if(info[3] <= m) {
                    bike_time[0][1] = info[3];
                    bike_strik_walk[0] = info[3];
                }else {
                    bike_time[0][1] = inf;
                }
            }else {
                int tmp1 = bike_time[i-1][0] + info[1];
                int tmp2 = bike_time[i-1][1] + info[1];
                
                bike_time[i][0] = Math.min(tmp1, tmp2);
                if(info[3] <= m) {
                    tmp1 = bike_time[i-1][0] + info[3];
                    if(bike_strik_walk[i-1]+info[3] <= m) {
                        tmp2 = bike_time[i-1][1] + info[3];
                    }else {
                        tmp2 = inf;
                    }
                    if(tmp1 <= tmp2) {
                        bike_strik_walk[i] = info[3];
                        bike_time[i][1] = tmp1;
                    }else {
                        bike_strik_walk[i] = bike_strik_walk[i-1]+info[3];
                        bike_time[i][1] = tmp2;
                    }
                }else {
                    bike_time[i][1] = inf;
                }
            }

            
            if(i==0) {
                if(info[2] != -1) {
                    public_time[0][0] = info[2];
                }else {
                    public_time[0][0] = inf;
                }
                if(info[3] <= m) {
                    public_time[0][1] = info[3];
                    public_strik_walk[0] = info[3];
                }else {
                    public_time[0][1] = inf;
                }
            }else {
                if (info[2] != -1) {
                    int tmp1 = public_time[i-1][0] + info[2];
                    int tmp2 = public_time[i-1][1] + info[2];
                    public_time[i][0] = Math.min(tmp1, tmp2);
                }else {
                    public_time[i][0] = inf;
                }
                if(info[3] <= m) {
                    int tmp1 = public_time[i-1][0] + info[3];
                    int tmp2 = 0;
                    if(public_strik_walk[i-1]+info[3] <= m) {
                        tmp2 = public_time[i-1][1] + info[3];
                    }else {
                        tmp2 = inf;
                    }
                    if(tmp1 <= tmp2) {
                        public_strik_walk[i] = info[3];
                        public_time[i][1] = tmp1;
                    }else {
                        public_strik_walk[i] = public_strik_walk[i-1]+info[3];
                        public_time[i][1] = tmp2;
                    }
                }else {
                    public_time[i][1] = inf;
                }
            }
        }
        if(walk_time > m) {
            walk_time = inf;
        }
        answer = Math.min(Math.min(car_time, walk_time), Math.min(Math.min(bike_time[len-1][0],bike_time[len-1][1]),
        Math.min(public_time[len-1][0],public_time[len-1][1])));
        //System.out.println(car_time + " " + walk_time + " " + bike_time[len-1][0] + " " + bike_time[len-1][1] + " " + public_time[len-1][0] + " " + public_time[len-1][1]);

        return answer;
    }
}
/*
전 구간에서 자전거로 오고 지금 구간에서 도보로 걷는게 
전 구간에서 도보로 걷고 지금 구간에서 자전거로 오는것과 같다면 손해임.

한 경로를 올때마다 경우의 수가 존재함. 전 구간에서 오는게 불가능한 경우의 수가 존재할 수 있음.
불가능했다면 -1로 가능하다면 수가 있는것으로. 
2가지 경우의 수로 분산해서, 도보가 전에 불가능했다면 inf를 주고 해서 더 작은수를 픽하게끔
*/
