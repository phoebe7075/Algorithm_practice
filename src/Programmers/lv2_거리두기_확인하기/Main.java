package Programmers.lv2_거리두기_확인하기;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ans = solution.solution(new String[][]{{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
        {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}});

        for(int x : ans) {
            System.out.print(x + " ");
        }
    }
}
class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        for(int k=0; k<places.length; k++) {
            ArrayList<Node> plist = new ArrayList<>();

            for(int i=0; i<5; i++) {
                for(int j=0; j<5; j++) {
                    char x = places[k][i].charAt(j);

                    if(x == 'P') {
                        plist.add(new Node(i,j));
                    }
                }
            }

            answer[k] = distance(plist,places[k]);

        }
        return answer;
    }

    public int distance(ArrayList<Node> plist, String[] places) {
        for(int i=0; i<plist.size()-1; i++) {
            Node tmp = plist.get(i);
            for(int j=i+1; j<plist.size(); j++) {
                Node x = plist.get(j);
                if(Math.abs(tmp.x - x.x) + Math.abs(tmp.y - x.y) <= 2) {
                    if(tmp.x == x.x){
                        if(tmp.y+1 == x.y) {
                            return 0;
                        }else if(places[tmp.x].charAt(tmp.y+1) == 'O') {
                            return 0;
                        }
                    }else if (tmp.y == x.y) {
                        if(tmp.x+1 == x.x) {
                            return 0;
                        }else if(places[tmp.x+1].charAt(tmp.y) == 'O') {
                            return 0;
                        }
                    }else if (tmp.x < 4) {
                        if(places[tmp.x+1].charAt(tmp.y) != 'O') {
                            if(tmp.y - x.y < 0) {
                                if(places[tmp.x].charAt(tmp.y+1) == 'O')
                                    return 0;
                            }else if (tmp.y > 0) {
                                if(places[tmp.x].charAt(tmp.y-1) == 'O') {
                                    return 0;
                                }
                            }
                        }else {
                            return 0;
                        }
                    }
                }
            }
        }

        return 1;
    }
}

class Node {
    int x, y;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}