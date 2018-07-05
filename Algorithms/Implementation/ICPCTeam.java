package Algorithms.Implementation;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * HackerRank Algorithms Implementation 40
 * https://www.hackerrank.com/challenges/acm-icpc-team/problem
 * @author Hasol
 */
public class ICPCTeam {
    // Complete the acmTeam function below.
    static int[] acmTeam(String[] topic) {
        int[] a = new int[2];
        for (int i=0; i<topic.length-1; i++) {
            // process selected item
            int b = 0;
            ArrayList<Integer> c = new ArrayList<>();
            for (int j=0; j<topic[i].length(); j++)
                if (topic[i].charAt(j) == '1')
                    b++;
                else
                    c.add(j);
            // process other item
            for (int j=i+1; j<topic.length; j++) {
                int d = 0;
                for (int k: c)
                    if (topic[j].charAt(k) == '1')
                        d++;
                if (b+d > a[0]) {
                    a[0] = b+d;
                    a[1] = 1;
                } else if (b+d == a[0])
                    a[1]++;
            }
        }
        return a;
    }
    static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String[] nm = scanner.nextLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        String[] topic = new String[n];
        for (int i=0; i<n; i++)
            topic[i] = scanner.nextLine();
        int[] result = acmTeam(topic);
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
