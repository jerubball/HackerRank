package Algorithms.Implementation;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * HackerRank Algorithms Implementation 46
 * https://www.hackerrank.com/challenges/beautiful-triplets/problem
 * @author Hasol
 */
public class BeautifulTriplet {
    // Complete the beautifulTriplets function below.
    static int beautifulTriplets(int d, int[] arr) {
        int[] diff = new int[arr.length-1];
        for (int i=0; i<diff.length; i++)
            // compute difference of adjacent element
            diff[i] = arr[i+1] - arr[i];
        int c = 0, i = 0, j, k, ij = 0, jk = 0;
        for (j=1, k=1; j<diff.length; j++) {
            // add next i-j difference;
            ij += diff[j-1];
            while (ij>d && i<diff.length)
                // increase i until i-j difference is below or equal to given
                ij -= diff[i++];
            while (jk<d && k<diff.length)
                // increase k until j-k difference is above or equal to given
                jk += diff[k++];
            if (ij == d && jk == d)
                c++;
            // subtract this j-k difference
            jk -= diff[j];
        }
        return c;
    }
    static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String[] nd = scanner.nextLine().split(" ");
        int n = Integer.parseInt(nd[0]);
        int d = Integer.parseInt(nd[1]);
        int[] arr = new int[n];
        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int i=0; i<n; i++)
            arr[i] = Integer.parseInt(arrItems[i]);
        int result = beautifulTriplets(d, arr);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }
}
