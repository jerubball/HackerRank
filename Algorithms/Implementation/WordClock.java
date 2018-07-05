package Algorithms.Implementation;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * HackerRank Algorithms Implementation 49
 * https://www.hackerrank.com/challenges/the-time-in-words/problem
 * @author Hasol
 */
public class WordClock {
    // Complete the timeInWords function below.
    static String timeInWords(int h, int m) {
        String c = " past ";
        if (m == 0)
            return hourString(h) + " o' clock";
        else if (m > 30) {
            c = " to ";
            h = h == 12 ? 1 : h+1;
            m = 60 - m;
        }
        return minuteString(m) + c + hourString(h);
    }
    static String hourString(int h) {
        switch (h) {
            case 1:
                return "one";
            case 2:
                return "two";
            case 3:
                return "three";
            case 4:
                return "four";
            case 5:
                return "five";
            case 6:
                return "six";
            case 7:
                return "seven";
            case 8:
                return "eight";
            case 9:
                return "nine";
            case 10:
                return "ten";
            case 11:
                return "eleven";
            case 12:
                return "twelve";
            default:
                return "";
        }
    }
    static String minuteString(int m) {
        String s = "";
        if (m == 30)
            s = "half";
        else if (m == 15)
            s = "quarter";
        else if (m == 1)
            s = "one minute";
        else {
            if (m <= 12)
                s += hourString(m);
            else if (m < 20) {
                if (m == 13)
                    s += "thir";
                else if (m == 18)
                    s += "eigh";
                else
                    s += hourString(m);
                s += "teen";
            } else {
                s += "twenty";
                if (m > 20)
                    s += " " + hourString(m % 20);
            }
            s += " minutes";
        }
        return s;
    }
    static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int h = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        String result = timeInWords(h, m);
        bufferedWriter.write(result);
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }
}
