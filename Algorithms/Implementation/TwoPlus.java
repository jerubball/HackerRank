package Algorithms.Implementation;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * HackerRank Algorithms Implementation 63
 * https://www.hackerrank.com/challenges/two-pluses/problem
 * @author Hasol
 */
public class TwoPlus {
    // Complete the twoPluses function below.
    static int twoPluses(String[] grid) {
        char[][] g = new char[grid.length][];
        for (int i=0; i<grid.length; i++)
            g[i] = grid[i].toCharArray();
        // maximum possible plus arm length;
        int m = (Math.min(g.length, g[0].length)+1)/2;
        ArrayList<IntPair>[] l = new ArrayList[m];
        for (int i=0; i<l.length; i++)
            l[i] = new ArrayList<>();
        // Compute and add all plus.
        for (int i=0, d=0; i<g.length; i++)
            for (int j=0; j<g[i].length; j++, d=0)
                if (g[i][j] == 'G')
                    while (i-d>=0 && g[i-d][j]=='G' && i+d<g.length && g[i+d][j]=='G' && 
                           j-d>=0 && g[i][j-d]=='G' && j+d<g[i].length && g[i][j+d]=='G')
                        l[d++].add(new IntPair(i, j));
        // Order search space by product.
        ArrayList<IntPair> p = new ArrayList<>();
        for (int i=m-1; i>=0; i--)
            for (int j=m-1; j>=0; j--)
                p.add(new IntPair(i, j));
        p.sort(new IntPair.PlusComparator());
        // Compute maximum product permutation.
        int x, y, t, u, v;
        for (IntPair c: p)
            for (IntPair a: l[c.x])
                for (IntPair b: l[c.y])
                    if ((x = Math.abs(a.x-b.x)) > (t = c.x+c.y) || (y = Math.abs(a.y-b.y)) > t || 
                        x > (u = Math.max(c.x, c.y)) && y != 0 || y > u && x != 0 || x > (v = Math.min(c.x, c.y)) && y > v)
                        return IntPair.PlusComparator.compute(c);
        return 0;
    }
    static int allPluses(String[] grid) {
        char[][] g = new char[grid.length][];
        for (int i=0; i<grid.length; i++)
            g[i] = grid[i].toCharArray();
        int p = 1;
        for (int i=1, d=1; i<g.length-1; i++)
            for (int j=1; j<g[i].length-1; j++, d=1)
                while (i-d>=0 && g[i-d][j]=='G' && i+d<g.length && g[i+d][j]=='G' && 
                       j-d>=0 && g[i][j-d]=='G' && j+d<g[i].length && g[i][j+d]=='G')
                    p *= 4*(d++)+1;
        return p;
    }
    static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String[] nm = scanner.nextLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        String[] grid = new String[n];
        for (int i=0; i<n; i++)
            grid[i] = scanner.nextLine();
        int result = twoPluses(grid);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }
}
class IntPair {
    int x, y;
    public IntPair(int _x, int _y) {
        this.x = _x;
        this.y = _y;
    }
    static class PlusComparator implements Comparator<IntPair> {
        @Override
        public int compare(IntPair a, IntPair b) {
            return compute(b)-compute(a);
        }
        public static int compute(IntPair a) {
            return (4*a.x+1)*(4*a.y+1);
        }
    }
}
