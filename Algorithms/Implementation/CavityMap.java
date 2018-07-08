package Algorithms.Implementation;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * HackerRank Algorithms Implementation 55
 * https://www.hackerrank.com/challenges/cavity-map/problem
 * @author Hasol
 */
public class CavityMap {
    // Complete the cavityMap function below.
    static String[] cavityMap(String[] grid) {
        char[][] g = new char[grid.length][];
        for (int i=0; i<grid.length; i++)
            g[i] = grid[i].toCharArray();
        for (int i=1; i<g.length-1; i++)
            for (int j=1; j<g[i].length-1; j++)
                if (check(g, i, j))
                    g[i][j] = 'X';
        String[] s = new String[g.length];
        for (int i=0; i<g.length; i++)
            s[i] = new String(g[i]);
        return s;
    }
    static boolean check(char[][] g, int i, int j) {
        char c = g[i][j];
        return c > g[i-1][j] && c > g[i+1][j] && c > g[i][j-1] && c > g[i][j+1];
    }
    static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        String[] grid = new String[n];
        for (int i=0; i<n; i++)
            grid[i] = scanner.nextLine();
        String[] result = cavityMap(grid);
        for (int i=0; i<result.length; i++) {
            bufferedWriter.write(result[i]);
            if (i != result.length-1)
                bufferedWriter.write("\n");
        }
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }
}
