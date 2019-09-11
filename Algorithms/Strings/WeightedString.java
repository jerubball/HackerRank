package Algorithms.Strings;import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * HackerRank Algorithms Strings 9
 * https://www.hackerrank.com/challenges/weighted-uniform-string/problem
 * @author Hasol
 */
public class Solution {
    // Complete the weightedUniformStrings function below.
    static String[] weightedUniformStrings(String s, int[] queries) {
        HashSet<Integer> list = new HashSet<>(s.length());
        char prev = ' ';
        int last = 0;
        for (char c: s.toCharArray())
            if (c == prev)
                list.add(last += weightedChar(c));
            else
                list.add(last = weightedChar(prev = c));
        String[] result = new String[queries.length];
        for (int i=0; i<queries.length; i++)
            if (list.contains(queries[i]))
                result[i] = "Yes";
            else
                result[i] = "No";
        return result;
    }
    static int weightedChar(char c) {
        return c-'a'+1;
    }
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String s = scanner.nextLine();
        int queriesCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int[] queries = new int[queriesCount];
        for (int i=0; i<queriesCount; i++) {
            int queriesItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            queries[i] = queriesItem;
        }
        String[] result = weightedUniformStrings(s, queries);
        for (int i=0; i<result.length; i++) {
            bufferedWriter.write(result[i]);
            if (i != result.length-1)
                bufferedWriter.write("\n");
        }
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }
}
