package Regex.Introduction;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/**
 * HackerRank Regex Introduction 5
 * https://www.hackerrank.com/challenges/matching-word-non-word/problem
 * @author Hasol
 */
public class Words {
    public static void main(String[] args) {
        RegexTest tester = new RegexTest();
        tester.checker("\\w{3}\\W\\w{10}\\W\\w{3}");
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
