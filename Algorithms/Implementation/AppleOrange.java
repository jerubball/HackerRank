package Algorithms.Implementation;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * HackerRank Algorithms Implementation 2
 * https://www.hackerrank.com/challenges/apple-and-orange/problem
 * @author Hasol
 */
public class AppleOrange {
    // Complete the countApplesAndOranges function below.
    static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
        int x = 0, y = 0;
        for (int i: apples)
            if (a+i >= s && a+i <= t)
                x++;
        for (int j: oranges)
            if (b+j >= s && b+j <= t)
                y++;
        System.out.println (x);
        System.out.println (y);
    }
    static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        String[] st = scanner.nextLine().split(" ");
        int s = Integer.parseInt(st[0]);
        int t = Integer.parseInt(st[1]);
        String[] ab = scanner.nextLine().split(" ");
        int a = Integer.parseInt(ab[0]);
        int b = Integer.parseInt(ab[1]);
        String[] mn = scanner.nextLine().split(" ");
        int m = Integer.parseInt(mn[0]);
        int n = Integer.parseInt(mn[1]);
        int[] apples = new int[m];
        String[] applesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int i=0; i<m; i++)
            apples[i] = Integer.parseInt(applesItems[i]);
        int[] oranges = new int[n];
        String[] orangesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int i=0; i<n; i++)
            oranges[i] = Integer.parseInt(orangesItems[i]);
        countApplesAndOranges(s, t, a, b, apples, oranges);
        scanner.close();
    }
}
