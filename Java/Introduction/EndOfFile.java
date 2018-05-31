package Java.Introduction;
import java.io.*;
import java.util.*;
/**
 * HackerRank Java Introduction 9
 * https://www.hackerrank.com/challenges/java-end-of-file/problem
 * @author Hasol
 */
public class EndOfFile {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int i = 0;
        while (s.hasNextLine())
            System.out.println(++i + " " + s.nextLine());
        s.close();
    }
}
