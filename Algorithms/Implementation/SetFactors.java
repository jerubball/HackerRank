package Algorithms.Implementation;
import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
/**
 * HackerRank Algorithms Implementation 4
 * https://www.hackerrank.com/challenges/between-two-sets/problem
 * @author Hasol
 */
public class SetFactors {
    //Complete the getTotalX function below.
    static int getTotalX(int[] a, int[] b) {
        long x = a[0];
        for (int i=1; i<a.length; i++)
            x = lcm (x, a[i]);
        long y = b[0];
        for (int j=1; j<b.length; j++)
            y = gcd (y, b[j]);
        if (y % x != 0)
            return 0;
        else
            return numFactors (y / x);
    }
    static long gcd (long a, long b) {
        return a < b ? gcd (b, a) : b != 0 ? gcd (b, a % b) : a;
    }
    static long lcm (long a, long b) {
        return a / gcd (a, b) * b;
    }
    static int numFactors (long a) {
        int c = 1;
        for (long i=1; i<a; i++)
            if (a % i == 0)
                c++;
        return c;
    }
    static final Scanner scan = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String[] nm = scan.nextLine().split(" ");
        int n = Integer.parseInt(nm[0].trim());
        int m = Integer.parseInt(nm[1].trim());
        int[] a = new int[n];
        String[] aItems = scan.nextLine().split(" ");
        for (int aItr=0; aItr<n; aItr++)
            a[aItr] = Integer.parseInt(aItems[aItr].trim());
        int[] b = new int[m];
        String[] bItems = scan.nextLine().split(" ");
        for (int bItr=0; bItr<m; bItr++)
            b[bItr] = Integer.parseInt(bItems[bItr].trim());
        int total = getTotalX(a, b);
        bw.write(String.valueOf(total));
        bw.newLine();
        bw.close();
    }
}
