package Java.DataStructures;
import java.io.*;
import java.util.*;
/**
 * HackerRank Java DataStructures 14
 * https://www.hackerrank.com/challenges/java-bitset/problem
 * @author Hasol
 */
public class BitSet {
    static String query(BitSet[] s, String... q) {
        q[0] = q[0].toUpperCase();
        int[] arg = new int[q.length-1];
        for (int i=1; i<q.length; i++)
            arg[i-1] = Integer.parseInt(q[i])-1;
        switch (q[0]) {
            case "AND":
                s[arg[0]].and(s[arg[1]]);
                break;
            case "ANDNOT":
                s[arg[0]].andNot(s[arg[1]]);
                break;
            case "OR":
                s[arg[0]].or(s[arg[1]]);
                break;
            case "XOR":
                s[arg[0]].xor(s[arg[1]]);
                break;
            case "SET":
                s[arg[0]].set(arg[1]+1);
                break;
            case "CLEAR":
                s[arg[0]].clear(arg[1]+1);
                break;
            case "FLIP":
                s[arg[0]].flip(arg[1]+1);
                break;
        }
        return s[0].cardinality() + " " + s[1].cardinality();
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] nm = scan.nextLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        BitSet[] set = new BitSet[2];
        set[0] = new BitSet(n);
        set[1] = new BitSet(n);
        for (int i=0; i<m; i++)
            System.out.println(query(set, scan.nextLine().split(" ")));
        scan.close();
    }
}
