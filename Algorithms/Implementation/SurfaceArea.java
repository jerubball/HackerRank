package Algorithms.Implementation;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * HackerRank Algorithms Implementation 60
 * https://www.hackerrank.com/challenges/3d-surface-area/problem
 * @author Hasol
 */
public class SurfaceArea {
    // Complete the surfaceArea function below.
    static int surfaceArea(int[][] a) {
        int t = 0, k = 0;
        t += 2*a.length*a[0].length;
        for (int i=0; i<a.length; i++, k=0) {
            for (int j=0; j<a[i].length; j++)
                t += Math.abs(k - (k = a[i][j]));
            t += k;
        }
        for (int j = 0; j < a[0].length; j++, k=0) {
            for (int i = 0; i < a.length; i++)
                t += Math.abs(k - (k = a[i][j]));
            t += k;
        }
        return t;
    }
    static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String[] hw = scanner.nextLine().split(" ");
        int h = Integer.parseInt(hw[0]);
        int w = Integer.parseInt(hw[1]);
        int[][] a = new int[h][w];
        for (int i=0; i<h; i++) {
            String[] aRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            for (int j=0; j<w; j++)
                a[i][j] = Integer.parseInt(aRowItems[j]);
        }
        int result = surfaceArea(a);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }
}
