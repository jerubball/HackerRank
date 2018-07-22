package Regex.Repetitions;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/**
 * HackerRank Regex Repetitions 2
 * https://www.hackerrank.com/challenges/matching-x-y-repetitions/problem
 * @author Hasol
 */
public class BoundRepeat {
    public static void main(String[] args) {
        RegexTest tester = new RegexTest();
        tester.checker("^\\d{1,2}[\\w&&\\D]{3,}\\.{0,3}$");
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
