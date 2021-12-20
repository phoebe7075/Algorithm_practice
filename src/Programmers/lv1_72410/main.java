package Programmers.lv1_72410;

public class main {
    public String solution(String new_id) {
        String answer = "";
        String temp = "";

        answer = new_id.toLowerCase();
        temp = "";

        for(int i =0; i < answer.length(); i++) {
            char a = answer.charAt(i);
            if ((a - 'A' >=0 && a - 'A' <= 25) || (a - 'a' >=0 && a - 'a' <= 25) || (a == '.') || (a - '0' >= 0 && a - '0' <= 9) || (a == '-') || (a == '_')) {
                temp += a;
            }
        }
        answer = temp;
        temp = "";

        for(int i=0; i < answer.length()-1; i++) {
            char a = answer.charAt(i);
            char b = answer.charAt(i+1);
            if (a == '.' && b == '.') {
                continue;
            }
            temp += a;
        }
        temp += answer.charAt(answer.length()-1);
        answer = temp;
        temp = "";

        if (answer.charAt(0) == '.')
        {
            temp = answer.substring(1,answer.length());
        } else {
            temp = answer;
        }
        answer = temp;
        temp = "";

        if (!answer.isEmpty()) {
            if(answer.charAt(answer.length()-1) == '.') {
                temp = answer.substring(0,answer.length()-1);
            } else {
                temp = answer;
            }
        }

        answer = temp;
        temp = "";

        if (answer.isEmpty() == true) {
            answer = "a";
        }

        if (answer.length() >= 16) {
            temp = answer.substring(0,15);

            if(temp.charAt(14) == '.') {
                answer = temp.substring(0,14);
            } else {
                answer = temp;
            }
        }
        temp = "";
        if (answer.length() <= 2) {
            char x = answer.charAt(answer.length()-1);
            while(answer.length() < 3) {
                answer += x;
            }
        }
        return answer;
    }
}
