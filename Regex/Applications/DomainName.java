package Regex.Applications;
import java.io.*;
import java.util.*;
import java.util.regex.*;
/**
 * HackerRank Regex Applications 8
 * https://www.hackerrank.com/challenges/detect-the-domain-name/problem
 * @author Hasol
 */
public class DomainName {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        StringBuilder sb = new StringBuilder(100*n);
        HashSet<String> set = new HashSet<>();
        String reg = "(?<=https?://)(ww\\w\\.)?([\\w.-]+\\.[A-Za-z]+)";
        while (scan.hasNextLine()) {
            sb.append(scan.nextLine());
            sb.append("\n");
        }
        Matcher m = Pattern.compile(reg).matcher(sb);
        while (m.find())
            set.add(m.group(2).trim());
        ArrayList<String> arr = new ArrayList<>();
        for (String s: set)
            arr.add(s);
        arr.sort(null);
        for (int i=0; i<arr.size(); i++) {
            System.out.print(arr.get(i));
            if (i != arr.size()-1)
                System.out.print(";");
        }
    }
}
