package Algorithms.Strings;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
/**
 * HackerRank Algorithms Strings 1
 * https://www.hackerrank.com/challenges/reduced-string/problem
 * @author Hasol
 */
public class SuperReducedString {
    // Complete the superReducedString function below.
    static String superReducedString(String s) {
        int prevlength;
        do {
            prevlength = s.length();
            s = s.replaceAll("(\\w)\\1", "");
        } while (prevlength != s.length());
        if (s.isEmpty())
            return "Empty String";
        return s;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String s = bufferedReader.readLine();
        String result = superReducedString(s);
        bufferedWriter.write(result);
        bufferedWriter.newLine();
        bufferedReader.close();
        bufferedWriter.close();
    }
}
