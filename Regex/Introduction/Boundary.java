package Regex.Introduction;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/**
 * HackerRank Regex Introduction 6
 * https://www.hackerrank.com/challenges/matching-start-end/problem
 * @author Hasol
 */
public class Boundary {
    public static void main(String[] args) {
        RegexTest tester = new RegexTest();
        tester.checker("^\\d.{4}\\.$");
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
