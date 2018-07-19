package Java.DataStructures;
import java.util.*;
/**
 * HackerRank Java DataStructures 5
 * https://www.hackerrank.com/challenges/java-1d-array/problem
 * @author Hasol
 */
public class ArrayLeap {
    static boolean canWin(int leap, int[] game) {
        // Return true if you can win the game; otherwise, return false.
        int c = 0, d = 0;
        for (int a: game)
            if (a == 1)
                c++;
            else {
                d = c>d ? c : d;
                c = 0;
            }
        if (leap > 0 && d >= leap)
            return false;
        boolean[] b = new boolean[game.length];
        for (int i=0; i<game.length; i++)
            b[i] = game[i] == 0;
        ArrayList<Integer> l = new ArrayList<>();
        l.add(0);
        b[0] = false;
        while (!l.isEmpty()) {
            int i = l.remove(0);
            if (i+leap>=game.length || i+1>=game.length)
                return true;
            if (b[i+leap] && !(b[i+leap] = false))
                l.add(i+leap);
            if (b[i+1] && !(b[i+1] = false))
                l.add(i+1);
            if (i>0 && b[i-1] && !(b[i-1] = false))
                l.add(i-1);
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();
            int[] game = new int[n];
            for (int i=0; i<n; i++)
                game[i] = scan.nextInt();
            System.out.println(canWin(leap, game) ? "YES" : "NO");
        }
        scan.close();
    }
}
