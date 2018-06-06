package Algorithms.Implementation;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * HackerRank Algorithms Implementation 5
 * https://www.hackerrank.com/challenges/breaking-best-and-worst-records/problem
 * @author Hasol
 */
public class ScoreRecord {
    // Complete the breakingRecords function below.
    static int[] breakingRecords(int[] score) {
        int[] c = new int[] {0, 0};
        int x = score[0], y = score[0];
        for (int a: score) {
            if (a > x) {
                x = a;
                c[0]++;
            }
            if (a < y) {
                y = a;
                c[1]++;
            }
        }
        return c;
    }
    static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int[] score = new int[n];
        String[] scoreItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int i=0; i<n; i++)
            score[i] = Integer.parseInt(scoreItems[i]);
        int[] result = breakingRecords(score);
        for (int i=0; i<result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));
            if (i != result.length - 1)
                bufferedWriter.write(" ");
        }
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }
}
