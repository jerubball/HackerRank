package Algorithms.Implementation;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * HackerRank Algorithms Implementation 47
 * https://www.hackerrank.com/challenges/minimum-distances/problem
 * @author Hasol
 */
public class MinimumDistance {
    // Complete the minimumDistances function below.
    static int minimumDistances(int[] a) {
        IntPair[] b = new IntPair[a.length];
        for (int i=0; i<a.length; i++)
            b[i] = new IntPair(a[i], i);
        Arrays.sort(b);
        int c = Integer.MAX_VALUE, d;
        for (int i=1; i<b.length; i++)
            if (b[i-1].data == b[i].data)
                c = c < (d = Math.abs(b[i-1].index - b[i].index)) ? c : d;
        return c == Integer.MAX_VALUE ? -1 : c;
    }
    static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int[] a = new int[n];
        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int i=0; i<n; i++)
            a[i] = Integer.parseInt(aItems[i]);
        int result = minimumDistances(a);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }
}
class IntPair implements Comparable<IntPair> {
    int data, index;
    public IntPair(int d, int i) {
        this.data = d;
        this.index = i;
    }
    @Override
    public int compareTo(IntPair p) {
        return Integer.compare(this.data, p.data);
    }
}
