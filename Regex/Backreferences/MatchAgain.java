package Regex.Backreferences;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/**
 * HackerRank Regex Backreferences 1
 * https://www.hackerrank.com/challenges/matching-same-text-again-again/problem
 * @author Hasol
 */
public class MatchAgain {
    public static void main(String[] args) {
        RegexTest tester = new RegexTest();
        tester.checker("^([a-z]\\w\\s\\W\\d\\D[A-Z][A-z][aeiouAEIOU]\\S)\\1$");
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
