package Java.DataStructures;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/**
 * HackerRank Java DataStructures 9
 * https://www.hackerrank.com/challenges/java-hashset/problem
 * @author Hasol
 */
public class UniquePair {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        String[] pairLeft = new String[t];
        String[] pairRight = new String[t];
        for (int i = 0; i < t; i++) {
            pairLeft[i] = scan.next();
            pairRight[i] = scan.next();
        }
        HashSet<StringPair> set = new HashSet<>();
        for (int i=0; i<t; i++) {
            set.add(new StringPair(pairLeft[i], pairRight[i]));
            System.out.println(set.size());
        }
        scan.close();
    }
}
class StringPair {
    String a, b;
    public StringPair(String _a, String _b) {
        a = _a;
        b = _b;
    }
    @Override
    public boolean equals(Object o) {
        if (o != null && o instanceof StringPair) {
            StringPair p = (StringPair)o;
            return this.a.equals(p.a) && this.b.equals(p.b);
        } else
            return false;
    }
    @Override
    public int hashCode() {
        return new String(a.hashCode() + " " + b.hashCode()).hashCode();
    }
}
