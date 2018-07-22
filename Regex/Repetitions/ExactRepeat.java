package Regex.Repetitions;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/**
 * HackerRank Regex Repetitions 1
 * https://www.hackerrank.com/challenges/matching-x-repetitions/problem
 * @author Hasol
 */
public class ExactRepeat {
    public static void main(String[] args) {
        RegexTest tester = new RegexTest();
        tester.checker("^[^\\W13579]{40}[\\s13579]{5}$");
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
