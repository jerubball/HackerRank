package Algorithms.Implementation;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * HackerRank Algorithms Implementation 19
 * https://www.hackerrank.com/challenges/the-hurdle-race/problem
 * @author Hasol
 */
public class HurdleRace {
    // Complete the hurdleRace function below.
    static int hurdleRace(int k, int[] height) {
        int c = Integer.MIN_VALUE;
        for (int a: height)
            c = a>c ? a : c;
        return k<c ? c-k : 0;
    }
    static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String[] nk = scanner.nextLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        int[] height = new int[n];
        String[] heightItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int i=0; i<n; i++)
            height[i] = Integer.parseInt(heightItems[i]);
        int result = hurdleRace(k, height);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }
}
