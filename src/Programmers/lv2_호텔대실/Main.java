package Programmers.lv2_호텔대실;
import java.util.*;
import java.io.*;
public class Main {
    
}

class Solution {
    public int solution(String[][] book_time) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        
        Arrays.sort(book_time, new Comparator<String[]>(){
            @Override
            public int compare(String[] o1, String[] o2) {
                int in1 = timeConvert(o1[0]), in2 = timeConvert(o2[0]);
                return (in1 - in2);
            }
        });
        
        for(int i=0; i<book_time.length; i++) {
            int in = timeConvert(book_time[i][0]);
            int out = timeConvert(book_time[i][1])+10;
            
            if(q.isEmpty()) {
                q.add(out);
            } else {
                if(q.peek() <= in) {
                    q.poll();
                } 
                q.add(out);
            }
        }
        
        return q.size();
    }
    
    static int timeConvert(String time) {
        String[] s = time.split(":");
        return (Integer.parseInt(s[0])*60 + Integer.parseInt(s[1]));
    }
}

/*
방의 예약가능 시간을 표기하고 우선순위 큐에 집어넣음 그리고 가장 먼저 있는 방이 가장 일찍 예약이 가능한
방일텐데 그 시간을 peek해서 예약불가능이면 새 방을 만들고 우선순위큐에 집어넣는다.
그러기 위해선 먼저 book_time을 예약 시작시간 순서대로 정렬하고 차례대로 보면 됨.
*/