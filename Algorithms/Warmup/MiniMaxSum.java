package Algorithms.Warmup;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * HackerRank Algorithms Warmup 8
 * https://www.hackerrank.com/challenges/mini-max-sum/problem
 * @author Hasol
 */
public class MiniMaxSum {
    // Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) {
        int x = Integer.MIN_VALUE, y = Integer.MAX_VALUE;
        long s = 0;
        for (int a: arr) {
            if (a > x)
                x = a;
            if (a < y)
                y = a;
            s += a;
        }
        System.out.println ((s-x) + " " + (s-y));
    }
    static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int n = 5;
        int[] arr = new int[n];
        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int i=0; i<n; i++)
            arr[i] = Integer.parseInt(arrItems[i]);
        miniMaxSum(arr);
        scanner.close();
    }
}
