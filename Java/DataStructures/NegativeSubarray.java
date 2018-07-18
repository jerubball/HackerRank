package Java.DataStructures;
import java.io.*;
import java.util.*;
/**
 * HackerRank Java DataStructures 3
 * https://www.hackerrank.com/challenges/java-negative-subarray/problem
 * @author Hasol
 */
public class NegativeSubarray {
    static int negativeSubarray(int[] a) {
        int s = 0;
        for (int i=0, c=0; i<a.length; i++, c=0)
            for (int j=i; j<a.length; j++)
                if ((c += a[j]) < 0)
                    s++;
        return s;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int[] num = new int[n];
        String[] line = scan.nextLine().split(" ");
        for (int i=0; i<n; i++)
            num[i] = Integer.parseInt(line[i]);
        scan.close();
        int s = negativeSubarray(num);
        System.out.println(s);
    }
}
