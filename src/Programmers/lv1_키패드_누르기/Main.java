package Programmers.lv1_키패드_누르기;
import java.util.*;

public class Main {
}
class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int left = 0, right = 1;
        boolean h = hand.equals("right");
        ArrayList<Node> list = new ArrayList<>();
        list.add(new Node(3,0));
        list.add(new Node(3,2));
        list.add(new Node(3,1));
        for(int i = 0; i< 3; i++) {
            for(int j=0; j<3; j++) {
                list.add(new Node(i,j));
            }
        }

        for(int x : numbers) {
            if(x == 1 || x == 4 || x == 7) {
                left = x+2;
                answer += "L";
            }else if (x == 3 || x == 6 || x == 9) {
                right = x+2;
                answer += "R";
            }else {
                Node tmp = list.get(x+2);
                int leftlen = Math.abs(tmp.x-list.get(left).x) + Math.abs(tmp.y-list.get(left).y);
                int rightlen = Math.abs(tmp.x-list.get(right).x) + Math.abs(tmp.y-list.get(right).y);

                if(leftlen > rightlen) {
                    right = x+2;
                    answer += "R";
                }else if (leftlen < rightlen) {
                    left = x+2;
                    answer += "L";
                }else {
                    if(h) {
                        right = x+2;
                        answer += "R";
                    }else {
                        left = x+2;
                        answer += "L";
                    }
                }
            }
        }
        return answer;
    }

    class Node {
        int x, y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}