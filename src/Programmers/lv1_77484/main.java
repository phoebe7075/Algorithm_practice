package Programmers.lv1_77484;

public class main {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        answer[0] = 7;
        answer[1] = 7;
        int[] tmp = new int[2];
        for (int i=0; i < 6; i++) {
            if (lottos[i] == 0) {
                tmp[0]++;
                continue;
            }
            for (int j = 0; j < 6; j++) {
                if (lottos[i] == win_nums[j]) {
                    tmp[0]++;
                    tmp[1]++;
                }
            }
        }

        if(tmp[1] >= 2) {
            answer[0] = answer[0] - tmp[0];
            answer[1] = answer[1] - tmp[1];
        } else if (tmp[1] < 2) {
            if (tmp[0] < 2) {
                answer[0] = 6;
            } else {
                answer[0] = answer[0] - tmp[0];
            }

            answer[1] = 6;
        }



        return answer;
    }
}
