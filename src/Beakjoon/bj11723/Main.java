package Beakjoon.bj11723;


import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int ans = 0;
        for(int i=0; i<n; i++) {
            String[] strings = br.readLine().split(" ");
            if(strings[0].equals("add")) {
                ans |= (1<<Integer.parseInt(strings[1]));
            }else if (strings[0].equals("remove")){
                ans &= ~(1<<Integer.parseInt(strings[1]));
            }else if(strings[0].equals("check")){
                if ((ans & (1<<Integer.parseInt(strings[1]))) != 0){
                    sb.append(1+"\n");
                }else {
                    sb.append(0+"\n");
                }
            }else if(strings[0].equals("toggle")){
                ans ^= (1<<Integer.parseInt(strings[1]));
            }else if (strings[0].equals("all")){
                ans = (1<<21) -1;
            }else if(strings[0].equals("empty")){
                ans = 0;
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
