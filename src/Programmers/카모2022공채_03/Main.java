package Programmers.카모2022공채_03;

/*
입력값 〉
"2021:04:12:16:08:35", ["01:06:30:00", "01:04:12:00"]
기댓값 〉
[0, 4]

입력값 〉
"2021:04:12:16:08:35", ["01:06:30:00", "00:01:12:00"]
기댓값 〉
[1, 2]

입력값 〉
"2021:04:12:16:10:42", ["01:06:30:00"]
기댓값 〉
[1, 2]

입력값 〉
"2021:04:12:16:08:35", ["01:06:30:00", "01:01:12:00", "00:00:09:25"]
기댓값 〉
[1, 4]


추가 테케

입력값 〉
"2021:04:12:16:08:35", ["99:00:00:00"]
기댓값 〉
[0, 100]

입력값 〉
"2021:12:29:16:59:59", ["01:07:00:00", "00:00:00:01"]
기댓값 〉
[1, 3]

입력값 〉
"2021:04:12:16:08:35", ["48:00:00:00","01:00:00:00"]
기댓값 〉
[0, 50]



 */


class Solution {
    public int[] solution(String s, String[] times) {
        int[] start = new int[6];
        int[] now = new int[6];
        boolean isEveryday = true;
        String[] tmp = s.split(":");

        for(int i=0; i<6; i++){
            start[i] = Integer.parseInt(tmp[i]);
            now[i] = start[i];
        }

        for(String x : times) {
            tmp = x.split(":");

            int next[] = new int[6];

            for(int i=5; i>=4; i--) {
                next[i] += now[i]+Integer.parseInt(tmp[i-2]);
                if(next[i] > 59) {
                    next[i] = next[i]-60;
                    next[i-1]++;
                }
            }
            next[3] += now[3] + Integer.parseInt(tmp[1]);
            if(next[3] > 23) {
                next[3] = next[3]-24;
                next[2]++;
            }
            next[2] += now[2] + Integer.parseInt(tmp[0]);

            if(next[2] > 30) {
                int month = (next[2]-1)/30;
                int day = next[2]-(30*month);
                next[2] = day;
                next[1] += month;
            }
            next[1] += now[1];
            if(next[1] > 12) {
                next[1] = next[1]-12;
                next[0]++;
            }
            next[0] += now[0];


            if(isEveryday) {
                int day = calcDate(new int[]{now[0], now[1], now[2]}, new int[]{next[0], next[1], next[2]});
                if(day > 1) {
                    isEveryday = false;
                }
            }

            for(int i=0; i<6; i++) {
                now[i] = next[i];
            }
        }

        int day = calcDate(new int[]{start[0], start[1], start[2]}, new int[]{now[0], now[1], now[2]});
        int success = isEveryday ? 1 : 0;



        int[] answer = new int[]{success, day+1};
        return answer;
    }

    static int calcDate(int[] a, int[] b) {
        int day = 0;

        day += (b[2] - a[2]);
        day += (b[1] - a[1])*30;
        day += (b[0] - a[0])*360;

        return day;
    }
}
