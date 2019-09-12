package Algorithms.Strings;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * HackerRank Algorithms Strings 14
 * https://www.hackerrank.com/challenges/beautiful-binary-string/problem
 * @author Hasol
 */
public class BeautifulBinary {
    // Complete the beautifulBinaryString function below.
    static int beautifulBinaryString(String b) {
        String s = b, prev;
        int count = -1;
        do {
            prev = s;
            s = s.replaceFirst("010", " ");
            count++;
        } while (s.length() != prev.length());
        return count;
    }
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        String b = scanner.nextLine();
        int result = beautifulBinaryString(b);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }
}
