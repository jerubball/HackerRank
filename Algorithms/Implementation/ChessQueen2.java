package Algorithms.Implementation;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
/**
 * HackerRank Algorithms Implementation 39
 * https://www.hackerrank.com/challenges/queens-attack-2/problem
 * @author Hasol
 */
public class ChessQueen2 {
    // Complete the queensAttack function below.
    static int queensAttack(int n, int k, int rq, int cq, int[][] obstacles) {
        int[] t = new int[8];
        for (int i=0; i<t.length; i++)
            t[i] = Math.min(i%4 == 2 ? n : (i+2)%8 < 4 ? n-rq : rq-1, i%4 == 0 ? n : i < 4 ? n-cq : cq-1);
        for (int[] p: obstacles) {
            IntPair r = new IntPair(p[0], p[1]).sub(rq, cq);
            if (r.isCardinal()) {
                int i = getIndex(r);
                t[i] = Math.min(t[i], (r.getAbsMin() == 0 ? r.getAbsMax() : r.getAbsMin()) -1);
            }
        }
        int s = 0;
        for (int i: t)
            s += i;
        return s;
    }
    static int getIndex(IntPair p) {
        return ((int)Math.round(p.t / Math.PI *4) +8) % 8;
    }
    static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String[] nk = scanner.nextLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        String[] r_qC_q = scanner.nextLine().split(" ");
        int r_q = Integer.parseInt(r_qC_q[0]);
        int c_q = Integer.parseInt(r_qC_q[1]);
        int[][] obstacles = new int[k][2];
        for (int i=0; i<k; i++) {
            String[] obstaclesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            for (int j=0; j<2; j++)
                obstacles[i][j] = Integer.parseInt(obstaclesRowItems[j]);
        }
        int result = queensAttack(n, k, r_q, c_q, obstacles);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }
}
class IntPair implements Comparable<IntPair> {
    final int x, y, ax, ay;
    final double t;
    public IntPair(int _x, int _y) {
        this.x = _x;
        this.y = _y;
        this.ax = Math.abs(_x);
        this.ay = Math.abs(_y);
        this.t = Math.atan2(_y, _x);
    }
    public IntPair add(IntPair p) {
        return add(p.x, p.y);
    }
    public IntPair add(int dx, int dy) {
        return new IntPair(this.x + dx, this.y + dy);
    }
    public IntPair sub(IntPair p) {
        return sub(p.x, p.y);
    }
    public IntPair sub(int dx, int dy) {
        return new IntPair(this.x - dx, this.y - dy);
    }
    public IntPair mul(int c) {
        return new IntPair(this.x * c, this.y * c);
    }
    public IntPair div(int c) {
        return new IntPair(this.x / c, this.y / c);
    }
    public IntPair mod(int c) {
        return new IntPair(this.x % c, this.y % c);
    }
    public boolean isCardinal() {
        return this.x == 0 || this.y == 0 || this.ax == this.ay;
    }
    public int getMin() {
        return Math.min(this.x, this.y);
    }
    public int getMax() {
        return Math.max(this.x, this.y);
    }
    public int getAbsMin() {
        return Math.min(this.ax, this.ay);
    }
    public int getAbsMax() {
        return Math.max(this.ax, this.ay);
    }
    @Override
    public int compareTo(IntPair p) {
        return this.getAbsMax() - p.getAbsMax();
    }
    public String toString() {
        return "x: " + this.x + ", y: " + this.y;
    }
}
