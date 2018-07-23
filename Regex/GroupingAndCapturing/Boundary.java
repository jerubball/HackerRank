package Regex.GroupingAndCapturing;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/**
 * HackerRank Regex GroupingAndCapturing 1
 * https://www.hackerrank.com/challenges/matching-word-boundaries/problem
 * @author Hasol
 */
public class Boundary {
    public static void main(String[] args) {
        RegexTest tester = new RegexTest();
        tester.checker("\\b[aeiouAEIOU][A-z]*\\b");
    }
}
class RegexTest {
    public void checker(String RegexPattern) {
        Scanner Input = new Scanner(System.in);
        String TestString = Input.nextLine();
        Pattern p = Pattern.compile(RegexPattern);
        Matcher m = p.matcher(TestString);
        System.out.println(m.find());
    }
}
