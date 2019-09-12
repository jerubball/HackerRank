package Algorithms.Strings;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * HackerRank Algorithms Strings 12
 * https://www.hackerrank.com/challenges/gem-stones/problem
 * @author Hasol
 */
public class Gemstones {
    static final int ALPHABET = 26;
    // Complete the gemstones function below.
    static int gemstones(String[] arr) {
        int[] stone = new int[ALPHABET];
        for (String s: arr) {
            int[] list = occurrences(s);
            for (int i=0; i<stone.length; i++)
                if (list[i] > 0)
                    stone[i]++;
        }
        int result = 0;
        for (int i: stone)
            if (i == arr.length)
                result++;
        return result;
    }
    static int[] occurrences(String s) {
        int[] list = new int[ALPHABET];
        for (char c: s.toCharArray())
            list[c-'a']++;
        return list;
    }
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        String[] arr = new String[n];
        for (int i=0; i<n; i++) {
            String arrItem = scanner.nextLine();
            arr[i] = arrItem;
        }
        int result = gemstones(arr);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }
}
