package Java.Introduction;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * HackerRank Java Introduction 6
 * https://www.hackerrank.com/challenges/java-loops-i/problem
 * @author Hasol
 */
public class Loop1 {
    static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int i=1; i<=10; i++)
            System.out.printf("%d x %d = %d%n", n, i, n*i);
        scanner.close();
    }
}
