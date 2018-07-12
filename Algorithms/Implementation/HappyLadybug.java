package Algorithms.Implementation;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * HackerRank Algorithms Implementation 58
 * https://www.hackerrank.com/challenges/happy-ladybugs/problem
 * @author Hasol
 */
public class HappyLadybug {
    // Complete the happyLadybugs function below.
    static String happyLadybugs(String b) {
        int u = '_'-'A';
        int[] a = new int[u+1];
        char[] d = b.toCharArray();
        for (char c: d)
            a[c-'A']++;
        if (a[u] == d.length)
            return "YES";
        else if (a[u] == 0) {
            for (int i=0; i<d.length; i++)
                if ((i == 0 || d[i] != d[i-1]) && (i == d.length-1 || d[i] != d[i+1]))
                    return "NO";
            return "YES";
        } else {
            for (int i=0; i<u; i++)
                if (a[i] == 1)
                    return "NO";
            return "YES";
        }
    }
    static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int g = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int gItr=0; gItr<g; gItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            String b = scanner.nextLine();
            String result = happyLadybugs(b);
            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
        scanner.close();
    }
}
