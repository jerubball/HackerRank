package Java.ObjectOrientedProgramming;
import java.util.*;
/**
 * HackerRank Java ObjectOrientedProgramming 4
 * https://www.hackerrank.com/challenges/java-interface/problem
 * @author Hasol
 */
public class CalculatorInterface {
    public static void main(String[] args) {
        MyCalculator myCalculator = new MyCalculator();
        System.out.print("I implemented: ");
        ImplementedInterfaceNames(myCalculator);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(myCalculator.divisorSum(n) + "\n");
        sc.close();
    }
    // ImplementedInterfaceNames method takes an object and prints the name of the interfaces it implemented
    static void ImplementedInterfaceNames(Object o) {
        Class[] theInterfaces = o.getClass().getInterfaces();
        for (int i=0; i<theInterfaces.length; i++) {
            String interfaceName = theInterfaces[i].getName();
            System.out.println(interfaceName);
        }
    }
}
interface AdvancedArithmetic {
    int divisorSum(int n);
}
class MyCalculator implements AdvancedArithmetic {
    public int divisorSum(int n) {
        int s = n;
        for (int i=1; i<=n/2; i++)
            if (n%i == 0)
                s += i;
        return s;
    }
}
