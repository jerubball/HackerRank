package Java.ExceptionHandling;
import java.util.Scanner;
/**
 * HackerRank Java ExceptionHandling 2
 * https://www.hackerrank.com/challenges/java-exception-handling/problem
 * @author Hasol
 */
public class ExponentHandling {
    static final MyCalculator myCalculator = new MyCalculator();
    static final Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int p = in.nextInt();
            try {
                System.out.println(myCalculator.power(n, p));
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
class MyCalculator {
    long power(int n, int p) throws Exception {
        if (n < 0 || p < 0)
            throw new Exception("n or p should not be negative.");
        else if (n == 0 && p == 0)
            throw new Exception("n and p should not be zero.");
        else
            return Math.round(Math.pow(n, p));
    }
}
