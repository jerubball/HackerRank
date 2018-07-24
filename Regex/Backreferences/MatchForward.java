package Regex.Backreferences;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/**
 * HackerRank Regex Backreferences 4
 * https://www.hackerrank.com/challenges/forward-references/problem
 * @author Hasol
 */
public class Solution {
    public static void main(String[] args) {
        RegexTest tester = new RegexTest();
        tester.checker("^tac(tac(tic)?)*$");
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
