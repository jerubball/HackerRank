package Regex.Applications;
import java.io.*;
import java.util.*;
/**
 * HackerRank Regex Applications 19
 * https://www.hackerrank.com/challenges/split-number/problem
 * @author Hasol
 */
public class PhoneNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        for (int i=0; i<n; i++) {
            String[] s = scan.nextLine().split("[ -]");
            System.out.println("CountryCode=" + s[0] + ",LocalAreaCode=" + s[1] + ",Number=" + s[2]);
        }
    }
}
