package Java.Introduction;
import java.util.*;
import java.io.*;
/**
 * HackerRank Java Introduction 7
 * https://www.hackerrank.com/challenges/java-loops/problem
 * @author Hasol
 */
public class Loop2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i=0; i<t; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            for (int j=0; j<n; j++) {
                long z = Math.round(Math.pow(2, j+1) - 1);
                System.out.print (z * b + a);
                System.out.print (j == n-1 ? "\n" : " ");
            }
        }
        in.close();
    }
}
