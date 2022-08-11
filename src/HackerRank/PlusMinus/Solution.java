package HackerRank.PlusMinus;

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
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
    // Write your code here
        int plus=0, minus=0, zero = 0;
        for(Integer x : arr) {
            if(x < 0) {
                minus++;
            }else if (x > 0) {
                plus++;
            }else {
                zero++;
            }
        }
        double[] result = new double[3];
        result[0] = (double)plus/arr.size();
        result[1] = (double)minus/arr.size();
        result[2] = (double)zero/arr.size();
        for(int i=0; i<3; i++) {
            System.out.printf("%.6f",result[i]);
            System.out.println();
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.plusMinus(arr);

        bufferedReader.close();
    }
}