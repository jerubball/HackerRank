package Regex.Applications;
import java.io.*;
import java.util.*;
import java.util.regex.*;
/**
 * HackerRank Regex Applications 11
 * https://www.hackerrank.com/challenges/hackerrank-tweets/problem
 * @author Hasol
 */
public class Hackerrank {
    static int numMatches(CharSequence seq, String reg) {
        int n = 0;
        Matcher m = Pattern.compile(reg, Pattern.CASE_INSENSITIVE).matcher(seq);
        while (m.find())
            n++;
        return n;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        StringBuilder sb = new StringBuilder(100*n);
        HashSet<String> set = new HashSet<>();
        while (scan.hasNextLine()) {
            sb.append(scan.nextLine());
            sb.append("\n");
        }
        System.out.println(numMatches(sb, "hackerrank"));
    }
}
