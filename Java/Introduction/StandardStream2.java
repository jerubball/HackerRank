package Java.introduction;
import java.util.Scanner;
//import java.text.DecimalFormat;
/**
 * HackerRank Java Introduction 4
 * https://www.hackerrank.com/challenges/java-stdin-stdout/problem
 * @author Hasol
 */
public class StandardStream2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //scan.skip("(\\s|\\v|\\h)+");
        int i = scan.nextInt();
        scan.nextLine();
        double d = scan.nextDouble();
        scan.nextLine();
        String s = scan.nextLine();
        //DecimalFormat f = new DecimalFormat("0.0################");
        System.out.println("String: " + s);
        System.out.println("Double: " + d);
        System.out.println("Int: " + i);
    }
}
