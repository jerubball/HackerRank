package Regex.Introduction;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/**
 * HackerRank Regex Introduction 3
 * https://www.hackerrank.com/challenges/matching-digits-non-digit-character/problem
 * @author Hasol
 */
public class Numbers {
    public static void main(String[] args) {
        RegexTest tester = new RegexTest();
        tester.checker("(\\d{2}\\D){2}\\d{4}");
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
