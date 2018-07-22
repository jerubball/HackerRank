package Regex.Introduction;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/**
 * HackerRank Regex Introduction 4
 * https://www.hackerrank.com/challenges/matching-whitespace-non-whitespace-character/problem
 * @author Hasol
 */
public class Whitespace {
    public static void main(String[] args) {
        RegexTest tester = new RegexTest();
        tester.checker("\\S\\S\\s\\S\\S\\s\\S\\S");
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
