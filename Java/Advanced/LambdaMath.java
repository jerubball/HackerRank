import java.io.*;
import java.util.*;
import java.math.*;
package Java.Advanced;
/**
 * HackerRank Java Advanced 10
 * https://www.hackerrank.com/challenges/java-lambda-expressions/problem
 * @author Hasol
 */
public class LambdaMath {
    public static void main(String[] args) throws IOException {
        MyMath ob = new MyMath();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        PerformOperation op;
        boolean ret = false;
        String ans = null;
        while (t-- > 0) {
            String s = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(s);
            int ch = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if (ch == 1) {
                op = ob.isOdd();
                ret = ob.checker(op, num);
                ans = (ret) ? "ODD" : "EVEN";
            } else if (ch == 2) {
                op = ob.isPrime();
                ret = ob.checker(op, num);
                ans = (ret) ? "PRIME" : "COMPOSITE";
            } else if (ch == 3) {
                op = ob.isPalindrome();
                ret = ob.checker(op, num);
                ans = (ret) ? "PALINDROME" : "NOT PALINDROME";
            }
            System.out.println(ans);
        }
    }
}
@FunctionalInterface
interface PerformOperation {
    boolean check(int a);
}
class MyMath {
    public static boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }
    public PerformOperation isOdd() {
        return a -> a%2 == 1;
    }
    public PerformOperation isPrime() {
        return a -> {
            String b = Integer.toString(a);
            return new java.math.BigInteger(b).isProbablePrime(b.length());
        };
    }
    public PerformOperation isPalindrome() {
        return a -> {
            String b = Integer.toString(a);
            return b.equals(new StringBuilder(b).reverse().toString());
        };
    }
}
