package Algorithms.Strings;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * HackerRank Algorithms Strings 7
 * https://www.hackerrank.com/challenges/hackerrank-in-a-string/problem
 * @author Hasol
 */
public class ContainsText {
    // Complete the hackerrankInString function below.
    static String hackerrankInString(String s) {
        final String TEXT = "hackerrank";
        int k=0;
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == TEXT.charAt(k))
                k++;
            if (k == TEXT.length())
                return "YES";
        }
        return "NO";
    }
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();
            String result = hackerrankInString(s);
            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
        scanner.close();
    }
}
