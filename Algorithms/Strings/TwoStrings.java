package Algorithms.Strings;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * HackerRank Algorithms Strings 21
 * https://www.hackerrank.com/challenges/two-strings/problem
 * @author Hasol
 */
public class TwoStrings {
    static final int ALPHABET = 26;
    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {
        int[] f1 = frequency(s1), f2 = frequency(s2);
        for (int i=0; i<ALPHABET; i++)
            if (f1[i] == 1 && f2[i] == 1)
                return "YES";
        return "NO";
    }
    static int[] frequency(String s) {
        int[] freq = new int[ALPHABET];
        for (char c: s.toCharArray())
            freq[c-'a'] = 1;
        return freq;
    }
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int qItr=0; qItr<q; qItr++) {
            String s1 = scanner.nextLine();
            String s2 = scanner.nextLine();
            String result = twoStrings(s1, s2);
            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
        scanner.close();
    }
}
