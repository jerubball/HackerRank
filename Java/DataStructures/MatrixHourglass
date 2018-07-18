package Java.DataStructures;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * HackerRank Java DataStructures 2
 * https://www.hackerrank.com/challenges/java-2d-array/problem
 * @author Hasol
 */
public class MatrixHourglass {
    static int hourglass(int[][] arr) {
        int s = Integer.MIN_VALUE, c;
        for (int i=2; i<arr.length; i++)
            for (int j=2; j<arr.length; j++)
                s = (c = arr[i-2][j-2]+arr[i-2][j-1]+arr[i-2][j]+arr[i-1][j-1]+arr[i][j-2]+arr[i][j-1]+arr[i][j]) > s ? c : s;
        return s;
    }
    static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int[][] arr = new int[6][6];
        for (int i=0; i<arr.length; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            for (int j=0; j<arr[i].length; j++)
                arr[i][j] = Integer.parseInt(arrRowItems[j]);
        }
        scanner.close();
        int s = hourglass(arr);
        System.out.println(s);
    }
}
