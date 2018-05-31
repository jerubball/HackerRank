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
        String a = sc.next();
        String b = sc.next();
        //Enter your code here.
        System.out.println (a.length() + b.length());
        System.out.println (a.compareToIgnoreCase(b) > 0 ? "Yes" : "No");
        a = a.substring(0,1).toUpperCase() + a.substring(1).toLowerCase();
        a = b.substring(0,1).toUpperCase() + b.substring(1).toLowerCase();
        System.out.println (a + " " + b);
    }
}
