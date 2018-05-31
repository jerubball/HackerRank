import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution{
    static void validateTag (String line, boolean skip) {
        // stack to keep track of nested tags
        Stack<String> stack = new Stack<> ();
        Pattern ptag = Pattern.compile ("<(/?[^<>/]+)>");
        
        int index = 0;
        boolean found = false, valid = true, print = false;
        StringBuilder output = new StringBuilder();
        String word;
        
        Matcher mtag = ptag.matcher(line);
        while (mtag.find()) {
            // get name of tag
            String tag = mtag.group(1);
            if (tag.charAt(0) != '/') {
                // this is start tag
                stack.push(tag);
                if (!skip && index < mtag.start()) {
                    word = line.substring(index, mtag.start());
                    if (!word.matches(".*[<>].*")) {
                        // no invalid tag start/end
                        output.append(word);
                        output.append("\n");
                    } else {
                        valid = false;
                    }
                }
                index = mtag.end();
            } else {
                // this is end tag
                if (tag.substring(1).equals(stack.pop())) {
                    // end tag is valid
                    if ((!skip || !found) && index < mtag.start()) {
                        word = line.substring(index, mtag.start());
                        if (!word.matches(".*[<>].*")) {
                            // no invalid tag start/end
                            output.append(word);
                            output.append("\n");
                        } else {
                            valid = false;
                        }
                    }
                    found = true;
                } else {
                    // end tag is invalid
                    valid = false;
                }
                index = mtag.end();
            }
            if (stack.isEmpty()) {
                // reached last level
                if (valid && found && output.length() > 0) {
                    System.out.print (output);
                    print = true;
                }
                // reset for next levels
                found = false;
                valid = true;
                output = new StringBuilder();
            }
        }
        if (index < line.length() && (!skip || !print)) {
            // handle no presence of tags
            word = line.substring(index);
            if (!word.matches(".*[<>].*")) {
                // no invalid tag start/end
                System.out.println (word);
                print = true;
            }
        }
        if (!print) {
            // handle no match from this line
            System.out.println ("None");
        }
    }
    
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		while(testCases-- > 0){
            //validateTag (in.nextLine(), true);
            // /*
			String line = in.nextLine();
          	//Write your code here
			boolean matchFound = false;
            Pattern r = Pattern.compile("<(.+)>([^<]+)</\\1>");
            Matcher m = r.matcher(line);

            while (m.find()) {
                System.out.println(m.group(2));
                matchFound = true;
            }
            if ( ! matchFound) {
                System.out.println("None");
            }
            // */
		}
	}
}



