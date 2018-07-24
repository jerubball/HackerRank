package Regex.Applications;
import java.io.*;
import java.util.*;
import java.util.regex.*;
/**
 * HackerRank Regex Applications 4
 * https://www.hackerrank.com/challenges/alien-username/problem
 * @author Hasol
 */
public class Username {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        String reg = "^[_.]\\d+[A-Za-z]*_?$";
        while (scan.hasNextLine())
            System.out.println(scan.nextLine().matches(reg) ? "VALID" : "INVALID");
    }
}
