package Java.DataStructures;
import java.util.*;
/**
 * HackerRank Java DataStructures 8
 * https://www.hackerrank.com/challenges/java-stack/problem
 * @author Hasol
 */
public class BalancedParentheses {
    static boolean isBalanced(String l) {
        Stack<Character> s = new Stack<>();
        char d;
        for (char c: l.toCharArray())
            if (c == '(' || c == '[' || c == '{' || c == '<')
                s.push(c);
            else if (c == ')' || c == ']' || c == '}' || c == '>')
                if (s.isEmpty() || ((d = s.pop())+1 != c && d+2 != c))
                    return false;
        return s.isEmpty();
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine())
            System.out.println(isBalanced(scan.nextLine()));
        scan.close();
    }
}
