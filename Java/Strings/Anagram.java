package Java.Strings;
import java.io.*;
import java.util.*;
/**
 * HackerRank Java Strings 5
 * https://www.hackerrank.com/challenges/java-anagrams/problem
 * @author Hasol
 */
public class Anagram {
    final static int letters = 26;
    static boolean isAnagram(String a, String b) {
        // Complete the function
        int[] x = freqList(a);
        int[] y = freqList(b);
        for (int i=0; i<letters; i++)
            if (x[i] != y[i])
                return false;
        return true;
    }
    static int[] freqList(String a) {
        int[] l = new int[letters];
        for (char c: a.toUpperCase().toCharArray())
            l[c-'A']++;
        return l;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        System.out.println(isAnagram(a, b) ? "Anagrams" : "Not Anagrams");
    }
}
