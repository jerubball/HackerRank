package Algorithms.Implementation;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * HackerRank Algorithms Implementation 65
 * https://www.hackerrank.com/challenges/almost-sorted/problem
 * @author Hasol
 */
public class OneStepSort {
    // Complete the almostSorted function below.
    static void almostSorted(int[] arr) {
        int[] s = arr.clone();
        Arrays.sort(s);
        ArrayList<Integer> l = new ArrayList<>();
        for (int i=0; i<arr.length; i++)
            if (arr[i] != s[i])
                l.add(i);
        int n = l.get(0), m = l.get(l.size()-1);
        if (l.size() == 2)
            System.out.println("yes\nswap " + (n+1) + " " + (m+1));
        else {
            boolean b = true;
            for (int i=n; b && i<=m; i++)
                if (arr[i] != s[m+n-i])
                    b = false;
            if (b)
                System.out.println("yes\nreverse " + (n+1) + " " + (m+1));
            else
                System.out.println("no");
        }
    }
    static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int[] arr = new int[n];
        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int i=0; i<n; i++)
            arr[i] = Integer.parseInt(arrItems[i]);
        almostSorted(arr);
        scanner.close();
    }
}
