package Java.Advanced;
import java.io.*;
import java.lang.reflect.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/**
 * HackerRank Java Advanced 1
 * https://www.hackerrank.com/challenges/simple-addition-varargs/problem
 * @author Hasol
 */
public class VarargAddition {
    public static void main(String[] args) {
        try {
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            int n1 = Integer.parseInt(br.readLine());
            int n2 = Integer.parseInt(br.readLine());
            int n3 = Integer.parseInt(br.readLine());
            int n4 = Integer.parseInt(br.readLine());
            int n5 = Integer.parseInt(br.readLine());
            int n6 = Integer.parseInt(br.readLine());
            Add ob = new Add();
            ob.add(n1, n2);
            ob.add(n1, n2, n3);
            ob.add(n1, n2, n3, n4, n5);	
            ob.add(n1, n2, n3, n4, n5, n6);
            Method[] methods = Add.class.getDeclaredMethods();
            Set<String> set = new HashSet<>();
            boolean overload = false;
            for (int i=0; i<methods.length; i++) {
                if (set.contains(methods[i].getName())) {
                    overload=true;
                    break;
                }
                set.add(methods[i].getName());
            }
            if (overload)
                throw new Exception("Overloading not allowed");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class Add {
    void add(int... n) {
        StringBuilder sb = new StringBuilder();
        int s = 0;
        for (int i=0; i<n.length; i++) {
            s += n[i];
            sb.append(n[i]);
            if (i != n.length-1)
            sb.append('+');
        }
        sb.append('=');
        sb.append(s);
        System.out.println(sb.toString());
    }
}
