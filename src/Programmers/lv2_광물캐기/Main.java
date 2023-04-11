package Programmers.lv2_광물캐기;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{0, 1, 1}, new String[]{"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"}));
    }
}
class Solution {
    static int n;
    static int res = Integer.MAX_VALUE;
    static String[] arr;
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        n = minerals.length;
        arr = minerals;
        if(picks[0] != 0) {
            backT(0, picks, 0, 0);
        }
        if (picks[1] != 0) {
            backT(0, picks, 1, 0);
        }
        if (picks[2] != 0) {
            backT(0, picks, 2, 0);
        }
    
        return res;
    }
    
    
    public void backT(int cur, int[] picks, int pick, int score) {
        if(cur == n || isEmptyPick(picks)) {
            res = Math.min(res, score);
            return;
        }
        
        int nextCur = Math.min(n-cur, 5);
        
        for(int i=cur; i<cur+nextCur; i++) {
            if(pick == 0) {
                score++;
            }else if(pick == 1) {
                if(arr[i].equals("diamond")) {
                    score += 5;
                }else {
                    score++;
                }
            }else if (pick == 2) {
                if(arr[i].equals("diamond")) {
                    score += 25;
                }else if(arr[i].equals("iron")) {
                    score += 5;
                }else {
                    score++;
                }
            }
        }
        
        int[] tmp = new int[3];
        for(int i=0; i<3; i++) {
            tmp[i] = picks[i];
        }
        tmp[pick]--;
        if(cur + nextCur != n) {
            if(tmp[0] != 0) {
                backT(cur+5, tmp, 0, score);
            }
            if (tmp[1] != 0) {
                backT(cur+5, tmp, 1, score);
            }
            if (tmp[2] != 0) {
                backT(cur+5, tmp, 2, score);
            }
            if(isEmptyPick(tmp)) {
                backT(cur+5, tmp, -1, score);
            }
        }else {
            backT(cur+nextCur, tmp, -1, score);
        }
        
    }
    
    public boolean isEmptyPick(int[] pick) {
        for(int i=0; i<3; i++) {
            if(pick[i] != 0) {
                return false;
            }
        }
        return true;
    }
}