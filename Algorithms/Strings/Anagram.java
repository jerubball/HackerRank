import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * HackerRank Algorithms Strings 18
 * https://www.hackerrank.com/challenges/anagram/problem
 * @author Hasol
 */
public class Anagram {
    static final int ALPHABET = 26;
    // Complete the anagram function below.
    static int anagram(String s) {
        if (s.length()%2 != 0)
            return -1;
        else {
            int size = s.length()/2;
            String a = s.substring(0,size), b = s.substring(size);
            int[] af = frequency(a), bf = frequency(b);
            int diff = 0;
            for (int i=0; i<ALPHABET; i++)
                diff += Math.abs(af[i] - bf[i]);
            return diff/2;
        }
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
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int qItr=0; qItr<q; qItr++) {
            String s = scanner.nextLine();
            int result = anagram(s);
            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
        scanner.close();
    }
}
