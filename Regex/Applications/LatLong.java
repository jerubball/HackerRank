package Regex.Applications;
import java.io.*;
import java.util.*;
/**
 * HackerRank Regex Applications 10
 * https://www.hackerrank.com/challenges/detecting-valid-latitude-and-longitude/problem
 * @author Hasol
 */
public class LatLong {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        String reg = "\\([+-]?(90(\\.0+)?|[1-8]?\\d(\\.\\d+)?), [+-]?(180(\\.0+)?|(1[0-7]|[1-9])?\\d(\\.\\d+)?)\\)";
        while (scan.hasNextLine())
            System.out.println(scan.nextLine().matches(reg) ? "Valid" : "Invalid");
    }
}
