package Beakjoon.bj1644;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ans = 0;
        ArrayList<Integer> prime_num = new ArrayList<>();
        boolean[] prime = new boolean[N+1];
        prime[0] = prime[1] = true;

        for(int i=2; (i*i)<=N; i++) {
            if(!prime[i]) {
                for(int j=i*i; j <= N; j+=i) {
                    prime[j] = true;
                }
            }
        }

        for(int i=2; i<=N; i++) {
            if(!prime[i]) prime_num.add(i);
        }

        int total = 0;

        for(int i=0; i<prime_num.size(); i++) {
            for(int j=i; j<prime_num.size(); j++) {
                total += prime_num.get(j);
                if(total == N) {
                    ans++;
                    break;
                }else if(total > N) {
                    total = 0;
                    break;
                }
            }
        }

        System.out.println(ans);
    }
}
