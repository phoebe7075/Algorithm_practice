package HackerRank.1week_problemsolving.day4;

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

    public static int superDigit(String n, int k) {
        
        long sum=stosum(n)*k;
        String tmp = Long.toString(sum);
        while(tmp.length() > 1) {
            sum = stosum(tmp);
            tmp = Long.toString(sum);
        }
        
        return (int)sum;

    }
    
    public static long stosum(String s) {
        long sum = 0;
        for(char x : s.toCharArray()) {
            sum += (x-'0');
        }
        return sum;
    }

}

public class recursive_digit_sum {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        String n = firstMultipleInput[0];

        int k = Integer.parseInt(firstMultipleInput[1]);

        int result = Result.superDigit(n, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}