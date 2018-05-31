package Java.Strings;
import java.io.*;
import java.util.*;
/**
 * HackerRank Java Strings 1
 * https://www.hackerrank.com/challenges/java-strings-introduction/problem
 * @author Hasol
 */
public class Introduction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();
        //Enter your code here.
        System.out.println (A.length() + B.length());
        System.out.println (A.compareToIgnoreCase(B) > 0 ? "Yes" : "No");
        A = A.substring(0,1).toUpperCase() + A.substring(1).toLowerCase();
        B = B.substring(0,1).toUpperCase() + B.substring(1).toLowerCase();
        System.out.println (A + " " + B);
    }
}
