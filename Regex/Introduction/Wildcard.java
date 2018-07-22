package Regex.Introduction;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/**
 * HackerRank Regex Introduction 2
 * https://www.hackerrank.com/challenges/matching-anything-but-new-line/problem
 * @author Hasol
 */
public class Wildcard {
    public static void main(String[] args) {
        Tester tester = new Tester();
        tester.check("...\\....\\....\\...."); 
    }
}
class Tester {
    public void check(String pattern) {
        Scanner scanner = new Scanner(System.in);
        String testString = scanner.nextLine();
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(testString);
        boolean match = m.matches();
        System.out.format("%s", match);
    }
}
