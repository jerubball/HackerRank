package Algorithms.Warmup;
import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
/**
 * HackerRank Algorithms Warmup 10
 * https://www.hackerrank.com/challenges/time-conversion/problem
 * @author Hasol
 */
public class TimeConvert {
    // Complete the timeConversion function below.
    static String timeConversion(String s) {
        char a = s.charAt(s.length()-2);
        int h = Integer.parseInt(s.substring(0, 2)) % 12;
        String t = s.substring(2, s.length()-2);
        DecimalFormat f = new DecimalFormat("00");
        return a == 'A' ? f.format(h) + t : f.format(h + 12) + t;
    }
    static final Scanner scan = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String s = scan.nextLine();
        String result = timeConversion(s);
        bw.write(result);
        bw.newLine();
        bw.close();
    }
}
