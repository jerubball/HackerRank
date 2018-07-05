package Algorithms.Implementation;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * HackerRank Algorithms Implementation 
 * https://www.hackerrank.com/challenges/kaprekar-numbers/problem
 * @author Hasol
 */
public class KaprekarNumber {
    // Complete the kaprekarNumbers function below.
    static int[] kaprekarNumbers(int p, int q) {
        ArrayList<Integer> a = new ArrayList<>();
        for (int i=p; i<=q; i++) {
            long j = (long)i*i;
            int k = (int)Math.log10(j) - (int)Math.log10(i);
            String s = Long.toString(j);
            int l = Integer.parseInt(s.substring(k));
            l = k == 0 ? l : l+Integer.parseInt(s.substring(0, k));
            if (i == l)
                a.add(i);
        }
        int[] b = new int[a.size()];
        for (int i=0; i<a.size(); i++)
            b[i] = a.get(i);
        return b;
    }
    static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int[] result = kaprekarNumbers(p, q);
        if (result.length == 0)
            bufferedWriter.write("INVALID RANGE");
        for (int i=0; i<result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));
            if (i != result.length-1)
                bufferedWriter.write(" ");
        }
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }
}
