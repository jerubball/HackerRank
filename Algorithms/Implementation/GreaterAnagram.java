package Algorithms.Implementation;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * HackerRank Algorithms Implementation 
 * https://www.hackerrank.com/challenges/bigger-is-greater/problem
 * @author Hasol
 */
public class GreaterAnagram {
    // Complete the biggerIsGreater function below.
    static String biggerIsGreater(String w) {
        char c;
        for (int i=w.length()-1; i>0; i--)
            // start from the end of string
            if (w.charAt(i) > (c = w.charAt(i-1)))
                // determine lower character
                for (int j=w.length()-1; j>=i; j--)
                    if (c < w.charAt(j)) {
                        // look for higher character that can be swapped
                        StringBuilder s = new StringBuilder(w);
                        s.setCharAt(j, c);
                        s.setCharAt(i-1, w.charAt(j));
                        StringBuilder r = new StringBuilder(s.substring(i));
                        s.delete(i, w.length());
                        s.append(r.reverse());
                        return s.toString();
                    }
        return "no answer";
    }
    static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int T = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int TItr=0; TItr<T; TItr++) {
            String w = scanner.nextLine();
            String result = biggerIsGreater(w);
            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
        scanner.close();
    }
}
