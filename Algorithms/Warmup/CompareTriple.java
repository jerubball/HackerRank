package Algorithms.Warmup;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * HackerRank Algorithms Warmup 3
 * https://www.hackerrank.com/challenges/compare-the-triplets/problem
 * @author Hasol
 */
public class CompareTriple {
    // Complete the solve function below.
    static int[] solve(int[] a, int[] b) {
        int[] s = new int[] {0, 0};
        for (int i=0; i<triple; i++)
            if (a[i] > b[i])
                s[0]++;
            else if (a[i] < b[i])
                s[1]++;
        return s;
    }
    static final Scanner scanner = new Scanner(System.in);
    static final int triple = 3;
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int[] a = new int[triple];
        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int i=0; i<triple; i++)
            a[i] = Integer.parseInt(aItems[i]);
        int[] b = new int[triple];
        String[] bItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int i=0; i<triple; i++)
            b[i] = Integer.parseInt(bItems[i]);
        int[] result = solve(a, b);
        for (int i=0; i<result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));
            if (i != result.length-1)
                bufferedWriter.write(" ");
        }
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }
}
