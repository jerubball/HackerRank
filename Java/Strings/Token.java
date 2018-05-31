package Java.Strings;
import java.io.*;
import java.util.*;
/**
 * HackerRank Java Strings 6
 * https://www.hackerrank.com/challenges/java-string-tokens/problem
 * @author Hasol
 */
public class Token {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        try {
            String s = scan.nextLine();
            // Write your code here.
            String[] l = s.trim().split("[ !,?._'@]+");
            System.out.println(l.length == 1 && l[0].length() == 0 ? 0 : l.length);
            for (String n: l)
                System.out.println (n);
        } catch (NoSuchElementException e) {
            System.out.println (0);
        }
        scan.close();
    }
}
