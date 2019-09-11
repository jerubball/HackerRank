package Java.Strings;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/**
 * HackerRank Java Strings 3
 * https://www.hackerrank.com/challenges/java-string-compare/problem
 * @author Hasol
 */
public class Compare {
    static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";
        String[] str = new String[s.length()-k+1];
        for (int i=0; i<str.length; i++)
            str[i] = s.substring(i,i+k);
        Arrays.sort(str);
        smallest = str[0];
        largest = str[str.length-1];
        return smallest + "\n" + largest;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();
        System.out.println(getSmallestAndLargest(s, k));
    }
}
