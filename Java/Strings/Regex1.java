package Java.Strings;
import java.util.Scanner;
import java.util.regex.*;
/**
 * HackerRank Java Strings 8
 * https://www.hackerrank.com/challenges/java-regex/problem
 * @author Hasol
 */
public class Regex1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String IP = in.next();
            System.out.println(IP.matches(MyRegex.pattern));
        }
    }
}
//Write your code here
class MyRegex {
    static String pattern = "(" + number + "[.]){3}" + number;
    final static String number = "(([01]?\\d|2[0-4])?\\d|25[0-5])";
}
