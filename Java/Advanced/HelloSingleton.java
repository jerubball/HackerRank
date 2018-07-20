package Java.Advanced;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.lang.reflect.*;
/**
 * HackerRank Java Advanced 6
 * https://www.hackerrank.com/challenges/java-singleton/problem
 * @author Hasol
 */
public class HelloSingleton {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String message = scan.nextLine();
        scan.close();
        Singleton s1 = Singleton.getSingleInstance();
        Singleton s2 = Singleton.getSingleInstance();
        assert s1 == s2;
        s1.str = "Hello I am a singleton! ";
        s2.str = s2.str + "Let me say " + message + " to you";
        System.out.println(s1.str);
    }
}
class Singleton {
    public String str;
    private static Singleton instance = new Singleton();
    private Singleton() {
    }
    static Singleton getSingleInstance() {
        return instance;
    }
}
