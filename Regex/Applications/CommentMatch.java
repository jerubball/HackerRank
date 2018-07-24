package Regex.Applications;
import java.io.*;
import java.util.*;
import java.util.regex.*;
/**
 * HackerRank Regex Applications 9
 * https://www.hackerrank.com/challenges/ide-identifying-comments/problem
 * @author Hasol
 */
public class CommentMatch {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String reg = "(?<![\\\\])(\".*?[^\\\\]\"|'.*?[^\\\\]'|/\\*.*?[^\\\\]\\*/|//.*?\\v+)";
        while (scan.hasNextLine()) {
            sb.append(scan.nextLine());
            sb.append("\n");
        }
        Pattern p = Pattern.compile(reg, Pattern.MULTILINE+Pattern.DOTALL);
        Matcher m = p.matcher(sb);
        while (m.find()) {
            String g = m.group(1);
            if (g.charAt(0) == '/')
                System.out.println(g.replaceAll("\\n\\h+", "\n").trim());
            m = p.matcher(m.replaceFirst(""));
        }
    }
}
