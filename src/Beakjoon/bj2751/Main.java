package Beakjoon.bj2751;

import java.io.*;

public class Main {

    static int[] count;
    public static void main(String[] args) throws IOException{
        String string;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int sidx = Integer.parseInt(bufferedReader.readLine());
        count = new int[2000001];
        for (int i =0; i < sidx; i++)
        {
            count[Integer.parseInt(bufferedReader.readLine()) + 1000000]++;
        }

        for (int i =0; i < 2000001; i++)
        {
            if(count[i] > 0) {
                bufferedWriter.write(Integer.toString(i-1000000));
                bufferedWriter.newLine();
            }
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}