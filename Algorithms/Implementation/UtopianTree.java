package Algorithms.Implementation;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * HackerRank Algorithms Implementation 21
 * https://www.hackerrank.com/challenges/utopian-tree/problem
 * @author Hasol
 */
public class UtopianTree {
    // Complete the utopianTree function below.
    static int utopianTree(int n) {
        return (int) Math.round(Math.pow(2, Math.ceil(n / 2.0) + 1) - 1 - n % 2);
    }
    static int alternateSolution(int n) {
        int a = 1;
        for (int i=0 ; i<n; i++)
            a = i%2 == 0 ? a*2 : a+1;
        return a;
    }
    static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int tItr=0; tItr<t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            int result = utopianTree(n);
            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
        scanner.close();
    }
}
