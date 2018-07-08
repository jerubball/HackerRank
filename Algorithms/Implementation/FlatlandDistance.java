import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
package Algorithms.Implementation;
/**
 * HackerRank Algorithms Implementation 53
 * https://www.hackerrank.com/challenges/flatland-space-stations/problem
 * @author Hasol
 */
public class FlatlandDistance {
    // Complete the flatlandSpaceStations function below.
    static int flatlandSpaceStations(int n, int[] c) {
        Arrays.sort(c);
        int m = Integer.MIN_VALUE, d;
        for (int i=1; i<c.length; i++)
            if ((d = c[i] - c[i-1]) > m)
                m = d;
        m /= 2;
        if (c[0] > m)
            m = c[0];
        if ((d = n - c[c.length-1] -1) > m)
            m = d;
        return m;
    }
    static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String[] nm = scanner.nextLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        int[] c = new int[m];
        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int i=0; i<m; i++)
            c[i] = Integer.parseInt(cItems[i]);
        int result = flatlandSpaceStations(n, c);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }
}
