package Algorithms.Implementation;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * HackerRank Algorithms Implementation 63
 * https://www.hackerrank.com/challenges/larrys-array/problem
 * @author Hasol
 */
public class ParityPermutation {
    // Complete the larrysArray function below.
    static String larrysArray(int[] a) {
        boolean[] u = new boolean[a.length];
        ArrayList<ArrayList<Integer>> l = new ArrayList<>();
        for (int i=0; i<a.length; i++)
            if (!u[i]) {
                ArrayList<Integer> n = new ArrayList<>();
                int j = i;
                do {
                    j = a[j]-1;
                    u[j] = true;
                    n.add(j);
                } while (i != j);
                l.add(n);
            }
        boolean p = true;
        for (ArrayList<Integer> m: l)
            if (m.size()%2 == 0)
                p = !p;
        return p ? "YES" : "NO";
    }
    static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int tItr=0; tItr<t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            int[] a = new int[n];
            String[] aItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            for (int i=0; i<n; i++)
                a[i] = Integer.parseInt(aItems[i]);
            String result = larrysArray(a);
            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
        scanner.close();
    }
}
