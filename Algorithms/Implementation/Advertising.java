package Algorithms.Implementation;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * HackerRank Algorithms Implementation 24
 * https://www.hackerrank.com/challenges/strange-advertising/problem
 * @author Hasol
 */
public class Advertising {
    // Complete the viralAdvertising function below.
    static int viralAdvertising(int n) {
        int s = 5, t = 0;
        for (int i=0; i<n; i++) {
            s /= 2;
            t += s;
            s *= 3;
        }
        return t;
    }
    static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int result = viralAdvertising(n);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }
}
