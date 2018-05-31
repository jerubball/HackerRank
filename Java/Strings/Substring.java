package Java.Strings;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/**
 * HackerRank Java Strings 2
 * https://www.hackerrank.com/challenges/java-substring/problem
 * @author Hasol
 */
public class Substring {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int start = in.nextInt();
        int end = in.nextInt();
        System.out.println(s.substring(start, end));
        in.close();
    }
}
