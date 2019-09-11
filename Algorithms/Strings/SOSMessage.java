package Algorithms.Strings;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * HackerRank Algorithms Strings 6
 * https://www.hackerrank.com/challenges/mars-exploration/problem
 * @author Hasol
 */
public class SOSMessage {
    // Complete the marsExploration function below.
    static int marsExploration(String s) {
        int count = 0;
        for (int i=0; i<s.length(); i++)
            if ((i%3 == 1 && s.charAt(i) != 'O') || (i%3 != 1 && s.charAt(i) != 'S'))
                count++;
        return count;
    }
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String s = scanner.nextLine();
        int result = marsExploration(s);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }
}
