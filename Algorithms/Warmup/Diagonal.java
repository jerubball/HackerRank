package Algorithms.Warmup;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * HackerRank Algorithms Warmup 5
 * https://www.hackerrank.com/challenges/diagonal-difference/problem
 * @author Hasol
 */
public class Diagonal {
    // Complete the diagonalDifference function below.
    static int diagonalDifference(int[][] a) {
        int x = 0, y = 0;
        for (int i = 0; i < a.length; i++) {
            x += a[i][i];
            y += a[i][a[i].length -i -1];
        }
        return Math.abs(x - y);
    }
    static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int[][] a = new int[n][n];
        for (int i=0; i<n; i++) {
            String[] aRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            for (int j=0; j<n; j++)
                a[i][j] = Integer.parseInt(aRowItems[j]);
        }
        int result = diagonalDifference(a);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }
}
