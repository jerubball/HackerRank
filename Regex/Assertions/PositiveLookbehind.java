package Regex.Assertions;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/**
 * HackerRank Regex Assertions 3
 * https://www.hackerrank.com/challenges/positive-lookbehind/problem
 * @author Hasol
 */
public class PositiveLookbehind {
    public static void main(String[] args) {
        RegexTest tester = new RegexTest();
        tester.checker("(?<=[13579])\\d");
    }
}
class RegexTest {
    public void checker(String RegexPattern) {
        Scanner Input = new Scanner(System.in);
        String TestString = Input.nextLine();
        Pattern p = Pattern.compile(RegexPattern);
        Matcher m = p.matcher(TestString);
        int count = 0;
        while (m.find())
            count += 1;
        System.out.format("Number of matches : %d", count);
    }
}
