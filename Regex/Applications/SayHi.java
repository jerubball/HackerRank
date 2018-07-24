package Regex.Applications;
import java.io.*;
import java.util.*;
/**
 * HackerRank Regex Applications 16
 * https://www.hackerrank.com/challenges/saying-hi/problem
 * @author Hasol
 */
public class SayHi {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        String g, reg = "^[Hh][Ii]\\s[^Dd].*$";
        while (scan.hasNextLine())
            if ((g = scan.nextLine()).matches(reg))
                System.out.println(g);
    }
}
