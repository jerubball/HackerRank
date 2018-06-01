package Algorithms.Warmup;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * HackerRank Algorithms Warmup 6
 * https://www.hackerrank.com/challenges/plus-minus/problem
 * @author Hasol
 */
public class PlusMinus {
    // Complete the plusMinus function below.
    static void zeroPlusMinus(int[] arr) {
        double z = 0, p = 0, m = 0;
        for (int a: arr)
            if (a > 0)
                p++;
            else if (a < 0)
                m++;
            else
                z++;
        System.out.println (p / arr.length);
        System.out.println (m / arr.length);
        System.out.println (z / arr.length);
    }
    static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int[] arr = new int[n];
        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int i=0; i<n; i++)
            arr[i] = Integer.parseInt(arrItems[i]);
        zeroPlusMinus(arr);
        scanner.close();
    }
}
