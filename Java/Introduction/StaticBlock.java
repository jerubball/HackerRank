package Java.Introduction;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/**
 * HackerRank Java Introduction 10
 * https://www.hackerrank.com/challenges/java-static-initializer-block/problem
 * @author Hasol
 */
public class StaticBlock {
    static boolean flag;
    static int b, h;
    static Scanner s;
    static {
        s = new Scanner(System.in);
        b = s.nextInt();
        h = s.nextInt();
        s.close();
        if (!(flag = b > 0 && h > 0))
            System.out.println("java.lang.Exception: breadth and height must be positive");
    }
    public static void main(String[] args) {
        if (flag) {
            int area = b * h;
            System.out.println(area);
        }
    }
}
