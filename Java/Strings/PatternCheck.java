package Java.Strings;
import java.util.Scanner;
import java.util.regex.*;
/**
 * HackerRank Java Strings 7
 * https://www.hackerrank.com/challenges/pattern-syntax-checker/problem
 * @author Hasol
 */
public class PatternCheck {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while (testCases-- > 0) {
            String pattern = in.nextLine();
            try {
                Pattern.compile(pattern);
                System.out.println("Valid");
            } catch (PatternSyntaxException e) {
                System.out.println("Invalid");
            }
        }
    }
}
