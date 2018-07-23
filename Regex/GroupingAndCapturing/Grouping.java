import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
package Regex.GroupingAndCapturing;
/**
 * HackerRank Regex GroupingAndCapturing 2
 * https://www.hackerrank.com/challenges/capturing-non-capturing-groups/problem
 * @author Hasol
 */
public class Grouping {
    public static void main(String[] args) {
        Regex_Test tester = new Regex_Test();
        tester.checker("(?:ok){3,}");
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
