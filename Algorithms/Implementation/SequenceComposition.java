package Algorithms.Implementation;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * HackerRank Algorithms Implementation 27
 * https://www.hackerrank.com/challenges/permutation-equation/problem
 * @author Hasol
 */
public class SequenceComposition {
    // Complete the permutationEquation function below.
    static int[] permutationEquation(int[] p) {
        int[] q = new int[p.length];
        for (int i=0; i<p.length; i++)
            q[p[i]-1] = i+1;
        int[] r = new int[q.length];
        for (int j=0; j<q.length; j++)
            r[j] = q[q[j]-1];
        return r;
    }
    static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int[] p = new int[n];
        String[] pItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int i=0; i<n; i++)
            p[i] = Integer.parseInt(pItems[i]);
        int[] result = permutationEquation(p);
        for (int i=0; i<result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));
            if (i != result.length-1)
                bufferedWriter.write("\n");
        }
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }
}
