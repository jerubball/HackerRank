package Java.Advanced;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/**
 * HackerRank Java Advanced 
 * https://www.hackerrank.com/challenges/java-vistor-pattern/problem
 * @author Hasol
 */
public class TreeVisitor {
    static Tree alternate() {
        return EfficientTreeBuilder.solve();
    }
    static Tree solve() {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        String[] vs = scan.nextLine().split(" ");
        String[] cs = scan.nextLine().split(" ");
        String[] gs = new String[n-1];
        for (int i=0; i<gs.length; i++)
            gs[i] = scan.nextLine();
        scan.close();
        TreeBuilder b = new TreeBuilder(vs, cs, gs);
        return b.build();
    }
    public static void main(String[] args) {
        Tree root = solve();
        SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
        ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
        FancyVisitor vis3 = new FancyVisitor();
        root.accept(vis1);
        root.accept(vis2);
        root.accept(vis3);
        int res1 = vis1.getResult();
        int res2 = vis2.getResult();
        int res3 = vis3.getResult();
        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }
}
enum Color {
    RED, GREEN
}
abstract class Tree {
    private int value;
    private Color color;
    private int depth;
    public Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }
    public int getValue() {
        return value;
    }
    public Color getColor() {
        return color;
    }
    public int getDepth() {
        return depth;
    }
    public abstract void accept(TreeVis visitor);
}
class TreeNode extends Tree {
    private ArrayList<Tree> children = new ArrayList<>();
    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }
    public void accept(TreeVis visitor) {
        visitor.visitNode(this);
        for (Tree child: children)
            child.accept(visitor);
    }
    public void addChild(Tree child) {
        children.add(child);
    }
}
class TreeLeaf extends Tree {
    public TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }
    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}
abstract class TreeVis
{
    public abstract int getResult();
    public abstract void visitNode(TreeNode node);
    public abstract void visitLeaf(TreeLeaf leaf);
}
class SumInLeavesVisitor extends TreeVis {
    int result;
    public SumInLeavesVisitor() {
        result = 0;
    }
    public int getResult() {
        return result;
    }
    public void visitNode(TreeNode node) {
    }
    public void visitLeaf(TreeLeaf leaf) {
        result += leaf.getValue();
    }
}
class ProductOfRedNodesVisitor extends TreeVis {
    static int modulo = 1000000007;
    long result;
    public ProductOfRedNodesVisitor() {
        result = 1;
    }
    public int getResult() {
        return (int)result;
    }
    public void visitNode(TreeNode node) {
        if (node.getColor() == Color.RED)
            result = (result*node.getValue())%modulo;
    }
    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Color.RED)
            result = (result*leaf.getValue())%modulo;
    }
}
class FancyVisitor extends TreeVis {
    int s1, s2;
    public FancyVisitor() {
        s1 = 0;
        s2 = 0;
    }
    public int getResult() {
        return Math.abs(s1-s2);
    }
    public void visitNode(TreeNode node) {
        if (node.getDepth()%2 == 0)
            s1 += node.getValue();
    }
    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Color.GREEN)
            s2 += leaf.getValue();
    }
}
class TreeBuilder {
    int n;
    int[] v;
    Color[] c;
    boolean[][] g;
    Tree[] t;
    public TreeBuilder(int[] _v, Color[] _c, boolean[][] _g) {
        n = _v.length;
        v = _v;
        c = _c;
        g = _g;
        t = new Tree[n];
    }
    public TreeBuilder(String[] vs, String[] cs, String[] gs) {
        n = vs.length;
        v = new int[n];
        for (int i=0; i<n; i++)
            v[i] = Integer.parseInt(vs[i]);
        c = new Color[n];
        for (int i=0; i<n; i++)
            c[i] = cs[i].equals("0") ? Color.RED : cs[i].equals("1") ? Color.GREEN : null;
        g = new boolean[n][n];
        for (int i=0; i<gs.length; i++) {
            String[] s = gs[i].split(" ");
            int x = Integer.parseInt(s[0])-1, y = Integer.parseInt(s[1])-1;
            g[x][y] = g[y][x] = true;
        }
        t = new Tree[n];
    }
    public Tree build() {
        t[0] = new TreeNode(v[0], c[0], 0);
        return dfs(0, 0);
    }
    private Tree dfs(int k, int d) {
        boolean f = true;
        for (int i=0; i<n; i++)
             if (g[k][i]) {
                 if (f) {
                     f = false;
                     t[k] = new TreeNode(v[k], c[k], d);
                 }
                 g[i][k] = false;
                 ((TreeNode)t[k]).addChild(dfs(i, d+1));
             }
        if (f)
            t[k] = new TreeLeaf(v[k], c[k], d);
        return t[k];
    }
}
/**
 * Alternate working solution by Rodney Shaghoulian
 * https://github.com/rshaghoulian/HackerRank_solutions/blob/master/Java/Advanced/Java%20Visitor%20Pattern/Solution.java
 */
class EfficientTreeBuilder {
    private static int[] values;
    private static Color[] colors;
    private static HashMap<Integer, HashSet<Integer>> map;
    /** Create tree from STDIN */
    public static Tree solve() {
        Scanner scan = new Scanner(System.in);
        int numNodes = scan.nextInt();
        /* Save nodes and colors */
        values = new int[numNodes];
        colors = new Color[numNodes];
        map = new HashMap<>(numNodes);
        for (int i=0; i<numNodes; i++)
            values[i] = scan.nextInt();
        for (int i=0; i<numNodes; i++)
            colors[i] = scan.nextInt() == 0 ? Color.RED : Color.GREEN;
        /* Save edges */
        for (int i=0; i<numNodes-1; i++) {
            int u = scan.nextInt();
            int v = scan.nextInt();
            /* Edges are undirected: Add 1st direction */
            HashSet<Integer> uNeighbors = map.get(u);
            if (uNeighbors == null) {                
                uNeighbors = new HashSet<>();
                map.put(u, uNeighbors);
            }
            uNeighbors.add(v);
            /* Edges are undirected: Add 2nd direction */
            HashSet<Integer> vNeighbors = map.get(v);
            if (vNeighbors == null) {
                vNeighbors = new HashSet<>();
                map.put(v, vNeighbors);
            }
            vNeighbors.add(u);
        }
        scan.close();
        /* Handle 1-node tree */
        if (numNodes == 1)
            return new TreeLeaf(values[0], colors[0], 0);
        /* Create Tree */
        TreeNode root = new TreeNode(values[0], colors[0], 0);
        addChildren(root, 1);
        return root;
    }
    /** Recursively adds children of a TreeNode */
    private static void addChildren(TreeNode parent, Integer parentNum) {
        /* Get HashSet of children and loop through them */
        for (Integer treeNum: map.get(parentNum)) {
            map.get(treeNum).remove(parentNum); // removes the opposite arrow direction
            /* Add child */
            HashSet<Integer> grandChildren = map.get(treeNum);
            boolean childHasChild = (grandChildren != null && !grandChildren.isEmpty());
            Tree tree;
            if (childHasChild)
                tree = new TreeNode(values[treeNum-1], colors[treeNum-1], parent.getDepth()+1);
            else
                tree = new TreeLeaf(values[treeNum-1], colors[treeNum-1], parent.getDepth()+1);
            parent.addChild(tree);
            /* Recurse if necessary */
            if (tree instanceof TreeNode)
                addChildren((TreeNode)tree, treeNum);
        }
    }
}
