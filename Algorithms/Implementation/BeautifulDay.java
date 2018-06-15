package Algorithms.Implementation;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * HackerRank Algorithms Implementation 23
 * https://www.hackerrank.com/challenges/beautiful-days-at-the-movies/problem
 * @author Hasol
 */
public class BeautifulDay {
    // Complete the beautifulDays function below.
    static int beautifulDays(int i, int j, int k) {
        int c = 0;
        for (int a=i; a<=j; a++) {
            String b = new StringBuilder(Integer.toString(a)).reverse().toString();
            int d = Math.abs(a - Integer.parseInt(b));
            c = d%k == 0 ? c+1 : c;
        }
        return c;
    }
    static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String[] ijk = scanner.nextLine().split(" ");
        int i = Integer.parseInt(ijk[0]);
        int j = Integer.parseInt(ijk[1]);
        int k = Integer.parseInt(ijk[2]);
        int result = beautifulDays(i, j, k);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }
}
