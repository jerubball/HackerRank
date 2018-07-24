package Regex.Applications;
import java.io.*;
import java.util.*;
import java.util.regex.*;
/**
 * HackerRank Regex Applications 15
 * https://www.hackerrank.com/challenges/find-hackerrank/problem
 * @author Hasol
 */
public class Hackerrank2 {
    static int matches(String input) {
        int n = 0;
        if (Pattern.compile("^hackerrank", Pattern.CASE_INSENSITIVE).matcher(input).find())
            n += 1;
        if (Pattern.compile("hackerrank$", Pattern.CASE_INSENSITIVE).matcher(input).find())
            n += 2;
        if (n == 0)
            n = -1;
        else if (n == 3)
            n = 0;
        return n;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        while (scan.hasNextLine())
            System.out.println(matches(scan.nextLine()));
    }
}
