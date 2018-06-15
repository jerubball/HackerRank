package Algorithms.Implementation;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * HackerRank Algorithms Implementation 29
 * https://www.hackerrank.com/challenges/find-digits/problem
 * @author Hasol
 */
public class DigitDivisor {
    // Complete the findDigits function below.
    static int findDigits(int n) {
        int c = 0, i = n;
        do
            c = (i%10 != 0 && n%(i%10) == 0) ? c+1 : c;
        while ((i/=10) > 0);
        return c;
    }
    static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int tItr=0; tItr<t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            int result = findDigits(n);
            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
        scanner.close();
    }
}
