package Algorithms.Strings;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * HackerRank Algorithms Strings 20
 * https://www.hackerrank.com/challenges/game-of-thrones/problem
 * @author Hasol
 */
public class PalindromeAnagram {
    static final int ALPHABET = 26;
    // Complete the gameOfThrones function below.
    static String gameOfThrones(String s) {
        int[] f = frequency(s);
        boolean odd = false;
        for (int i: f)
            if (i%2 == 1)
                if (odd)
                    return "NO";
                else
                    odd = true;
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
        String result = gameOfThrones(s);
        bufferedWriter.write(result);
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }
}
