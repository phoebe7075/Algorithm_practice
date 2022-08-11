package HackerRank.Time_Conversion;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
        int hour, min, sec;
        String time = s.substring(s.length()-2);
        String[] tmp = s.substring(0,s.length()-2).split(":");
        hour = Integer.parseInt(tmp[0]);
        min = Integer.parseInt(tmp[1]);
        sec = Integer.parseInt(tmp[2]);
        
        if(time.equals("PM")) {
            if(hour != 12) hour += 12;
        }else {
            if(hour == 12) hour -= 12;
        }
        String ans = String.format("%02d",hour) + ":" + String.format("%02d",min) + ":" + String.format("%02d",sec);
        return ans;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
