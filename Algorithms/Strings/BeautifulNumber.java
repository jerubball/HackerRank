package Algorithms.Strings;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * HackerRank Algorithms Strings 10
 * https://www.hackerrank.com/challenges/separate-the-numbers/problem
 * @author Hasol
 */
public class BeautifulNumber {
    // Complete the separateNumbers function below.
    static void separateNumbers(String s) {
        iter: for (int i=1; i<=s.length()/2; i++) {
            long number = Long.parseLong(s.substring(0,i)), n = number;
            int j = i;
            while (j < s.length()) {
                String str = Long.toString(++n);
                int size = str.length();
                if (s.length() < j+size || str.compareTo(s.substring(j, j+size)) != 0)
                    continue iter;
                j += size;
            }
            System.out.println("YES " + number);
            return;
        }
        System.out.println("NO");
    }
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int qItr=0; qItr<q; qItr++) {
            String s = scanner.nextLine();
            separateNumbers(s);
        }
        scanner.close();
    }
}
