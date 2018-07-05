package Algorithms.Implementation;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * HackerRank Algorithms Implementation 38
 * https://www.hackerrank.com/challenges/equality-in-a-array/problem
 * @author Hasol
 */
public class EqualizeArray {
    // Complete the equalizeArray function below.
    static int equalizeArray(int[] arr) {
        int[] a = new int[number];
        for (int b: arr)
            a[b]++;
        int c = 0;
        for (int b: a)
            c = b>c ? b : c;
        return arr.length-c;
    }
    static final int number = 101;
    static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int[] arr = new int[n];
        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int i=0; i<n; i++)
            arr[i] = Integer.parseInt(arrItems[i]);
        int result = equalizeArray(arr);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }
}
