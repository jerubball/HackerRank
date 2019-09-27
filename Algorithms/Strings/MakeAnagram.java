package Algorithms.Strings;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * HackerRank Algorithms Strings 19
 * https://www.hackerrank.com/challenges/making-anagrams/problem
 * @author Hasol
 */
public class MakeAnagram {
    static final int ALPHABET = 26;
    // Complete the makingAnagrams function below.
    static int makingAnagrams(String s1, String s2) {
        int[] f1 = frequency(s1), f2 = frequency(s2);
        int diff = 0;
        for (int i=0; i<ALPHABET; i++)
            diff += Math.abs(f1[i] - f2[i]);
        return diff;
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
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        int result = makingAnagrams(s1, s2);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }
}
