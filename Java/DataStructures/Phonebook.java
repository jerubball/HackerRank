package Java.DataStructures;
import java.util.*;
import java.io.*;
/**
 * HackerRank Java DataStructures 7
 * https://www.hackerrank.com/challenges/phone-book/problem
 * @author Hasol
 */
public class Phonebook {
    static String query(HashMap<String, String> m, String k) {
        String v = m.get(k);
        return v == null ? "Not found" : k + "=" + v;
    }
    public static void main(String[] arg) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        HashMap<String, String> map = new HashMap();
        for (int i=0; i<n; i++)
            map.putIfAbsent(scan.nextLine(), scan.nextLine());
        while (scan.hasNextLine())
            System.out.println(query(map, scan.nextLine()));
        scan.close();
    }
}
