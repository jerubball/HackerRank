package Regex.Applications;
import java.io.*;
import java.util.*;
/**
 * HackerRank Regex Applications 5
 * https://www.hackerrank.com/challenges/ip-address-validation/problem
 * @author Hasol
 */
public class IPAddress {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        String line;
        String v4n = "([01]?\\d{1,2}|2[0-4]\\d|25[0-5])", ipv4 = "^(" + v4n + "\\.){3}" + v4n + "$";
        String v6n = "[0-9a-f]{1,4}", ipv6 = "^(" + v6n + ":){7}" + v6n + "$";
        while (scan.hasNextLine())
            System.out.println((line = scan.nextLine()).matches(ipv4) ? "IPv4" : line.matches(ipv6) ? "IPv6" : "Neither");
    }
}
