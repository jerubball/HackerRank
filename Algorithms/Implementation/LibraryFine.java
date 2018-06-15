package Algorithms.Implementation;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * HackerRank Algorithms Implementation 33
 * https://www.hackerrank.com/challenges/library-fine/problem
 * @author Hasol
 */
public class LibraryFine {
    // Complete the libraryFine function below.
    static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {
        int d = d1-d2, m = m1-m2, y = y1-y2;
        return y>0 ? 10000 : y<0 ? 0 : m>0 ? 500*m : m<0 ? 0 : d>0 ? 15*d : 0;
    }
    static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String[] d1m1y1 = scanner.nextLine().split(" ");
        int d1 = Integer.parseInt(d1m1y1[0]);
        int m1 = Integer.parseInt(d1m1y1[1]);
        int y1 = Integer.parseInt(d1m1y1[2]);
        String[] d2m2y2 = scanner.nextLine().split(" ");
        int d2 = Integer.parseInt(d2m2y2[0]);
        int m2 = Integer.parseInt(d2m2y2[1]);
        int y2 = Integer.parseInt(d2m2y2[2]);
        int result = libraryFine(d1, m1, y1, d2, m2, y2);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }
}
