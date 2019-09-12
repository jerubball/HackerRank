package Algorithms.Strings;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * HackerRank Algorithms Strings 13
 * https://www.hackerrank.com/challenges/reduced-string/problem
 * @author Hasol
 */
public class AlternateCharacter2 {
    // Complete the alternatingCharacters function below.
    static int alternatingCharacters(String s) {
        return s.length() - s.replaceAll("(\\w)\\1+", "\\1").length();
    }
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int qItr=0; qItr<q; qItr++) {
            String s = scanner.nextLine();
            int result = alternatingCharacters(s);
            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
        scanner.close();
    }
}
