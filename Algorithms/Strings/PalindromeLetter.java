package Algorithms.Strings;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * HackerRank Algorithms Strings 15
 * https://www.hackerrank.com/challenges/the-love-letter-mystery/problem
 * @author Hasol
 */
public class PalindromeLetter {
    // Complete the theLoveLetterMystery function below.
    static int theLoveLetterMystery(String s) {
        int c = 0;
        for (int i=0; i<s.length()/2; i++)
            c += Math.abs((int)s.charAt(i) - (int)s.charAt(s.length()-i-1));
        return c;
    }
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int qItr=0; qItr<q; qItr++) {
            String s = scanner.nextLine();
            int result = theLoveLetterMystery(s);
            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
        scanner.close();
    }
}
