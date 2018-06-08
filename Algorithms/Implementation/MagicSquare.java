package Algorithms.Implementation;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * HackerRank Algorithms Implementation 16
 * https://www.hackerrank.com/challenges/magic-square-forming/problem
 * @author Hasol
 */
public class MagicSquare {
    // Complete the formingMagicSquare function below.
    static int formingMagicSquare(int[][] s) {
        return matchAllSquares(s);
    }
    static int matchAllSquares(int[][] s) {
        int[] diff = new int[8];
        for (int k=0; k<known.length; k++)
            for (int i=0; i<known[k].length; i++)
                for (int j=0; j<known[k][i].length; j++)
                    diff[k] += Math.abs(known[k][i][j] - s[i][j]);
        int m = Integer.MAX_VALUE;
        for (int a: diff)
            m = a<m ? a : m;
        return m;
    }
    static final int[][][] known = {
        {{8, 1, 6},
         {3, 5, 7},
         {4, 9, 2}},
        {{6, 1, 8},
         {7, 5, 3},
         {2, 9, 4}},
        {{4, 9, 2},
         {3, 5, 7},
         {8, 1, 6}},
        {{2, 9, 4},
         {7, 5, 3},
         {6, 1, 8}},
        {{8, 3, 4},
         {1, 5, 9},
         {6, 7, 2}},
        {{4, 3, 8},
         {9, 5, 1},
         {2, 7, 6}},
        {{6, 7, 2},
         {1, 5, 9},
         {8, 3, 4}},
        {{2, 7, 6},
         {9, 5, 1},
         {4, 3, 8}}
    };
    static void constructTable(int[][] s) {
        int[] t = new int[10];
        for (int[] a: s)
            for (int b: a)
                t[b]++;
    }
    static void constructSum(int[][] s) {
        int[] sr = new int[s.length], sc = new int[s.length], sd = new int[2];
        for (int i=0; i<s.length; i++)
            for (int j=0; j<s[i].length; j++) {
                sr[i] += s[i][j];
                sc[j] += s[i][j];
                if (i == j)
                    sd[0] += s[i][j];
                else if (i == s.length -j -1)
                    sd[1] += s[i][j];
            }
    }
    static boolean checkDistinct(int[] t) {
        for (int u: t)
            if (u != 1)
                return false;
        return true;
    }
    static boolean checkSum(int[] r, int[] c, int[] d) {
        for (int i=1; i<r.length; i++)
            if (r[i] != r[i-1])
                return false;
        for (int j=1; j<c.length; j++)
            if (c[j] != c[j-1])
                return false;
        if (d[0] != d[1])
            return false;
        if (r[0] != c[0] || c[0] != d[0])
            return false;
        return true;
    }
    static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int[][] s = new int[3][3];
        for (int i=0; i<3; i++) {
            String[] sRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            for (int j=0; j<3; j++)
                s[i][j] = Integer.parseInt(sRowItems[j]);
        }
        int result = formingMagicSquare(s);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }
}
