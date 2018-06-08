package Algorithms.Implementation;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/**
 * HackerRank Algorithms Implementation 10
 * https://www.hackerrank.com/challenges/bon-appetit/problem
 * @author Hasol
 */
public class RestuarantBill {
    public static double solve (int[] b, int k, int c) {
        double r = 0;
        for (int a: b)
            r += a;
        r = (r-b[k]) / 2;
        return c - r;
    }
    public static void main(String[] args) {
        //Enter your code here. Read input from STDIN. Print output to STDOUT
        Scanner s = new Scanner (System.in);
        String s0 = s.nextLine().trim();
        String[] s1 = s0.split("\\s+");
        int n = Integer.parseInt(s1[0]);
        int k = Integer.parseInt(s1[1]);
        int[] b = new int[n];
        s0 = s.nextLine().trim();
        s1 = s0.split("\\s+");
        for (int i = 0; i < n; i++)
            b[i] = Integer.parseInt(s1[i]);
        s0 = s.nextLine().trim();
        s1 = s0.split("\\s+");
        int c = Integer.parseInt(s1[0]);
        int result = (int) Math.round(solve (b, k, c));
        if (result == 0)
            System.out.println ("Bon Appetit");
        else
            System.out.println (result);
    }
}
