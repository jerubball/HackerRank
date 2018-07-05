package Algorithms.Implementation;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * HackerRank Algorithms Implementation 48
 * https://www.hackerrank.com/challenges/halloween-sale/problem
 * @author Hasol
 */
public class HalloweenSale {
    // Complete the howManyGames function below.
    static int howManyGames(int p, int d, int m, int s) {
        // Return the number of games you can buy
        int c = 0;
        while ((s -= p) >= 0) {
            p = p-d > m ? p-d : m;
            c++;
        }
        return c;
    }
    static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String[] pdms = scanner.nextLine().split(" ");
        int p = Integer.parseInt(pdms[0]);
        int d = Integer.parseInt(pdms[1]);
        int m = Integer.parseInt(pdms[2]);
        int s = Integer.parseInt(pdms[3]);
        int answer = howManyGames(p, d, m, s);
        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }
}
