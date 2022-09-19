package Beakjoon.bj1744_수묶기_그리디;
import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<Integer> pluslist = new ArrayList<>();
    static ArrayList<Integer> minuslist = new ArrayList<>();
    static int zerocount = 0;
    static int n;
    public static void main(String[] args) throws NumberFormatException, IOException {
        n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++) {
            int tmp = Integer.parseInt(br.readLine());
            if(tmp > 0) {
                pluslist.add(tmp);
            }else if (tmp < 0) {
                minuslist.add(tmp);
            }else {
                zerocount++;
            }
        }
        
        int ans = 0;
        if(pluslist.size() != 0) {
            Collections.sort(pluslist, Collections.reverseOrder());
            for(int i=0; i<pluslist.size(); i++) {
                if(i+1 != pluslist.size()) {
                    if(pluslist.get(i)*pluslist.get(i+1) > pluslist.get(i)+pluslist.get(i+1)) {
                        ans += pluslist.get(i)*pluslist.get(i+1);
                        i++;
                    }else {
                        ans += pluslist.get(i)+pluslist.get(i+1);
                        i++;
                    }
                }else {
                    ans += pluslist.get(i);
                }
            }
        }
        
        if(minuslist.size() != 0) {
            Collections.sort(minuslist);
            for(int i=0; i<minuslist.size(); i++) {
                if(i+1 != minuslist.size()) {
                    ans += minuslist.get(i)*minuslist.get(i+1);
                    i++;
                }else {
                    if(zerocount == 0) {
                        ans += minuslist.get(i);
                    }
                }
            }
        }

        System.out.println(ans);
    }
    
}
