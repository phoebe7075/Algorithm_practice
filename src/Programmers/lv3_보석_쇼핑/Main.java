package Programmers.lv3_보석_쇼핑;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int ans[] = solution.solution(new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"});
        System.out.println(ans[0] + " " + ans[1]);
    }
}

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        int len = 100001;
        Map<String, Integer> map = new HashMap<>();
        int idx = 0;
        int[] list = new int[gems.length];
        for(int i=0; i<gems.length; i++) {
            String x = gems[i];
            if(map.getOrDefault(x, -1) == -1) {
                map.put(x,idx);
                list[i] = idx;
                idx++;
            }else {
                list[i] = map.get(x);
            }

        }
        int[] check = new int[map.size()];
        HashSet<Integer> set = new HashSet<>();
        int right = 0;
        for(int i=0; i<gems.length-map.size()+1; i++) {
            for(int j=right; j<gems.length; j++) {

                if(check[list[j]] == 0) {
                    check[list[j]] = 1;
                    set.add(list[j]);
                }else {
                    check[list[j]]++;
                }

                if(set.size() == map.size()) {
                    if(len > j-i) {
                        len = j-i;
                        answer[0] = i+1; answer[1] = j+1;
                    }
                    right = j;
                    break;
                }

            }
            if(gems.length-i+1 < len) {
                break;
            }

            if(check[list[i]] == 1) {
                set.remove(list[i]);
                check[list[i]] = 0;
            }else {
                check[list[i]]--;
            }

            if(check[list[right]] == 1) {
                set.remove(list[right]);
                check[list[right]] = 0;
            }else {
                check[list[right]]--;
            }
        }

        return answer;
    }
}