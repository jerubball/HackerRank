package Java.BigNumber;
import java.io.*;
import java.util.*;
import java.math.*;
/**
 * HackerRank Java BigNumber 3
 * https://www.hackerrank.com/challenges/java-biginteger/problem
 * @author Hasol
 */
public class BigIntOperation {
    public static void main(String[] args) {
        //Enter your code here.
        Scanner s = new Scanner(System.in);
        String x = s.nextLine(), y = s.nextLine();
        BigInteger a = new BigInteger(x), b = new BigInteger(y);
        System.out.println (a.add(b));
        System.out.println (a.multiply(b));
        s.close();
    }
}
