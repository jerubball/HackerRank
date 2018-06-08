package Algorithms.Implementation;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * HackerRank Algorithms Implementation 18
 * https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem
 * @author Hasol
 */
public class Leaderboard {
    // Complete the climbingLeaderboard function below.
    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        int[] r = new int[scores.length];
        int t = 0;
        r[t++] = scores[0];
        for (int s: scores)
            if (s != r[t-1])
                r[t++] = s;
        int[] a = new int[alice.length];
        int c = t;
        for (int i=0; i<a.length; i++) {
            while (c > 0 && alice[i] >= r[c-1])
                c--;
            a[i] = c+1;
        }
        return a;
    }
    static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int scoresCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int[] scores = new int[scoresCount];
        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int i=0; i<scoresCount; i++)
            scores[i] = Integer.parseInt(scoresItems[i]);
        int aliceCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int[] alice = new int[aliceCount];
        String[] aliceItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int i=0; i<aliceCount; i++)
            alice[i] = Integer.parseInt(aliceItems[i]);
        int[] result = climbingLeaderboard(scores, alice);
        for (int i=0; i<result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));
            if (i != result.length-1)
                bufferedWriter.write("\n");
        }
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }
}
