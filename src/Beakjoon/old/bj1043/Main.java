package Beakjoon.old.bj1043;

import java.io.*;
import java.util.*;

public class Main {
    static boolean[] people;
    static boolean[] party;
    static int N, M;
    static int ans = 0;
    static ArrayList<ArrayList<Integer>> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        people = new boolean[N];
        party = new boolean[M];
        list = new ArrayList<>(); // 각 사람에 대한 파티 리스트

        for(int i=0; i<N; i++) {
            list.add(new ArrayList<Integer>());
        }

        String s1 = br.readLine();
        if(s1.equals("0")) {
            ans = M;
            for(int i=0; i<M; i++) {
                br.readLine();
            }
            System.out.println(ans);
            return;
        }else {
            s = s1.split(" ");
            int trueman = Integer.parseInt(s[0]);
            for(int i=1; i<=trueman; i++) {
                people[Integer.parseInt(s[i])-1] = true;
            }
        }

        for(int i=1; i<=M; i++) {
            s = br.readLine().split(" ");
            int partyman = Integer.parseInt(s[0]);
            for(int j=1; j<=partyman; j++) {
                list.get(Integer.parseInt(s[j])-1).add(i-1);
            }
        }

        for(int i=0; i<N; i++) {
            if(people[i]) {
                for(int a : list.get(i)) {
                    party[a] = true;
                }
            }
        }

        while (isParadox()) {
            for(int i=0; i<N; i++) {
                for(int a : list.get(i)) {
                    if(party[a] && !people[i]) {
                        people[i] = true;
                    }
                }
            }

            for(int i=0; i<N; i++) {
                if(people[i]) {
                    for(int a : list.get(i)) {
                        party[a] = true;
                    }
                }
            }
        }


        for(int i=0; i< M; i++) {
            if(!party[i])
                ans++;
        }
        System.out.println(ans);
    }

    static boolean isParadox() {
        for(int i=0; i<N; i++) {
            for(int a : list.get(i)) {
                if(party[a] && !people[i]) {
                    return true;
                }
            }
        }
        return false;
    }
}
