package Regex.Applications;
import java.io.*;
import java.util.*;
/**
 * HackerRank Regex Applications 13
 * https://www.hackerrank.com/challenges/utopian-identification-number/problem
 * @author Hasol
 */
public class IDNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        String reg = "^[a-z]{0,3}\\d{2,8}[A-Z]{3,}$";
        while (scan.hasNextLine())
            System.out.println(scan.nextLine().matches(reg) ? "VALID" : "INVALID");
    }
}
