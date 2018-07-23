package Regex.GroupingAndCapturing;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/**
 * HackerRank Regex GroupingAndCapturing 3
 * https://www.hackerrank.com/challenges/alternative-matching/problem
 * @author Hasol
 */
public class Alternation {
    public static void main(String[] args) {
        RegexTest tester = new RegexTest();
        tester.checker("^([MDE]r|Mr?s)\\.[a-zA-Z]+$");
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
