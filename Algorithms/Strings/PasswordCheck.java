package Algorithms.Strings;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * HackerRank Algorithms Strings 3
 * https://www.hackerrank.com/challenges/strong-password/problem
 * @author Hasol
 */
public class PasswordCheck {
    // Complete the minimumNumber function below.
    static int minimumNumber(int n, String password) {
        // Return the minimum number of characters to make the password strong
        int count = 0;
        if (!password.matches("^.*\\d.*$"))
            count++;
        if (!password.matches("^.*[A-Z].*$"))
            count++;
        if (!password.matches("^.*[a-z].*$"))
            count++;
        if (!password.matches("^.*[-!@#$%&*()+^].*$"))
            count++;
        return n >= 6 || 6 - n <= count ? count : 6 - n;
    }
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        String password = scanner.nextLine();
        int answer = minimumNumber(n, password);
        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }
}
