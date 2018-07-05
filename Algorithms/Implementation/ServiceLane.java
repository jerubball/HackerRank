package Algorithms.Implementation;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * HackerRank Algorithms Implementation 51
 * https://www.hackerrank.com/challenges/service-lane/problem
 * @author Hasol
 */
public class ServiceLane {
    // Complete the serviceLane function below.
    static int[] serviceLane(int[] width, int[][] cases) {
        int[] w = new int[cases.length];
        for (int i=0; i<w.length; i++)
            w[i] = Integer.MAX_VALUE;
        for (int i=0; i<cases.length; i++)
            for (int j=cases[i][0]; j<=cases[i][1]; j++)
                if (width[j] < w[i])
                    w[i] = width[j];
        return w;
    }
    static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String[] nt = scanner.nextLine().split(" ");
        int n = Integer.parseInt(nt[0]);
        int t = Integer.parseInt(nt[1]);
        int[] width = new int[n];
        String[] widthItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int i=0; i<n; i++)
            width[i] = Integer.parseInt(widthItems[i]);
        int[][] cases = new int[t][2];
        for (int i=0; i<t; i++) {
            String[] casesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            for (int j=0; j<2; j++)
                cases[i][j] = Integer.parseInt(casesRowItems[j]);
        }
        int[] result = serviceLane(width, cases);
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
