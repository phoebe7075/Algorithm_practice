package Programmers.lv1_81301;

public class main {
    public int solution(String s) {
        int answer = 0;
        char tmp;
        int bucket = 0;
        String tarr = "";
        String[] number = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        while(!s.isEmpty()) {
            tmp = s.charAt(0);

            if (tmp - '0' >= 0 && tmp - '0' <= 9) {
                tarr += tmp;
                bucket++;
                s = s.substring(1,s.length());
            } else {
                for(int i=0; i < 10; i++) {
                    int a = 0;
                    for (int j = 0; j < 3; j++) {
                        tmp = s.charAt(j);
                        if(tmp == number[i].charAt(j))
                            a++;
                    }
                    if (a == 3) {
                        tmp = (char)(i+'0');
                        tarr += tmp;
                        s = s.substring(number[i].length(),s.length());
                        break;
                    }
                }
            }
        }
        answer = Integer.parseInt(tarr);
        return answer;

    }
}
