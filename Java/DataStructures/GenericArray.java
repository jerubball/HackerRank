package Java.DataStructures;
import java.io.IOException;
import java.lang.reflect.Method;
/**
 * HackerRank Java DataStructures 10
 * https://www.hackerrank.com/challenges/java-generics/problem
 * @author Hasol
 */
public class GenericArray {
    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3};
        String[] stringArray = {"Hello", "World"};
        ArrayPrinter.printArray(intArray);
        ArrayPrinter.printArray(stringArray);
        int count = 0;
        for (Method method: ArrayPrinter.class.getDeclaredMethods())
            if(method.getName().equals("printArray"))
                count++;
        if (count > 1)
            System.out.println("Method overloading is not allowed!");
    }
}
class ArrayPrinter {
    static <T> void printArray(T[] arr) {
        for (T a: arr)
            System.out.println(a.toString());
    }
}
