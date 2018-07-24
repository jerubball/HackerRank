package Regex.Backreferences;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/**
 * HackerRank Regex Backreferences 2
 * https://www.hackerrank.com/challenges/backreferences-to-failed-groups/problem
 * @author Hasol
 */
public class MatchFailed {    
    public static void main(String[] args) {
        RegexTest tester = new RegexTest();
        tester.checker("^\\d{2}(-?)(\\d{2}\\1){2}\\d{2}$");
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
