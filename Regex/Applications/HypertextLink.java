package Regex.Applications;
import java.io.*;
import java.util.*;
import java.util.regex.*;
/**
 * HackerRank Regex Applications 1
 * https://www.hackerrank.com/challenges/detect-html-links/problem
 * @author Hasol
 */
public class HypertextLink {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        StringBuilder sb = new StringBuilder(100*n);
        String reg = "<\\s*a\\s*[^<>/]*?href=\"([^\"]*?)\"[^<>/]*?>(<[^>]+?>)*?([^<>]*?)(<[^>]+?>)*?<\\s*/a\\s*>";
        while (scan.hasNextLine()) {
            sb.append(scan.nextLine());
            sb.append("\n");
        }
        Matcher m = Pattern.compile(reg).matcher(sb);
        while (m.find())
            System.out.println(m.group(1).trim() + "," + m.group(3).trim());
    }
}
