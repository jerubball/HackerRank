package Regex.Applications;
import java.io.*;
import java.util.*;
import java.util.regex.*;
/**
 * HackerRank Regex Applications 12
 * https://www.hackerrank.com/challenges/stack-exchange-scraper/problem
 * @author Hasol
 */
public class StackExchange {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String reg = "class=\"summary\".*?href=\"/questions/(\\d+).*?class=\"question-hyperlink\">(.*?)<.*?class=\"relativetime\">(.*?)<";
        while (scan.hasNextLine()) {
            sb.append(scan.nextLine());
            sb.append("\n");
        }
        Matcher m = Pattern.compile(reg, Pattern.MULTILINE+Pattern.DOTALL).matcher(sb);
        while (m.find())
            System.out.println(m.group(1) + ";" + m.group(2) + ";" + m.group(3));
    }
}
