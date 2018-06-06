package Algorithms.Implementation;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * HackerRank Algorithms Implementation 3
 * https://www.hackerrank.com/challenges/kangaroo/problem
 * @author Hasol
 */
public class Kangaroo {
    // Complete the kangaroo function below.
    static String kangaroo(int x1, int v1, int x2, int v2) {
        int x = x2 - x1, v = v1 - v2;
        return x == 0 ? "YES" : (v == 0 || Math.signum(x) != Math.signum(v) || x % v != 0 ? "NO" : "YES");
    }
    static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String[] x1v1x2v2 = scanner.nextLine().split(" ");
        int x1 = Integer.parseInt(x1v1x2v2[0]);
        int v1 = Integer.parseInt(x1v1x2v2[1]);
        int x2 = Integer.parseInt(x1v1x2v2[2]);
        int v2 = Integer.parseInt(x1v1x2v2[3]);
        String result = kangaroo(x1, v1, x2, v2);
        bufferedWriter.write(result);
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }
}
