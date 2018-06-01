package Algorithms.Warmup;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * HackerRank Algorithms Warmup 4
 * https://www.hackerrank.com/challenges/a-very-big-sum/problem
 * @author Hasol
 */
public class BigSum {
    // Complete the aVeryBigSum function below.
    static long aVeryBigSum(long[] ar) {
        long s = 0;
        for (long a: ar)
            s += a;
        return s;
    }
    static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int arCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        long[] ar = new long[arCount];
        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int i=0; i<arCount; i++)
            ar[i] = Long.parseLong(arItems[i]);
        long result = aVeryBigSum(ar);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }
}
