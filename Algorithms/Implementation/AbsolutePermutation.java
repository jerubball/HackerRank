package Algorithms.Implementation;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * HackerRank Algorithms Implementation 61
 * https://www.hackerrank.com/challenges/absolute-permutation/problem
 * @author Hasol
 */
public class AbsolutePermutation {
    // Complete the absolutePermutation function below.
    static int[] absolutePermutation(int n, int k) {
        int[] a = new int[n];
        boolean[] b = new boolean[n+1];
        int c;
        for (int i=0; i<a.length; i++)
            if ((c = i-k+1) > 0 && (b[c] = !b[c]))
                a[i] = c;
            else if ((c = i+k+1) <= n && (b[c] = !b[c]))
                a[i] = c;
            else
                return new int[] {-1};
        return a;
    }
    static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int tItr=0; tItr<t; tItr++) {
            String[] nk = scanner.nextLine().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);
            int[] result = absolutePermutation(n, k);
            for (int i=0; i<result.length; i++) {
                bufferedWriter.write(String.valueOf(result[i]));
                if (i != result.length-1)
                    bufferedWriter.write(" ");
            }
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
        scanner.close();
    }
}
