package Java.Strings;
import java.util.Scanner;
/**
 * HackerRank Java Strings 10
 * https://www.hackerrank.com/challenges/valid-username-checker/problem
 * @author Hasol
 */
public class Username {
    static final Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        int n = Integer.parseInt(scan.nextLine());
        while (n-- > 0)
            System.out.println(scan.nextLine().matches(UsernameValidator.regularExpression) ? "Valid" : "Invalid");
    }
}
class UsernameValidator {
    //Write regular expression here.
    static String regularExpression = "[a-zA-Z](\\w|_){7,29}";
}
