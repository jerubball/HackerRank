package Algorithms.Implementation;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * HackerRank Algorithms Implementation 36
 * https://www.hackerrank.com/challenges/repeated-string/problem
 * @author Hasol
 */
public class RepeatedString {
    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        int a = countOccurrences(s, letter), r = (int)(n%s.length());
        long c = n/s.length();
        return c*a + countOccurrences(s.substring(0, r), letter);
    }
    static int countOccurrences(String s, char c) {
        int a = 0;
        for (char b: s.toCharArray())
            a = b == c ? a+1 : a;
        return a;
    }
    static final char letter = 'a';
    static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String s = scanner.nextLine();
        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        long result = repeatedString(s, n);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }
}
