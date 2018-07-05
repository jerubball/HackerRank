package Algorithms.Implementation;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * HackerRank Algorithms Implementation 37
 * https://www.hackerrank.com/challenges/jumping-on-the-clouds/problem
 * @author Hasol
 */
public class CloudJump2 {
    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {
        int a = 0;
        for (int i=0; i<c.length-1; i++, a++)
            i = (i+2 < c.length && c[i+2] == 0) ? i+1 : i;
        return a;
    }
    static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int[] c = new int[n];
        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int i=0; i<n; i++)
            c[i] = Integer.parseInt(cItems[i]);
        int result = jumpingOnClouds(c);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }
}
