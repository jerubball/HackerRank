package Java.Introduction;
import java.util.*;
/**
 * HackerRank Java Introduction 2
 * https://www.hackerrank.com/challenges/java-stdin-and-stdout-1/problem
 * @author Hasol
 */
public class StandardStream1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        for (int i=0; i<3; i++)
            System.out.println(scan.nextInt());
    }
}
