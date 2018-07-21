package Java.Advanced;
import java.io.*;
import java.util.*;
import java.security.*;
/**
 * HackerRank Java Advanced 12
 * https://www.hackerrank.com/challenges/sha-256/problem
 * @author Hasol
 */
public class SHA256 {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        Scanner scan = new Scanner(System.in);
        MessageDigest sha = MessageDigest.getInstance("SHA-256");
        byte[] b = sha.digest(scan.nextLine().getBytes());
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
