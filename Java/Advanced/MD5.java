package Java.Advanced;
import java.io.*;
import java.util.*;
import java.security.*;
/**
 * HackerRank Java Advanced 11
 * https://www.hackerrank.com/challenges/java-md5/problem
 * @author Hasol
 */
public class MD5 {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        Scanner scan = new Scanner(System.in);
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] b = md5.digest(scan.nextLine().getBytes());
        scan.close();
        StringBuilder sb = new StringBuilder(2*b.length);
        for (byte n: b) {
            String s = Integer.toHexString(Byte.toUnsignedInt(n));
            if (s.length() == 1)
                sb.append(0);
            sb.append(s);
        }
        System.out.println(sb.toString());
    }
}
