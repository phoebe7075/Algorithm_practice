
import java.io.*;
import java.util.*;

public class palindrome_index {
    public static int palindromeIndex(String s) {
        int n = s.length();
        if(n < 2) return -1;
        if(isPal(s)) return -1;
        
        int l = 0, r = n-1;
        
        while(l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                String s1 = s.substring(l+1, r+1);
                String s2 = s.substring(l, r);
                
                if(isPal(s1)) return l;
                else if (isPal(s2)) return r;
                else return -1;
            }
            l++; r--;
        }
        return -1;
    
    }
    public static boolean isPal(String s) {
        int n = s.length();
        if(n%2 == 0) {
            if(isPal(s.substring(0,n/2), s.substring(n/2, n))) {
                return true;
            }
        }else {
            if(isPal(s.substring(0,n/2), s.substring((n/2)+1, n))) {
                return true;
            }
        }
        return false;
    }
    public static boolean isPal(String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        
        sb.append(s2);
        String tmp = sb.reverse().toString();
        
        return s1.equals(tmp);
    }
}


