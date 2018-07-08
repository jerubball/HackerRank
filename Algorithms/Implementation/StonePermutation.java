package Algorithms.Implementation;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * HackerRank Algorithms Implementation 56
 * https://www.hackerrank.com/challenges/manasa-and-stones/problem
 * @author Hasol
 */
public class StonePermutation {
    // Complete the stones function below.
    static int[] stones(int n, int a, int b) {
        if (a == b)
            return new int[] {a*(n-1)};
        int t, d;
        int[] s = new int[n];
        if (a > b) {
            t = b;
            b = a;
            a = t;
        }
        d = b-a;
        t = a*n-b;
        for (int i=0; i<s.length; i++)
            s[i] = (t += d);
        return s;
    }
    static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int tItr=0; tItr<t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            int a = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            int b = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            int[] result = stones(n, a, b);
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
