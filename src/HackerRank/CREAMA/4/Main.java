package HackerRank.CREAMA.4;

import java.util.*;


public class Main {
    
}
class Result {

    /*
     * Complete the 'longestChain' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING_ARRAY words as parameter.
     */
    static int[] arr;
    public static int longestChain(List<String> words) {
        Collections.sort(words, new Comparator<String>() {
            @Override
            public int compare(String x, String y) {
                return x.length() - y.length();
            }
        });
        
        arr = new int[words.size()];
        int ans = 1;
        
        for(int i=0; i<words.size()-1; i++) {
            if(arr[i] == 0) arr[i] = 1;
            for(int j=i+1; j<words.size(); j++) {
                if(words.get(j).length()-1 > words.get(i).length()) { 
                    break;
                }else if (words.get(j).length() == words.get(i).length()) {
                    continue;
                }
                
                if(isChain(words.get(i), words.get(j))) {
                    arr[j] = Math.max(arr[j], arr[i]+1);
                    ans = Math.max(arr[j], ans);
                }
            }
        }
        
        
        
        
        return ans;

    }
    public static boolean isChain(String s, String target) {
        for(int i=0; i<target.length(); i++) {
            String tmp = "";
            if(i == 0) {
                tmp = target.substring(1);
            }else if (i == target.length()-1) {
                tmp = target.substring(0, target.length()-1);
            }else {
                tmp = target.substring(0, i);
                tmp += target.substring(i+1);
            }
            
            if(tmp.equals(s)) {
                return true;
            }
        }
        
        return false;
    }
}