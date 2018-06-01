package Java.BigNumber;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * HackerRank Java BigNumber 2
 * https://www.hackerrank.com/challenges/java-primality-test/problem
 * @author Hasol
 */
public class Primality {
    static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        String n = scanner.nextLine();
        int c = n.length();
        System.out.println(new BigInteger(n).isProbablePrime(c) ? "prime" : "not prime");
        scanner.close();
    }
}
