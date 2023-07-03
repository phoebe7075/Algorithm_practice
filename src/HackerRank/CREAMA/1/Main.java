package HackerRank.CREAMA.1;

public class Main {
    
}
// 대문자 스트링 s에 대해 aws라는 단어를 찾아서 제거하고 나머지를 붙여서 다시 aws를 제거하는 작업을 반복하여
// 남은 문자를 리턴한다. 남은 문자가 없다면 -1을 출력해야함.
// S의 범위가 100000이기 때문에 asw를 10만개의 단어에서 제거한다 쳐도 3만3천번을 해야함 300000에 대해 3만3천을 곱하면 
// 9,999,900,000. 100억번의 탐색을 해야할수도 있기 때문에 KMP를 사용해서 탐색회수를 줄였다.
// KMP는 시간복잡도가 O(n+m). 
class Result {


    public static String getFinalString(String s) {
        String ans = s;
        String pattern = "AWS";
        while(ans.length() > 0) {
            int idx = KMP(ans, pattern);
            
            if(idx == -1) {
                return ans;
            }else {
                String tmp = ans.substring(0, idx);
                tmp+=ans.substring(idx+3);
                ans = tmp;
            }
        }
        
        return "-1";

    }
    public static int[] makeTable(String pattern) {
        int n = pattern.length();
        int table[] = new int[n];
        
        int idx = 0;
        
        for(int i=1; i<n; i++) {
            while(idx >0 && pattern.charAt(i) != pattern.charAt(idx)) {
                idx = table[idx-1];
            }
            
            if(pattern.charAt(i) == pattern.charAt(idx)){
                idx++;
                table[i] = idx;
            }
        }
        return table;
    }
    
    public static int KMP(String s, String pattern) {
        int[] table = makeTable(pattern);
        
        int n1 = s.length();
        int n2 = pattern.length();
        int idx = 0;
        for(int i=0; i<n1; i++) {
            while(idx > 0 && s.charAt(i) != pattern.charAt(idx)) {
                idx = table[idx-1];
            }
            
            if(s.charAt(i) == pattern.charAt(idx)){
                if(idx == n2-1) {
                    return i-idx;
                }
                else {
                    idx++;
                }
            }
        }
        
        return -1;
    }
}