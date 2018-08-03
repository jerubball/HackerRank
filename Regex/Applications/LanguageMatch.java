package Regex.Applications;
import java.io.*;
import java.util.*;
import java.util.regex.*;
/**
 * HackerRank Regex Applications 18
 * https://www.hackerrank.com/challenges/programming-language-detection/problem
 * @author Hasol
 */
public class LanguageMatch {
    static String solve(StringBuilder sb) {
        int dm = Pattern.DOTALL+Pattern.MULTILINE;
        String s = sb.toString();
        int[] score = new int[Detector.length];
        Detector[] list = new Detector[] {
            new Detector("\\\\.*?&", 0, true, 10, 0, 1), // c & java comment
            new Detector("^\\s*#(include|define)\\b.+", 0, true, 100, 0), // c include,define
            new Detector("#.*?&", 0, true, 10, 2), // python comment
            new Detector("/\\*.*?[^\\\\]\\*/", dm, true, 10, 0, 1), // c & java block comment
            new Detector("\"\"\".*?[^\\\\]\"\"\"", dm, true, 10, 2), // python block comment
            new Detector("[\"'].*?[^\\\\][\"']", dm, true, 0), // any quotation
            new Detector(";\\s*?$", 0, false, 25, 0, 1), // c & java semicolon
            new Detector("^\\s*?import java.+", 0, false, 100, 1), // java import
            new Detector(":\\s*?$", 0, false, 50, 1) // python colon
        };
        for (Detector d: list) {
            Matcher m = Pattern.compile(d.pattern, d.mode).matcher(s);
            if (m.find()) {
                if (d.replace)
                    s = m.replaceAll("");
                for (int i: d.index)
                    score[i] += d.score;
            }
        }
        score[2] += 1;
        // return greatest score
        int k = 0;
        for (int i=1; i<score.length; i++)
            if (score[k] < score[i])
                k = i;
        return Detector.lang[k];
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (scan.hasNextLine()) {
            sb.append(scan.nextLine());
            sb.append('\n');
        }
        System.out.println(solve(sb));
    }
}
class Detector {
    static final String[] lang = new String[] {"C", "Java", "Python"};
    static final int length = lang.length;
    String pattern;
    boolean replace;
    int mode, score;
    int[] index;
    public Detector(String p, int m, boolean r, int s, int... i) {
        pattern = p;
        mode = m;
        replace = r;
        score = s;
        index = i;
    }
}
