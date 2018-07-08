package Algorithms.Implementation;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * HackerRank Algorithms Implementation 54
 * https://www.hackerrank.com/challenges/fair-rations/problem
 * @author Hasol
 */
public class DistributeRation {
    // Complete the fairRations function below.
    static String fairRations(int[] b) {
        int s = 0;
        for (int a: b)
            s += a;
        if (s%2 == 1)
            return "NO";
        int t = 0;
        for (int i=0; i<b.length-1; i++)
            if (b[i]%2 == 1) {
                b[i]++;
                b[i+1]++;
                t += 2;
            }
        return Integer.toString(t);
    }
    static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int[] b = new int[n];
        String[] bItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int i=0; i<n; i++)
            b[i] = Integer.parseInt(bItems[i]);
        String result = fairRations(b);
        bufferedWriter.write(result);
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }
}
