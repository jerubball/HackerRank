package Algorithms.Implementation;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * HackerRank Algorithms Implementation 43
 * https://www.hackerrank.com/challenges/encryption/problem
 * @author Hasol
 */
public class TextEncryption {
    // Complete the encryption function below.
    static String encryption(String s) {
        s = s.replaceAll("\\W", "");
        int a, b;
        double c = Math.sqrt(s.length()), d = c % 1;
        if (d == 0)
            a = b = (int)Math.floor(c);
        else if (d > 0.5)
            a = b = (int)Math.ceil(c);
        else {
            a = (int)Math.floor(c);
            b = (int)Math.ceil(c);
        }
        StringBuilder sb = new StringBuilder(s.length()+b);
        for (int i=0; i<b; i++) {
            int e;
            for (int j=0; j<a; j++)
                if ((e = j*b+i) < s.length())
                    sb.append(s.charAt(e));
            sb.append(' ');
        }
        return sb.toString();
    }
    static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String s = scanner.nextLine();
        String result = encryption(s);
        bufferedWriter.write(result);
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }
}
