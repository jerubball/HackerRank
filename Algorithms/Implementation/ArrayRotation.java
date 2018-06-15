package Algorithms.Implementation;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * HackerRank Algorithms Implementation 26
 * https://www.hackerrank.com/challenges/circular-array-rotation/problem
 * @author Hasol
 */
public class ArrayRotation {
    // Complete the circularArrayRotation function below.
    static int[] circularArrayRotation(int[] a, int[] m, int k) {
        int[] r = new int[m.length];
        int l = k % a.length;
        for (int i=0; i<m.length; i++)
            r[i] = a[m[i]<l ? m[i]-l+a.length : m[i]-l];
        return r;
    }
    static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String[] nkq = scanner.nextLine().split(" ");
        int n = Integer.parseInt(nkq[0]);
        int k = Integer.parseInt(nkq[1]);
        int q = Integer.parseInt(nkq[2]);
        int[] a = new int[n];
        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int i=0; i<n; i++)
            a[i] = Integer.parseInt(aItems[i]);
        int[] m = new int[q];
        for (int i=0; i<q; i++) {
            int mItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            m[i] = mItem;
        }
        int[] result = circularArrayRotation(a, m, k);
        for (int i=0; i<result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));
            if (i != result.length-1)
                bufferedWriter.write("\n");
        }
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }
}
