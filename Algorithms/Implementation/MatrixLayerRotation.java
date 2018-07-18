package Algorithms.Implementation;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * HackerRank Algorithms Implementation 66
 * https://www.hackerrank.com/challenges/matrix-rotation-algo/problem
 * @author Hasol
 */
public class MatrixLayerRotation {
    // Complete the matrixRotation function below.
    static void matrixRotation(int[][] matrix, int r) {
        int m = matrix.length, n = matrix[0].length, l = Math.min(m, n)/2;
        int[][] s = new int[l][];
        for (int i=0; i<l; i++) {
            int a = m-2*(i+1), b = n-2*i, k = 0;
            // translate to layers
            s[i] = new int[2*(a+b)];
            for (int j=0; j<b; j++)
                s[i][k++] = matrix[i][i+j];
            for (int j=0; j<a; j++)
                s[i][k++] = matrix[i+j+1][n-i-1];
            for (int j=0; j<b; j++)
                s[i][k++] = matrix[m-i-1][n-i-j-1];
            for (int j=0; j<a; j++)
                s[i][k++] = matrix[m-i-j-2][i];
            assert k == s[i].length;
            // shift to left
            int c = r%s[i].length, d = s[i].length-c;
            int[] t = new int[c];
            System.arraycopy(s[i], 0, t, 0, c);
            System.arraycopy(s[i], t.length, s[i], 0, d);
            System.arraycopy(t, 0, s[i], d, c);
            // translate to matrix
            k = 0;
            for (int j=0; j<b; j++)
                matrix[i][i+j] = s[i][k++];
            for (int j=0; j<a; j++)
                matrix[i+j+1][n-i-1] = s[i][k++];
            for (int j=0; j<b; j++)
                matrix[m-i-1][n-i-j-1] = s[i][k++];
            for (int j=0; j<a; j++)
                matrix[m-i-j-2][i] = s[i][k++];
            assert k == s[i].length;
        }
        // print
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                System.out.print(matrix[i][j]);
                if (j != n-1)
                    System.out.print(" ");
            }
            if (i != m-1)
                System.out.println();
        }
    }
    static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        String[] mnr = scanner.nextLine().split(" ");
        int m = Integer.parseInt(mnr[0]);
        int n = Integer.parseInt(mnr[1]);
        int r = Integer.parseInt(mnr[2]);
        int[][] matrix = new int[m][n];
        for (int i=0; i<m; i++) {
            String[] matrixRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            for (int j=0; j<n; j++)
                matrix[i][j] = Integer.parseInt(matrixRowItems[j]);
        }
        matrixRotation(matrix, r);
        scanner.close();
    }
}
