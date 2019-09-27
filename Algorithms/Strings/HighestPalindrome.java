package Algorithms.Strings;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * HackerRank Algorithms Strings 24
 * https://www.hackerrank.com/challenges/richie-rich/problem
 * @author Hasol
 */
public class HighestPalindrome {
    // Complete the highestValuePalindrome function below.
    static String highestValuePalindrome(String s, int n, int k) {
        StringBuilder sb = new StringBuilder(s);
        for (int i=0; i<n/2; i++) {
            int j=n-i-1;
            if (sb.charAt(i) != sb.charAt(j)) {
                if (k == 0)
                    return "-1";
                else if (sb.charAt(i) > sb.charAt(j))
                    sb.setCharAt(j, sb.charAt(i));
                else
                    sb.setCharAt(i, sb.charAt(j));
                k--;
            }
        }
        for (int i=0; i<n/2+1 && k>0; i++) {
            int j=n-i-1;
            if (sb.charAt(i) == '9')
                continue;
            else if (i == j) {
                sb.setCharAt(i, '9');
                k--;
            } else if (sb.charAt(i) != s.charAt(i) || sb.charAt(j) != s.charAt(j)) {
                sb.setCharAt(i, '9');
                sb.setCharAt(j, '9');
                k--;
            } else if (k > 1) {
                sb.setCharAt(i, '9');
                sb.setCharAt(j, '9');
                k -= 2;
            }
        }
        return sb.toString();
    }
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String[] nk = scanner.nextLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        String s = scanner.nextLine();
        String result = highestValuePalindrome(s, n, k);
        bufferedWriter.write(result);
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }
}
