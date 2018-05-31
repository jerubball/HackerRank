package Java.Strings;
import java.util.Scanner;
import java.util.regex.*;
/**
 * HackerRank Java Strings 9
 * https://www.hackerrank.com/challenges/duplicate-word/problem
 * @author Hasol
 */
public class DuplicateWords {
    public static void main(String[] args) {
        String regex = "(\\b\\w+)(\\h\\1\\b)+";
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Scanner in = new Scanner(System.in);
        int numSentences = Integer.parseInt(in.nextLine());
        while (numSentences-- > 0) {
            String input = in.nextLine();
            Matcher m = p.matcher(input);
            // Check for subsequences of input that match the compiled pattern
            while (m.find())
                input = input.replaceAll(m.group(), m.group(1));
            // Prints the modified sentence.
            System.out.println(input);
        }
        in.close();
    }
}
