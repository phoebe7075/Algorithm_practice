package Beakjoon.tmp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String s[] = {"1","2","4","3","3","4","1","5"};
        String p[] = {"read 1 3 1 2","read 2 6 4 7","write 4 3 3 5 2","read 5 2 2 5","write 6 1 3 3 9", "read 9 1 0 7"};
        String[] ans = solution(s,p);
        for(int i=0; i<ans.length; i++) {
            System.out.println(ans[i]);
        }
    }
    static int time, endtime = 1, count=0, realTime = 1;
    static Process state;
    static public String[] solution(String[] arr, String[] processes) {
        String[] answer;
        time = 1;
        Queue<Process> rq = new LinkedList<>();
        Queue<Process> wq = new LinkedList<>();
        ArrayList<String> result = new ArrayList<>();
        for(int i=0; i<processes.length; i++) {
            String s[] = processes[i].split(" ");
            if(s[0].equals("read")) {
                rq.offer(new Process(false, Integer.parseInt(s[2]), Integer.parseInt(s[1]), Integer.parseInt(s[3]), Integer.parseInt(s[4])));
            }else {
                wq.offer(new Process(true, Integer.parseInt(s[2]), Integer.parseInt(s[1]), Integer.parseInt(s[3]), Integer.parseInt(s[4]), s[5]));
            }
        }

        if(rq.peek().startTime < wq.peek().startTime) {
            state = rq.peek();
        }else {
            state = wq.poll();
            for(int i=state.start; i<= state.end; i++) {
                arr[i] = state.write;
            }
        }
        endtime = state.startTime + state.time;
        while(rq.size() > 0 || wq.size() > 0) {


            if(state.state == false) { // 읽기 상태
                Process pro;
                if(wq.size() > 0) {
                    if(wq.peek().startTime <= time) {
                        pro = wq.peek();

                        if(time >= endtime && time >= pro.startTime) { // 진행중인 작업이 끝났다면
                            endtime = time + pro.time;
                            realTime += time-state.startTime;
                            for(int i=pro.start; i<= pro.end; i++) {
                                arr[i] = pro.write;
                            }
                            state = pro;
                            state.startTime = time;
                            wq.poll();
                        }
                    }else {
                        if(rq.peek().startTime <= time) {
                            pro = rq.poll();

                            if(endtime < time+pro.time) {
                                endtime = time+pro.time;
                                realTime += time-state.startTime;
                                state = pro;
                                state.startTime = time;
                            }
                            String tmp = "";
                            for(int i=pro.start; i<= pro.end; i++) {
                                tmp += arr[i];
                            }
                            result.add(tmp);
                        }
                    }
                }else {
                    if(rq.peek().startTime <= time) {
                        pro = rq.poll();

                        if(endtime < time+pro.time) {
                            endtime = time+pro.time;
                            realTime += time-state.startTime;
                            state = pro;
                            state.startTime = time;
                        }
                        String tmp = "";
                        for(int i=pro.start; i<= pro.end; i++) {
                            tmp += arr[i];
                        }
                        result.add(tmp);
                    }
                }
            }else {
                Process pro;
                if(wq.size() > 0) {
                    if (wq.peek().startTime <= time) {
                        pro = wq.peek();

                        if (time >= endtime) { // 진행중인 작업이 끝났다면

                            endtime = time + pro.time;
                            realTime += time-state.startTime;
                            for (int i = pro.start; i <= pro.end; i++) {
                                arr[i] = pro.write;
                            }
                            state = pro;
                            state.startTime = time;
                            wq.poll();
                        }
                    }else {
                        if(time >= endtime) {
                            while (!rq.isEmpty()) {
                                pro = rq.peek();

                                if(pro.startTime <= time) {
                                    pro = rq.poll();

                                    if(endtime < time+pro.time) {
                                        endtime = time+pro.time;
                                        realTime += time-state.startTime;
                                        state = pro;
                                        state.startTime = time;
                                    }
                                    String tmp = "";
                                    for(int i=pro.start; i<= pro.end; i++) {
                                        tmp += arr[i];
                                    }
                                    result.add(tmp);
                                }else {
                                    break;
                                }
                            }
                        }

                    }
                }else {
                    while (!rq.isEmpty()) {
                        pro = rq.peek();

                        if(pro.startTime <= time) {
                            pro = rq.poll();

                            if(endtime < time+pro.time) {
                                endtime = time+pro.time;
                                realTime += time-state.startTime;
                                state = pro;
                                state.startTime = time;
                            }
                            String tmp = "";
                            for(int i=pro.start; i<= pro.end; i++) {
                                tmp += arr[i];
                            }
                            result.add(tmp);
                        }else {
                            break;
                        }
                    }
                }
            }
            time++;
        }

        answer = new String[result.size()+1];
        for(int i=0; i<result.size(); i++) {
            answer[i] = result.get(i);
        }
        answer[result.size()] = Integer.toString(realTime);

        return answer;
    }
}

class Process{
    boolean state; // true:쓰기 false:읽기
    int time, startTime; // 소요 시간
    int start, end;
    String write;

    Process(boolean state, int time,int startTime, int start, int end) {
        this.state = state;
        this.time = time;
        this.startTime = startTime;
        this.start = start;
        this.end = end;
    }

    Process(boolean state, int time,int startTime, int start, int end, String write) {
        this.state = state;
        this.time = time;
        this.startTime = startTime;
        this.start = start;
        this.end = end;
        this.write = write;
    }
}


