package Algorithms.Implementation;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * HackerRank Algorithms Implementation 42
 * https://www.hackerrank.com/challenges/organizing-containers-of-balls/problem
 * @author Hasol
 */
public class BallSwap {
    // Complete the organizingContainers function below.
    static String organizingContainers(int[][] container) {
        long[] rs = new long[container.length], cs = new long[container[0].length];
        for (int i=0; i<container.length; i++)
            for (int j=0; j<container[i].length; j++) {
                rs[i] += container[i][j];
                cs[j] += container[i][j];
            }
        ArrayList<Long> rsa = new ArrayList<>(), csa = new ArrayList<>();
        for (long l: rs)
            rsa.add(l);
        for (long l: cs)
            csa.add(l);
        boolean b = true;
        for (Long l: rsa)
            b = csa.remove(l) ? b : false;
        return b ? "Possible" : "Impossible";
    }
    static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int qItr = 0; qItr < q; qItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            int[][] container = new int[n][n];
            for (int i=0; i<n; i++) {
                String[] containerRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
                for (int j=0; j<n; j++)
                    container[i][j] = Integer.parseInt(containerRowItems[j]);
            }
            String result = organizingContainers(container);
            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
        scanner.close();
    }
}
