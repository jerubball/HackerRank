package Java.DataStructures;
import java.io.*;
import java.util.*;
/**
 * HackerRank Java DataStructures 4
 * https://www.hackerrank.com/challenges/java-arraylist/problem
 * @author Hasol
 */
public class ArrayLookup {
    static String[] lookup(String[] n, String[] q) {
        ArrayList<ArrayList<Integer>> m = new ArrayList<>();
        for (String l: n) {
            ArrayList<Integer> o = new ArrayList<>();
            String[] p = l.split(" ");
            for (String k: p)
                o.add(Integer.parseInt(k));
            o.remove(0);
            m.add(o);
        }
        ArrayList<String> r = new ArrayList();
        for (String t: q) {
            String[] u = t.split(" ");
            int[] v = new int[u.length];
            for (int i=0; i<u.length; i++)
                v[i] = Integer.parseInt(u[i])-1;
            try {
                r.add(m.get(v[0]).get(v[1]).toString());
            } catch (IndexOutOfBoundsException e) {
                r.add("ERROR!");
            }
        }
        return r.toArray(new String[r.size()]);
    }
    static String[] alternate(String[] n, String[] q) {
        int[][] m = new int[n.length][];
        for (int i=0; i<n.length; i++) {
            String[] p = n[i].split(" ");
            m[i] = new int[Integer.parseInt(p[0])];
            for (int j=0; j<m[i].length; j++)
                m[i][j] = Integer.parseInt(p[j+1]);
        }
        String[] r = new String[q.length];
        for (int i=0; i<q.length; i++) {
            String[] u = q[i].split(" ");
            int[] v = new int[u.length];
            for (int j=0; j<u.length; j++)
                v[j] = Integer.parseInt(u[j])-1;
            try {
                r[i] = Integer.toString(m[v[0]][v[1]]);
            } catch (IndexOutOfBoundsException e) {
                r[i] = "ERROR!";
            }
        }
        return r;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        String[] line = new String[n];
        for (int i=0; i<n; i++)
            line[i] = scan.nextLine();
        int q = Integer.parseInt(scan.nextLine());
        String[] query = new String[q];
        for (int i=0; i<q; i++)
            query[i] = scan.nextLine();
        scan.close();
        String[] r = lookup(line, query);
        for (int i=0; i<r.length; i++)
            System.out.println(r[i]);
    }
}
