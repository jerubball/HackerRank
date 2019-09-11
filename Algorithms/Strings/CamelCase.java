package Algorithms.Strings;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * HackerRank Algorithms Strings 2
 * https://www.hackerrank.com/challenges/camelcase/problem
 * @author Hasol
 */
public class CamelCase {
    // Complete the camelcase function below.
    static int camelcase(String s) {
        int count = 1;
        for (char c: s.toCharArray())
            if (c >= 'A' && c <= 'Z')
                count++;
        return count;
    }
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String s = scanner.nextLine();
        int result = camelcase(s);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }
}
