package Java.Strings;
import java.io.*;
import java.util.*;
/**
 * HackerRank Java Strings 4
 * https://www.hackerrank.com/challenges/java-string-reverse/problem
 * @author Hasol
 */
public class Reverse {
    static boolean isPalindrome(String s) {
        StringBuilder b = new StringBuilder(s).reverse();
        return s.equals(b.toString());
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        System.out.println (isPalindrome(a) ? "Yes" : "No");
    }
}
