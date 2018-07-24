package Regex.Applications;
import java.io.*;
import java.util.*;
import java.util.regex.*;
/**
 * HackerRank Regex Applications 3
 * https://www.hackerrank.com/challenges/find-substring/problem
 * @author Hasol
 */
public class SubWord {
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
        int q = Integer.parseInt(scan.nextLine());
        for (int i=0; i<q; i++)
            System.out.println(numMatches(sb, "\\w" + scan.nextLine() + "\\w"));
    }
}
