package Programmers.Line2022_01;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new String[]{"morgan sort", "felix sort", "morgan sqrt", "morgan sqrt", "rohan reverse", "rohan reverse"});
    }
}
class Solution {
    public String[] solution(String[] logs) {
        HashSet<String> set = new HashSet<>(Arrays.asList(logs));
        logs = set.toArray(new String[0]);
        ArrayList<String> arr = new ArrayList();
        Map<String, Integer> user = new HashMap();
        Map<String, Integer> list = new TreeMap();

        for(String x : logs) {
            String[] tmp = x.split(" ");

            if(user.getOrDefault(tmp[0],0) == 0) {
                user.put(tmp[0],1);
            }

            if(list.getOrDefault(tmp[1],0) == 0) {
                list.put(tmp[1],1);
            }else {
                list.put(tmp[1],list.get(tmp[1])+1);
            }
        }

        for(String x : list.keySet()){
            if(list.get(x)*2 >= user.size()) {
                arr.add(x);
            }
        }
        String[] answer = arr.toArray(new String[0]);

        return answer;
    }
}