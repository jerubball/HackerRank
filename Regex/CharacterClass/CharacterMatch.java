package Regex.CharacterClass;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/**
 * HackerRank Regex CharacterClass 1
 * https://www.hackerrank.com/challenges/matching-specific-characters/problem
 * @author Hasol
 */
public class CharacterMatch {
    public static void main(String[] args) {
        RegexTest tester = new RegexTest();
        tester.checker("^[123][120][xs0][30Aa][xsu][,.]$");
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
