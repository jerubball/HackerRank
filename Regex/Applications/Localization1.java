package Regex.Applications;
import java.io.*;
import java.util.*;
import java.util.regex.*;
/**
 * HackerRank Regex Applications 21
 * https://www.hackerrank.com/challenges/uk-and-us/problem
 * @author Hasol
 */
public class Localization1 {
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
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<n; i++) {
            sb.append(scan.nextLine());
            sb.append('\n');
        }
        int q = Integer.parseInt(scan.nextLine());
        for (int i=0; i<q; i++) {
            String w = scan.nextLine();
            w = Pattern.compile("ze").matcher(w).replaceFirst("[sz]e");
            System.out.println(numMatches(sb, "\\b" + w + "\\b"));
        }
    }
}