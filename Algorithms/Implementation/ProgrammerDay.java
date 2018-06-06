package Algorithms.Implementation;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * HackerRank Algorithms Implementation 9
 * https://www.hackerrank.com/challenges/day-of-the-programmer/problem
 * @author Hasol
 */
public class ProgrammerDay {
    // Complete the solve function below.
    static String solve(int year) {
        GregorianCalendar c = new GregorianCalendar();
        c.setGregorianChange(new Date(-1637193600000l));
        // This sets transition date to Feb 14, 1918
        c.set (Calendar.YEAR, year);
        c.set (Calendar.DAY_OF_YEAR, 256);
        DecimalFormat f = new DecimalFormat("00");
        return f.format(c.get(Calendar.DAY_OF_MONTH)) + "." + f.format(c.get(Calendar.MONTH) + 1) + "." + year;
    }
    static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int year = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        String result = solve(year);
        bufferedWriter.write(result);
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }
}
