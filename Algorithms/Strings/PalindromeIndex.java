package Algorithms.Strings;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * HackerRank Algorithms Strings 17
 * https://www.hackerrank.com/challenges/palindrome-index/problem
 * @author Hasol
 */
public class PalindromeIndex {
    // Complete the palindromeIndex function below.
    static int palindromeIndex(String s) {
        if (!isPalindrome(s)) {
            for (int i=0; i<s.length()/2; i++) {
                int j = s.length()-i-1;
                if (s.charAt(i) != s.charAt(j)) {
                    if (isPalindrome(s.substring(0,i) + s.substring(i+1)))
                        return i;
                    if (isPalindrome(s.substring(0,j) + s.substring(j+1)))
                        return j;
                    break;
                }
            }
        }
        return -1;
    }
    static int palindromeIndexAlt(String s) {
        if (!isPalindrome(s)) {
            StringBuilder sb = new StringBuilder(s);
            for (int i=0; i<s.length(); i++) {
                char c = sb.charAt(i);
                sb.deleteCharAt(i);
                if (isPalindrome(sb))
                    return i;
                sb.insert(i, c);
            }    
        }
        return -1;
    }
    static boolean isPalindrome(CharSequence s) {
        for (int i=0; i<s.length()/2; i++)
            if (s.charAt(i) != s.charAt(s.length()-i-1))
                return false;
        return true;
    }
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int qItr=0; qItr<q; qItr++) {
            String s = scanner.nextLine();
            int result = palindromeIndex(s);
            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
        scanner.close();
    }
}
