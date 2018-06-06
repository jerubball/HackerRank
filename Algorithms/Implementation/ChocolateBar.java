package Algorithms.Implementation;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * HackerRank Algorithms Implementation 6
 * https://www.hackerrank.com/challenges/the-birthday-bar/problem
 * @author Hasol
 */
public class ChocolateBar {
    // Complete the solve function below.
    static int solve(int n, int[] s, int d, int m) {
        if (m > n)
            return 0;
        int a = 0, c = 0;
        for (int i=0; i<m; i++)
            a += s[i];
        if (a == d)
            c = 1;
        for (int j=m; j<n; j++)
            if ((a += s[j] - s[j-m]) == d)
                c++;
        return c;
    }
    static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int[] s = new int[n];
        String[] sItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int i=0; i<n; i++)
            s[i] = Integer.parseInt(sItems[i]);
        String[] dm = scanner.nextLine().split(" ");
        int d = Integer.parseInt(dm[0]);
        int m = Integer.parseInt(dm[1]);
        int result = solve(n, s, d, m);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }
}
