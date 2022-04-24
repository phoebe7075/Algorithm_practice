package Programmers.lv3_불량_사용자;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "abc1**"}));
    }
}
class Solution {
    static ArrayList<String> list = new ArrayList<>();
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        perm(user_id.length, banned_id.length, 0, new boolean[user_id.length], "");

        for(int i=0; i<list.size(); i++) {
            String x = list.get(i);
            boolean bid[] = new boolean[banned_id.length];
            for(char tmp : x.toCharArray()) {
                String name = user_id[tmp-'1'];
                boolean leastOne = false;
                for(int k=0; k<banned_id.length; k++) {
                    if(!bid[k]) {
                        String b = banned_id[k];
                        boolean correct = true;
                        if(name.length() == b.length()) {
                            for(int j=0; j<name.length(); j++) {
                                if(b.charAt(j) != '*') {
                                    if(b.charAt(j) != name.charAt(j)) {
                                        correct = false;
                                        break;
                                    }
                                }
                            }

                            if(correct) {
                                bid[k] = true;
                                leastOne = true;
                            }
                        }
                        if(leastOne) break;
                    }
                }
            }

            boolean check = true;

            for(boolean n : bid) {
                if(!n){
                    check = false;
                    break;
                }
            }

            if(!check) {
                list.remove(i);
                i--;
            }
        }

        for(int i=0; i<list.size()-1; i++) {
            int bit = 0;
            String x = list.get(i);

            for(char tmp : x.toCharArray()) {
                bit |= (1<<(tmp-'0'));
            }

            for(int j=i+1; j<list.size(); j++) {
                String y = list.get(j);
                int equal = 0;

                for(char tmp : y.toCharArray()) {
                    equal += (bit & (1<<(tmp-'0'))) == (1<<(tmp-'0')) ? 1 : 0;
                }

                if(equal == x.length()) {
                    list.remove(j);
                    j--;
                }
            }
        }



        answer = list.size();
        return answer;
    }

    public void perm(int len, int n, int r,boolean[] visit, String a) {
        if(n == r) {
            list.add(a);
        }

        for(int i=0; i<len; i++) {
            if(!visit[i]) {
                visit[i] = true;
                a += (i+1);
                perm(len, n, r+1, visit,  a);
                a = a.substring(0,r);
                visit[i] = false;
            }
        }
    }
}