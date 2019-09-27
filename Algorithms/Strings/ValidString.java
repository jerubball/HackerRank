package Algorithms.Strings;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * HackerRank Algorithms Strings 23
 * https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem
 * @author Hasol
 */
public class ValidString {
    static final int ALPHABET = 26;
    // Complete the isValid function below.
    static String isValid(String s) {
        int[] f = frequency(s);
        int a=0, b=0, c=0, d=0;
        for (int i: f)
            if (i > 0) {
                if (a == 0) { // first unique frequency
                    a = i;
                    b++;
                } else if (a == i)
                    b++;
                else if (c == 0) { // second unique frequency
                    c = i;
                    d++;
                } else if (c == i)
                    d++;
                else // third unique frequency
                    return "NO";
            }
        if (c == 0) // only one unique frequency
            return "YES";
        if (b > 1 && d > 1) // both first and second unique frequency happens more than once.
            return "NO";
        if ((a == 1 && b == 1) || (c == 1 && d == 1)) // one of the unique frequency happens once is one
            return "YES";
        if (Math.abs(a - c) != 1) // difference of unique frequency is greater than one
            return "NO";
        return "YES";
    }
    static int[] frequency(String s) {
        int[] freq = new int[ALPHABET];
        for (char c: s.toCharArray())
            freq[c-'a']++;
        return freq;
    }
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String s = scanner.nextLine();
        String result = isValid(s);
        bufferedWriter.write(result);
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }
}
