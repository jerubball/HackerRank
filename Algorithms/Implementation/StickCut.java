package Algorithms.Implementation;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * HackerRank Algorithms Implementation 34
 * https://www.hackerrank.com/challenges/cut-the-sticks/problem
 * @author Hasol
 */
public class StickCut {
    // Complete the cutTheSticks function below.
    static int[] cutTheSticks(int[] arr) {
        Arrays.sort(arr);
        int c = 0;
        int[] b = new int[arr.length];
        b[c++] = arr.length;
        for (int i=1; i<arr.length; i++)
            if (arr[i-1] < arr[i])
                b[c++] = arr.length - i;
        int[] a = new int[c];
        System.arraycopy(b, 0, a, 0, c);
        return a;
    }
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
        int[] result = cutTheSticks(arr);
        for (int i=0; i<result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));
            if (i != result.length-1)
                bufferedWriter.write("\n");
        }
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }
}
