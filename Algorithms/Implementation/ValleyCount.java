package Algorithms.Implementation;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * HackerRank Algorithms Implementation 13
 * https://www.hackerrank.com/challenges/counting-valleys/problem
 * @author Hasol
 */
public class ValleyCount {
    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
        int l = 0, v = 0;
        for (char c: s.toCharArray())
            if (c != 'D')
                l++;
            else if (l-- == 0)
                v++;
        return v;
    }
    static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        String s = scanner.nextLine();
        int result = countingValleys(n, s);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }
}
