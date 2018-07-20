package Java.Advanced;
import java.io.*;
import java.lang.reflect.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
package Java.Advanced;
/**
 * HackerRank Java Advanced 2
 * https://www.hackerrank.com/challenges/java-reflection-attributes/problem
 * @author Hasol
 */
public class MethodList {
    public static void main(String[] args) {
        Class student = Student.class;
        Method[] methods = student.getDeclaredMethods();
        ArrayList<String> methodList = new ArrayList<>();
        for (Method method: methods)
            methodList.add(method.getName());
        Collections.sort(methodList);
        for (String name: methodList)
        System.out.println(name);
    }
}
class Student {
    private String name;
    private String id;
    private String email;
    public String getName() {
        return name;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void anothermethod() {
    }
}
