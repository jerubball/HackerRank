package Algorithms.Implementation;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * HackerRank Algorithms Implementation 41
 * https://www.hackerrank.com/challenges/taum-and-bday/problem
 * @author Hasol
 */
public class BirthdayGift {
    // Complete the taumBday function below.
    static long taumBday(int b, int w, int bc, int wc, int z) {
        long nbc = wc+z < bc ? wc+z : bc;
        long nwc = bc+z < wc ? bc+z : wc;
        return b * nbc + w * nwc;
    }
    static long alternate(int b, int w, int bc, int wc, int z) {
        return b * Math.min((long)wc+z, bc) + w * Math.min((long)bc+z, wc);
    }
    static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int tItr=0; tItr<t; tItr++) {
            String[] bw = scanner.nextLine().split(" ");
            int b = Integer.parseInt(bw[0]);
            int w = Integer.parseInt(bw[1]);
            String[] bcWcz = scanner.nextLine().split(" ");
            int bc = Integer.parseInt(bcWcz[0]);
            int wc = Integer.parseInt(bcWcz[1]);
            int z = Integer.parseInt(bcWcz[2]);
            long result = taumBday(b, w, bc, wc, z);
            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
        scanner.close();
    }
}
