package Java.BigNumber;
import java.math.BigDecimal;
import java.util.*;
/**
 * HackerRank Java BigNumber 1
 * https://www.hackerrank.com/challenges/java-bigdecimal/problem
 * @author Hasol
 */
public class BigDecimalSort {
    static String[] sortPair (String[] s) {
        int n = s.length();
        MyPair[] p = new MyPair[n];
        String[] a = new String[n];
        for (int i=0; i<n; i++)
            p[i] = new MyPair(new BigDecimal(s[i]), s[i]);
        // Java Arrays TimSort is stable.
        Arrays.sort(p);
        for (int i=0; i<n; i++)
            a[i] = p[i].toString();
    }
    public static void main(String[] args) {
        //Input
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] s = new String[n];
        for(int i=0 ; i<n; i++)
            s[i] = sc.next();
        sc.close();
        //Write your code here
        s = sortPair(s);
        //Arrays.sort(s, new AlternateComparator());
        //Output
        for(int i=0; i<n; i++)
            System.out.println(s[i]);
    }
}
class MyPair implements Comparable<MyPair> {
    private BigDecimal d;
    private String s;
    public MyPair(BigDecimal _d, String _s) {
        this.d = _d;
        this.s = _s;
    }
    @Override
    public int compareTo(MyPair o) {
        // reversed compareTo for descending order.
        return o.d.compareTo(this.d);
    }
    public String toString() {
        return s;
    }
}
class AlternateComparator extends Comparator<String> {
    @Override
    public int compare(String a1, String a2) {
        //convert to big decimal inside comparator, so permanent string values are never changed
        //aka you only use the BigDecimal values to compare the strings!
        BigDecimal a = new BigDecimal(a1);
        BigDecimal b = new BigDecimal(a2);
        //reverse order
        return b.compareTo(a);
    }
}
