package Java.ObjectOrientedProgramming;
import java.util.*;
/**
 * HackerRank Java ObjectOrientedProgramming 3
 * https://www.hackerrank.com/challenges/java-abstract-class/problem
 * @author Hasol
 */
public class AbstractBook {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String title = sc.nextLine();
        Book newNovel = new MyBook();
        newNovel.setTitle(title);
        System.out.println("The title is: " + newNovel.getTitle());
        sc.close();
    }
}
abstract class Book {
    String title;
    abstract void setTitle(String s);
    String getTitle() {
        return title;
    }
}
class MyBook extends Book {
    void setTitle(String s) {
        title = s;
    }
}
