package Beakjoon.old.bj14429;

import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int ans = 0, ansc = 10001;
        for(int a=1; a<=n; a++) {
            String[] s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);

            int y = (x-1) % (m+1);

            int count=0;
            count += (x-y) / (m+1) +1;
            count *= 2;

            if(ansc > count) {
                ansc = count;
                ans = a;
            }
        }

        System.out.println(ans + " " + ansc);
    }
}
