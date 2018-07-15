package Algorithms.Implementation;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.function.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * HackerRank Algorithms Implementation 62
 * https://www.hackerrank.com/challenges/bomber-man/problem
 * @author Hasol
 */
public class BomberMan {
    // Complete the bomberMan function below.
    static String[] bomberMan(int n, String[] grid) {
        char[][] g = new char[grid.length][];
        for (int i=0; i<grid.length; i++)
            g[i] = grid[i].toCharArray();
        replace(g, a -> (a == 'O'), a -> 'R');
        if (n>5)
            n = (n-2)%4 +2;
        for (int k=0; k<=n; k++) {
            if (k%2 == 0 && k > 0)
                replace(g, a -> (a == '.'), a -> 'R');
            for (int i=0; i<g.length; i++)
                for (int j=0; j<g[i].length; j++)
                    if (g[i][j] == 'O') {
                        g[i][j] = '.';
                        if (i>0 && g[i-1][j] != 'O')
                            g[i-1][j] = '.';
                        if (i<g.length-1 && g[i+1][j] != 'O')
                            g[i+1][j] = '.';
                        if (j>0 && g[i][j-1] != 'O')
                            g[i][j-1] = '.';
                        if (j<g[i].length-1 && g[i][j+1] != 'O')
                            g[i][j+1] = '.';
                    }
            replace(g, a -> (a > 'O' && a < 'S'), a -> --a);
        }
        replace(g, a -> (a > 'O' && a < 'S'), a -> 'O');
        String[] s = new String[g.length];
        for (int i=0; i<g.length; i++)
            s[i] = new String(g[i]);
        return s;
    }
    static char[][] replace(char[][] g, Function<Character, Boolean> f, Function<Character, Character> r) {
        for (int i=0; i<g.length; i++)
            for (int j=0; j<g[i].length; j++)
                if (f.apply(g[i][j]))
                    g[i][j] = r.apply(g[i][j]);
        return g;
    }
    static String[] alternate(int n, String[] grid) {
        char[][] g = new char[grid.length][];
        for (int i=0; i<grid.length; i++)
            g[i] = grid[i].toCharArray();
        int[][] t = new int[g.length][g[0].length];
        for (int i=0; i<g.length; i++)
            for (int j=0; j<g[i].length; j++)
                if (g[i][j] == 'O')
                    t[i][j] = 3;
                else
                    t[i][j] = -1;
        if (n>5)
            n = (n-2)%4 +2;
        for (int k=0; k<=n; k++) {
            if (k%2 == 0 && k>0)
                for (int i=0; i<g.length; i++)
                    for (int j=0; j<g[i].length; j++)
                        if (g[i][j] == '.') {
                            g[i][j] = 'O';
                            t[i][j] = 3;
                        }
            for (int i=0; i<t.length; i++)
                for (int j=0; j<t[i].length; j++)
                    if (t[i][j] == 0) {
                        g[i][j] = '.';
                        if (i>0)
                            g[i-1][j] = '.';
                        if (i<g.length-1)
                            g[i+1][j] = '.';
                        if (j>0)
                            g[i][j-1] = '.';
                        if (j<g[i].length-1)
                            g[i][j+1] = '.';
                    }
            for (int i=0; i<t.length; i++)
                for (int j=0; j<t[i].length; j++)
                    t[i][j]--;
        }
        String[] s = new String[g.length];
        for (int i=0; i<g.length; i++)
            s[i] = new String(g[i]);
        return s;
    }
    static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String[] rcn = scanner.nextLine().split(" ");
        int r = Integer.parseInt(rcn[0]);
        int c = Integer.parseInt(rcn[1]);
        int n = Integer.parseInt(rcn[2]);
        String[] grid = new String[r];
        for (int i=0; i<r; i++)
            grid[i] = scanner.nextLine();
        String[] result = bomberMan(n, grid);
        for (int i=0; i<result.length; i++) {
            bufferedWriter.write(result[i]);
            if (i != result.length-1)
                bufferedWriter.write("\n");
        }
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }
}
