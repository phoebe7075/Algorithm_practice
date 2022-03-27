package Programmers.LineCT_02;

public class Main {
    public static void main(String[] args) {
        String s[] = {"line in line", "LINE", "in lion"};
        //String p[] = {"read 1 3 1 2","read 2 6 4 7","write 4 3 3 5 2","read 5 2 2 5","write 6 1 3 3 9", "read 9 1 0 7"};
        int ans = solution(s,5);
        System.out.println(ans);
    }
    static int[] nowkey;
    static boolean[][] keys;
    static int maxScore = 0;
    static int[] score;
    static int maxkeys = 0;
    static public int solution(String[] sentences, int n) {
        int answer = 0;
        score = new int[sentences.length];
        keys = new boolean[sentences.length][27];
        int keynum = 0;
        boolean[] totalkey = new boolean[27];
        maxkeys = n;
        int idx = 0;
        for(String x : sentences) {
            if(x.matches("^[a-z\\s]*$")) {
                score[idx] = x.length();
            }else{
                for(int i=0; i<x.length(); i++) {
                    if(x.charAt(i)-'A' >= 0 && x.charAt(i)-'A' < 26) {
                        score[idx]++;
                    }
                }
                keynum++;
                keys[idx][26] = true;
                totalkey[26] = true;
                score[idx] += x.length();
            }


            for(int i=0; i<x.length(); i++) {
                if(x.charAt(i) == ' ') {
                    continue;
                }
                int tmp = x.charAt(i)-'a';

                if(tmp < 0 || tmp > 25) {
                    tmp = x.charAt(i)-'A';
                }

                if(!keys[idx][tmp]){
                    keys[idx][tmp] = true;
                }
                if(!totalkey[tmp]) {
                    totalkey[tmp] = true;
                    keynum++;
                }
            }

            idx++;
        }

        int[] arr = new int[keynum];
        boolean[] visited = new boolean[keynum];
        int tmpidx = 0;
        for(int i=0; i<27; i++) {
            if(totalkey[i]) {
                arr[tmpidx++] = i;
            }
        }
        comb(arr, visited, 0, keynum, n);

        return answer;
    }

    static public void comb(int[] arr, boolean[] visit, int start, int n,  int r) {
        if(r==0) {
            nowkey = new int[maxkeys];
            int idx=0;
            for(int i=0; i<n; i++) {
                if(visit[i]) nowkey[idx++]=arr[i];
            }

            boolean[] key = new boolean[27];

            for(int i=0; i<nowkey.length; i++) {
                key[nowkey[i]] = true;
            }

            maxScore = Math.max(isComplete(keys, key),maxScore);
            return;
        }

        for(int i=start; i<n; i++) {
            visit[i] = true;
            comb(arr, visit, i+1, n, r-1);
            visit[i] = false;
        }
    }
    static public int isComplete(boolean[][] arr, boolean[] key) {
        int total = 0;
        boolean flag = false;
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<key.length; j++) {
                if(arr[i][j]) {
                    if(!key[j]) {
                        flag = true;
                        break;
                    }
                }
            }
            if(!flag) total += score[i];
            flag = false;
        }

        return total;
    }
}
