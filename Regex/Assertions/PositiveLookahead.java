package Regex.Assertions;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/**
 * HackerRank Regex Assertions 1
 * https://www.hackerrank.com/challenges/positive-lookahead/problem
 * @author Hasol
 */
public class PositiveLookahead {
    public static void main(String[] args) {
        Regex_Test tester = new Regex_Test();
        tester.checker("o(?=oo)");
    }
}
class RegexTest {
    public void checker(String RegexPattern){
        Scanner Input = new Scanner(System.in);
        String TestString = Input.nextLine();
        Pattern p = Pattern.compile(RegexPattern);
        Matcher m = p.matcher(TestString);
        int count = 0;
        while (m.find())
            count += 1;
        System.out.format("Number of matches : %d", count);
    }
}
