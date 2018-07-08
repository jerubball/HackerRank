package Algorithms.Implementation;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * HackerRank Algorithms Implementation 57
 * https://www.hackerrank.com/challenges/the-grid-search/problem
 * @author Hasol
 */
public class GridTextSearch {
    // Complete the gridSearch function below.
    static String gridSearch(String[] g, String[] p) {
        int l = g.length -p.length +1, k = -1;
        for (int i=0; i<l; i++)
            while ((k = g[i].indexOf(p[0], k+1)) != -1) {
                boolean t = true;
                for (int j=0; t && j<p.length; j++)
                    t = g[i+j].indexOf(p[j], k) == k ? t : false;
                if (t)
                    return "YES";
            }
        return "NO";
    }
    static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int tItr=0; tItr<t; tItr++) {
            String[] grc = scanner.nextLine().split(" ");
            int gr = Integer.parseInt(grc[0]);
            int gc = Integer.parseInt(grc[1]);
            String[] g = new String[gr];
            for (int i=0; i<gr; i++)
                g[i] = scanner.nextLine();
            String[] prc = scanner.nextLine().split(" ");
            int pr = Integer.parseInt(prc[0]);
            int pc = Integer.parseInt(prc[1]);
            String[] p = new String[pr];
            for (int i=0; i<pr; i++) 
                p[i] = scanner.nextLine();
            String result = gridSearch(g, p);
            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
        scanner.close();
    }
}
