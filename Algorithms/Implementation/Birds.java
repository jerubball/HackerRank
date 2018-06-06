package Algorithms.Implementation;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * HackerRank Algorithms Implementation 8
 * https://www.hackerrank.com/challenges/migratory-birds/problem
 * @author Hasol
 */
public class Birds {
    // Complete the migratoryBirds function below.
    static int migratoryBirds(int[] ar) {
        Arrays.sort(ar);
        int c = 0, d = 0, x = ar[0], y = ar[0];
        for (int a: ar)
            if (x != a) {
                x = a;
                c = 1;
            } else if (++c > d) {
                d = c;
                y = x;
            }
        return y;
    }
    static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int arCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int[] ar = new int[arCount];
        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int i=0; i<arCount; i++)
            ar[i] = Integer.parseInt(arItems[i]);
        int result = migratoryBirds(ar);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }
}
