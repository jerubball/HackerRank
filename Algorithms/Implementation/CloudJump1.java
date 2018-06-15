package Algorithms.Implementation;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * HackerRank Algorithms Implementation 28
 * https://www.hackerrank.com/challenges/jumping-on-the-clouds-revisited/problem
 * @author Hasol
 */
public class CloudJump1 {
    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c, int k) {
        int i = 0, e = 100;
        do
            e -= c[i = (i+k) % c.length]*2 +1;
        while (i != 0);
        return e;
    }
    static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String[] nk = scanner.nextLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        int[] c = new int[n];
        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int i=0; i<n; i++)
            c[i] = Integer.parseInt(cItems[i]);
        int result = jumpingOnClouds(c, k);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }
}
