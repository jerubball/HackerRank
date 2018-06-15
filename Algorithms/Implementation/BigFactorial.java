package Algorithms.Implementation;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * HackerRank Algorithms Implementation 30
 * https://www.hackerrank.com/challenges/extra-long-factorials/problem
 * @author Hasol
 */
public class BigFactorial {
    // Complete the extraLongFactorials function below.
    static void extraLongFactorials(int n) {
        BigInteger a = BigInteger.ONE;
        for (int i=1; i<=n; i++)
            a = a.multiply(new BigInteger(Integer.toString(i)));
        System.out.println(a.toString());
    }
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        extraLongFactorials(n);
        scanner.close();
    }
}
