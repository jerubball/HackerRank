package Algorithms.Strings;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * HackerRank Algorithms Strings 8
 * https://www.hackerrank.com/challenges/pangrams/problem
 * @author Hasol
 */
public class Pangram {
    // Complete the pangrams function below.
    static String pangrams(String s) {
        s = s.toLowerCase();
        boolean[] alphabet = new boolean[26];
        for (char c: s.toCharArray())
            if (Character.isLowerCase(c))
                alphabet[c-'a'] = true;
        for (boolean test: alphabet)
            if (!test)
                return "not pangram";
        return "pangram";
    }
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String s = scanner.nextLine();
        String result = pangrams(s);
        bufferedWriter.write(result);
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }
}
