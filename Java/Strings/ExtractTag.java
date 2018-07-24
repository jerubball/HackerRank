package Java.Strings;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/**
 * HackerRank Java Strings 11
 * https://www.hackerrank.com/challenges/tag-content-extractor/problem
 * @author Hasol
 */
public class ExtractTag {
    static void validateTag(String line, boolean skip) {
        // stack to keep track of nested tags
        Stack<String> stack = new Stack<>();
        Pattern ptag = Pattern.compile("<(/?[^<>/]+)>");
        // initialize variables
        int index = 0;
        boolean found = false, valid = true, print = false;
        StringBuilder output = new StringBuilder();
        String word, brackets = ".*[<>].*";
        // perform tag match
        Matcher mtag = ptag.matcher(line);
        while (mtag.find()) {
            // get name of tag
            String tag = mtag.group(1);
            if (tag.charAt(0) != '/') {
                // this is start tag
                stack.push(tag);
                if (!skip && index < mtag.start()) {
                    word = line.substring(index, mtag.start());
                    if (!word.matches(brackets))
                        // no invalid tag start/end
                        output.append(word + "\n");
                    else
                        valid = false;
                }
                index = mtag.end();
            } else {
                // this is end tag
                if (tag.substring(1).equals(stack.pop())) {
                    // end tag is valid
                    if ((!skip || !found) && index < mtag.start()) {
                        word = line.substring(index, mtag.start());
                        if (!word.matches(brackets))
                            // no invalid tag start/end
                            output.append(word + "\n");
                        else
                            valid = false;
                    }
                    found = true;
                } else
                    // end tag is invalid
                    valid = false;
                index = mtag.end();
            }
            if (stack.isEmpty()) {
                // reached last level
                if (valid && found && output.length() > 0 && (print = true))
                    System.out.print (output);
                // reset for next levels
                found = false;
                valid = true;
                output = new StringBuilder();
            }
        }
        if (index < line.length() && (!skip || !print)) {
            // handle no presence of tags
            word = line.substring(index);
            if (!word.matches(brackets) && (print = true))
                // no invalid tag start/end
                System.out.println (word);
        }
        if (!print)
            // handle no match from this line
            System.out.println ("None");
    }
    static void alternateSolution(String line) {
        boolean matchFound = false;
        Pattern r = Pattern.compile("<(.+)>([^<]+)</\\1>");
        Matcher m = r.matcher(line);
        while (m.find() && (matchFound = true))
            System.out.println(m.group(2));
        if (!matchFound)
            System.out.println("None");
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while(testCases-- > 0) {
            //Write your code here
            validateTag(in.nextLine(), true);
            //alternateSolution(in.nextLine());
        }
    }
}
