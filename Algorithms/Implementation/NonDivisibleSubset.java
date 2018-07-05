package Algorithms.Implementation;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * HackerRank Algorithms Implementation 35
 * https://www.hackerrank.com/challenges/non-divisible-subset/problem
 * @author Hasol
 */
public class NonDivisibleSubset {
    // Complete the nonDivisibleSubset function below.
    static int nonDivisibleSubset(int k, int[] s) {
        int[] c = new int[k]; // array to count remainders
        for (int i: s)
            c[i%k]++;
        int a = Math.min(c[0], 1) + (k%2 == 0 ? Math.min(c[k/2], 1) : 0);
        for (int i=1; i<(k+1)/2; i++)
            a += Math.max(c[i], c[k-i]); // count only one of remainder set
        return a;
    }
    static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String[] nk = scanner.nextLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        int[] s = new int[n];
        String[] sItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int i=0; i<n; i++)
            s[i] = Integer.parseInt(sItems[i]);
        int result = nonDivisibleSubset(k, s);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }
}
