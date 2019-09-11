package Algorithms.Strings;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * HackerRank Algorithms Strings 5
 * https://www.hackerrank.com/challenges/caesar-cipher-1/problem
 * @author Hasol
 */
public class CeasarCipher {
    // Complete the caesarCipher function below.
    static String caesarCipher(String s, int k) {
        final int ALPHABET = 26;
        k %= ALPHABET;
        char[] arr = s.toCharArray();
        char c;
        for (int i=0; i<arr.length; i++)
            if (Character.isAlphabetic(arr[i])) {
                if (Character.isUpperCase(arr[i]))
                    c = 'Z';
                else
                    c = 'z';
                arr[i] += k;
                if (arr[i]>c)
                    arr[i] -= ALPHABET;
            }
        return new String(arr);
    }
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        String s = scanner.nextLine();
        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        String result = caesarCipher(s, k);
        bufferedWriter.write(result);
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }
}
