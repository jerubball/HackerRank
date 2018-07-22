package Regex.Repetitions;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/**
 * HackerRank Regex Repetitions 3
 * https://www.hackerrank.com/challenges/matching-zero-or-more-repetitions/problem
 * @author Hasol
 */
public class AsteriskMatch {
    public static void main(String[] args) {
        RegexTest tester = new RegexTest();
        tester.checker("^\\d{2,}[a-z]*[A-Z]*$");
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
