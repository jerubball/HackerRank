package Algorithms.Implementation;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * HackerRank Algorithms Implementation 20
 * https://www.hackerrank.com/challenges/designer-pdf-viewer/problem
 * @author Hasol
 */
public class HighlightText {
    // Complete the designerPdfViewer function below.
    static int designerPdfViewer(int[] h, String word) {
        char[] c = word.toCharArray();
        int a = 0;
        for (char d: c)
            a = a < h[d-'a'] ? h[d-'a'] : a;
        return a * c.length;
    }
    static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int[] h = new int[26];
        String[] hItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int i=0; i<26; i++)
            h[i] = Integer.parseInt(hItems[i]);
        String word = scanner.nextLine();
        int result = designerPdfViewer(h, word);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }
}
