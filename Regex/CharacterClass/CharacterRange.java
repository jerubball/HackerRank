package Regex.CharacterClass;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/**
 * HackerRank Regex CharacterClass 3
 * https://www.hackerrank.com/challenges/matching-range-of-characters/problem
 * @author Hasol
 */
public class CharacterRange {
    public static void main(String[] args) {
        RegexTest tester = new RegexTest();
        tester.checker("^[a-z][1-9][^a-z][^A-Z][A-Z]");
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
