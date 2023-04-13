package Programmers.lv2_혼자놀기의달인;
import java.util.*;
public class Main {
    
}

class Solution {
    static ArrayList<Integer> arr = new ArrayList<>();
    static boolean[] visit;
    public int solution(int[] cards) {
        int answer = 0;
        visit = new boolean[cards.length];
        for(int i=0; i<cards.length; i++) {
            if(!visit[i]) {
                arr.add(dfs(cards[i]-1, cards, 0));
            }
        }
        
        Collections.sort(arr, Collections.reverseOrder());
        if(arr.size() == 1) {
            return 0;
        }else {
            return arr.get(0)*arr.get(1);
        }
    }
    
    static int dfs(int x, int[] c, int score) {
        if(visit[x]){
            return score;
        }
        
        visit[x] = true;
        return dfs(c[x]-1, c, score+1);
    }
}