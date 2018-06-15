package Algorithms.Implementation;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * HackerRank Algorithms Implementation 31
 * https://www.hackerrank.com/challenges/append-and-delete/problem
 * @author Hasol
 */
public class StringAppendDelete {
    // Complete the appendAndDelete function below.
    static String appendAndDelete(String s, String t, int k) {
        int i = 0, j, n = s.length(), m = t.length();
        while (i<n && i<m && s.charAt(i) == t.charAt(i))
            i++;
        return (j = k +2*i -n -m) >= 0 && (j%2 == 0 || 2*i <= j) ? "Yes" : "No";
    }
    static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String s = scanner.nextLine();
        String t = scanner.nextLine();
        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        String result = appendAndDelete(s, t, k);
        bufferedWriter.write(result);
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }
}
