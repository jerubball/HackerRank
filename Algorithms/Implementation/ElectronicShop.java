package Algorithms.Implementation;
import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
/**
 * HackerRank Algorithms Implementation 14
 * https://www.hackerrank.com/challenges/electronics-shop/problem
 * @author Hasol
 */
public class ElectronicShop {
    //Complete the getMoneySpent function below.
    static int getMoneySpent(int[] keyboards, int[] drives, int b) {
        int z = -1, t;
        for (int k: keyboards)
            for (int d: drives)
                z = b >= (t = k+d) && t > z ? t : z;
        return z;
    }
    static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String[] bnm = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");
        int b = Integer.parseInt(bnm[0]);
        int n = Integer.parseInt(bnm[1]);
        int m = Integer.parseInt(bnm[2]);
        int[] keyboards = new int[n];
        String[] keyboardsItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");
        for (int keyboardsItr=0; keyboardsItr<n; keyboardsItr++)
            keyboards[keyboardsItr] = Integer.parseInt(keyboardsItems[keyboardsItr]);
        int[] drives = new int[m];
        String[] drivesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");
        for (int drivesItr=0; drivesItr<m; drivesItr++)
            drives[drivesItr] = Integer.parseInt(drivesItems[drivesItr]);
        //The maximum amount of money she can spend on a keyboard and USB drive, or -1 if she can't purchase both items
        int moneySpent = getMoneySpent(keyboards, drives, b);
        bufferedWriter.write(String.valueOf(moneySpent));
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }
}
