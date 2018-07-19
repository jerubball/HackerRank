package Java.DataStructures;
import java.io.*;
import java.util.*;
/**
 * HackerRank Java DataStructures 6
 * https://www.hackerrank.com/challenges/java-list/problem
 * @author Hasol
 */
public class ListOperation {
    static void query(ArrayList<Integer> l, String... q) {
        q[0] = q[0].toUpperCase();
        String[] arg = q[1].split(" ");
        int[] a = new int[arg.length];
        for (int i=0; i<arg.length; i++)
            a[i] = Integer.parseInt(arg[i]);
        switch(q[0]) {
            case "INSERT":
                l.add(a[0], a[1]);
                break;
            case "DELETE":
                l.remove(a[0]);
                break;
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        ArrayList<Integer> list = new ArrayList<>();
        String[] line = scan.nextLine().split(" ");
        for (int i=0; i<n; i++)
            list.add(Integer.parseInt(line[i]));
        int q = Integer.parseInt(scan.nextLine());
        for (int i=0; i<q; i++)
            query(list, scan.nextLine(), scan.nextLine());
        for (int i=0; i<list.size(); i++) {
            System.out.print(list.get(i));
            if (i != list.size()-1)
                System.out.print(" ");
        }
        scan.close();
    }
}
