package Algorithms.Implementation;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * HackerRank Algorithms Implementation 
 * https://www.hackerrank.com/challenges/lisa-workbook/problem
 * @author Hasol
 */
public class WorkbookPage {
    // Complete the workbook function below.
    static int workbook(int n, int k, int[] arr) {
        int s = 1, c = 0;
        for (int i=0; i<arr.length; i++, s++)
            for (int j=1; j<=arr[i]; j++) {
                if (j == s)
                    c++;
                if (j < arr[i] && j%k == 0)
                    s++;
            }
        return c;
    }
    static final Scanner scanner = new Scanner(System.in);
    static BufferedWriter bufferedWriter;
    public static void main(String[] args) throws IOException {
        bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String[] nk = scanner.nextLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        int[] arr = new int[n];
        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int i=0; i<n; i++)
            arr[i] = Integer.parseInt(arrItems[i]);
        int result = workbook(n, k, arr);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }
}
