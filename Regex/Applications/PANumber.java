package Regex.Applications;
import java.io.*;
import java.util.*;
/**
 * HackerRank Regex Applications 14
 * https://www.hackerrank.com/challenges/valid-pan-format/problem
 * @author Hasol
 */
public class PANumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        String reg = "^[A-Z]{5}\\d{4}[A-Z]$";
        while (scan.hasNextLine())
            System.out.println(scan.nextLine().matches(reg) ? "YES" : "NO");
    }
}
