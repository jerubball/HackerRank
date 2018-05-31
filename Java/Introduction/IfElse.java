package Java.Introduction;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * HackerRank Java Introduction 3
 * https://www.hackerrank.com/challenges/java-if-else/problem
 * @author Hasol
 */
public class IfElse {
    static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        String s = n%2 == 1 || (n>=6 && n<=20) ? "Weird" : "Not Weird";
        System.out.println(s);
        scanner.close();
    }
}
