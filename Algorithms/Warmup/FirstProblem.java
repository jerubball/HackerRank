package Algorithms.Warmup;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/**
 * HackerRank Algorithms Warmup 1
 * https://www.hackerrank.com/challenges/solve-me-first/problem
 * @author Hasol
 */
public class FirstProblem {
    static int solveMeFirst(int a, int b) {
        // Hint: Type return a+b; below 
        return a + b;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int sum = solveMeFirst(a, b);
        System.out.println(sum);
    }
}
