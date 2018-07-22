package Regex.Repetitions;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/**
 * HackerRank Regex Repetitions 4
 * https://www.hackerrank.com/challenges/matching-one-or-more-repititions/problem
 * @author Hasol
 */
public class PlusMatch {
    public static void main(String[] args) {
        RegexTest tester = new RegexTest();
        tester.checker("^\\d+[A-Z]+[a-z]+$");
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
