package Algorithms.Implementation;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * HackerRank Algorithms Implementation 17
 * https://www.hackerrank.com/challenges/picking-numbers/problem
 * @author Hasol
 */
public class PickNumber {
    // Complete the pickingNumbers function below.
    static int pickingNumbers(int[] a) {
        Arrays.sort(a);
        int[] b = new int[a[a.length-1]+1];
        for (int x: a)
            b[x]++;
        int c = 0, d;
        for (int i=1; i<b.length; i++)
            c = (d = b[i] + b[i-1]) > c ? d : c;
        return c;
    }
    static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int[] a = new int[n];
        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int i=0; i<n; i++)
            a[i] = Integer.parseInt(aItems[i]);
        int result = pickingNumbers(a);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }
}
