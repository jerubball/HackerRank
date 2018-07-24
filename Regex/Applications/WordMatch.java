package Regex.Applications;
import java.io.*;
import java.util.*;
import java.util.regex.*;
/**
 * HackerRank Regex Applications 6
 * https://www.hackerrank.com/challenges/find-a-word/problem
 * @author Hasol
 */
public class WordMatch {
    static int numMatches(CharSequence seq, String reg) {
        int n = 0;
        Matcher m = Pattern.compile(reg).matcher(seq);
        while (m.find())
            n++;
        return n;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        StringBuilder sb = new StringBuilder(100*n);
        for (int i=0; i<n; i++) {
            sb.append(scan.nextLine());
            sb.append("\n");
        }
        int t = Integer.parseInt(scan.nextLine());
        for (int i=0; i<t; i++)
            System.out.println(numMatches(sb, "\\b" + scan.nextLine() + "\\b"));
    }
}
