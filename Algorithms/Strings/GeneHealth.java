package Algorithms.Strings;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.AbstractMap.SimpleEntry;
/**
 * HackerRank Algorithms Strings 16
 * https://www.hackerrank.com/challenges/determining-dna-health/problem
 * @author Hasol
 */
public class GeneHealth {
    // global variables
    static String[] genes = null;
    static int[] health = null;
    static int n = 0, s = 0;
    static ArrayList<DNAitem> items = null;
    public static final int ALPHABET = 26;
    // main method
    public static void main(String... args) throws IOException {
        // create scanner
        Scanner scanner = null;
        //if (args.length == 0)
        scanner = new Scanner(System.in);
        //else
        //    scanner = new Scanner(new File(args[0]));
        // parse gene inputs
        n = scanner.nextInt();
        genes = new String[n];
        for (int i=0; i<n; i++)
            genes[i] = scanner.next();
        health = new int[n];
        for (int i=0; i<n; i++)
            health[i] = scanner.nextInt();
        // parse DNA inputs
        s = scanner.nextInt();
        items = new ArrayList<>(s);
        for (int i=0; i<s; i++) {
            String[] firstLastd = scanner.nextLine().split(" ");
            int first = scanner.nextInt();
            int last = scanner.nextInt();
            String d = scanner.next();
            items.add(new DNAitem(d, first, last));
        }
        // always close
        scanner.close();
        // execute commands
        //new Solution10().run();
        Alternate.solve();
    }
    // working solution
    static class Alternate {
        public static final Comparator<Pair> COMPARE = (o1, o2) -> (o1.index - o2.index);
        static Node root;
        static int maxLen;
        public static void solve() {
            maxLen = Utils.minmax(genes)[1];
            root = new Node();
            for (int i=0; i<n; i++)
                root.add(genes[i], i, health[i]);
            long min = Long.MAX_VALUE, max = Long.MIN_VALUE;
            for (DNAitem i: items) {
                i.h = calculateHealth(i.f, i.l, i.d);
                if (i.h < min)
                    min = i.h;
                if (i.h > max)
                    max = i.h;
            }
            System.out.println(min + " " + max);
        }
        static long calculateHealth(int first, int last, String d) {
            long result = 0;
            Pair firstP = new Pair(first, 0);
            Pair lastP = new Pair(last, 0);
            char[] chars = d.toCharArray();
            for (int i=0; i<d.length(); i++)
                result += root.value(chars, i, firstP, lastP);
            return result;
        }
        static class Node {
            List<Pair> values;
            Pair[] pairs;
            Node[] children;
            void add(String s, int index, int value) {
                if (children == null)
                    children = new Node[ALPHABET];
                int c = s.charAt(0) - 'a';
                Node child = children[c];
                if (child == null)
                    children[c] = child = new Node();
                if (s.length() == 1) {
                    if (child.values == null)
                        child.values = new ArrayList<>();
                    child.values.add(new Pair(index, value));
                } else
                    child.add(s.substring(1), index, value);
            }
            long value(char[] s, int index, Pair firstP, Pair lastP) {
                if (children == null || s.length <= index)
                    return 0;
                int c = s[index] - 'a';
                Node child = children[c];
                long result = 0;
                if (child != null) {
                    if (child.values != null) {
                        if (child.pairs == null) {
                            child.values.sort(COMPARE);
                            child.pairs = child.values.toArray(new Pair[child.values.size()]);
                        }
                        if (child.pairs.length > 10) {
                            int start = Arrays.binarySearch(child.pairs, firstP, COMPARE);
                            int stop = Arrays.binarySearch(child.pairs, lastP, COMPARE);
                            if (start < 0)
                                start = -start-1;
                            if (stop < 0)
                                stop = -stop+1;
                            stop = Math.min(stop, child.pairs.length-1);
                            for (int i=Math.max(0, start); i<=stop; i++) {
                                Pair value = child.pairs[i];
                                if (value.index >= firstP.index && value.index <= lastP.index)
                                    result += value.value;
                            }
                        } else
                            for (Pair value : child.pairs)
                                if (value.index >= firstP.index && value.index <= lastP.index)
                                    result += value.value;
                    }
                    if (s.length > ++index)
                        result += child.value(s, index, firstP, lastP);
                }
                return result;
            }
        }
        static class Pair {
            int index;
            int value;
            public Pair(int index, int value) {
                this.index = index;
                this.value = value;
            }
        }
    }
    /** Container class for DNA and gene range */
    static class DNAitem {
        static Comparator<DNAitem> comp = (a,b) -> {
            int a1 = a.l - a.f, b1 = b.l - b.f, a2 = a.d.length(), b2 = b.d.length();
            return a1 < b1 ? -1 : a1 > b1 ? 1 : a2 < b2 ? -1 : a2 < b2 ? 1 : 0;
        };
        String d;
        int f, l;
        long h;
        public DNAitem(String _d, int _f, int _l) {
            d = _d;
            f = _f;
            l = _l;
            h = -1;
        }
    }
    /** Tree container class for gene information */
    static class GeneItem {
        public final char c;
        public final int level;
        private GeneItem[] children;
        private int lo, hi;
        private long sum;
        private ArrayList<SimpleEntry<Integer,Integer>> list;
        public GeneItem() {
            c = ' ';
            level = 0;
            children = new GeneItem[ALPHABET];
            list = null;
            lo = 0;
            hi = n;
            sum = 0l;
        }
        private GeneItem(char _c, int _l) {
            c = _c;
            level = _l;
            children = new GeneItem[ALPHABET];
            list = new ArrayList<>();
            lo = Integer.MAX_VALUE;
            hi = Integer.MIN_VALUE;
            sum = 0l;
        }
        private GeneItem addChild(char _c) {
            int i = _c - 'a';
            if (children[i] == null)
                children[i] = new GeneItem(_c, level+1);
            return children[i];
        }
        public GeneItem getChild(char _c) {
            return children[_c - 'a'];
        }
        public void addItem(String g, int h, int i) {
            if (hi < i)
                hi = i;
            if (lo > i)
                lo = i;
            if (g.length() == 0) {
                list.add(new SimpleEntry<>(i, h));
                sum += h;
            } else {
                GeneItem child = addChild(g.charAt(0));
                child.addItem(g.substring(1), h, i);
            }
        }
        public long getItem(String d, int f, int l) {
            LinkedList<GeneItem> queue = new LinkedList<>();
            long value = 0;
            for (char _c: d.toCharArray()) {
                queue.push(this);
                int size = queue.size();
                for (int i=0; i<size; i++) {
                    GeneItem item = queue.remove().getChild(_c);
                    if (item != null && item.lo <= l && item.hi >= f) {
                        if (item.sum > 0) {
                            if (item.lo >= f && item.hi <= l)
                                value += item.sum;
                            else
                                for (int j = Utils.binSearchNext(item.list, f); j < item.list.size() && item.list.get(j).getKey() <= l; j++)
                                    value += item.list.get(j).getValue();
                        }
                        queue.add(item);
                    }
                }
            }
            return value;
        }
    }
    /** Library for utilities */
    static class Utils {
        static int[] minmax(String[] a) {
            int minlength = Integer.MAX_VALUE, maxlength = Integer.MIN_VALUE;
            for (String s: a) {
                if (s.length() > maxlength)
                    maxlength = s.length();
                if (s.length() < minlength)
                    minlength = s.length();
            }
            return new int[] {minlength, maxlength};
        }
        static long[] minmax(long[] arr) {
            long min = Long.MAX_VALUE, max = Long.MIN_VALUE;
            for (long i: arr) {
                if (i < min)
                    min = i;
                if (i > max)
                    max = i;
            }
            return new long[] {min, max};
        }
        static long[] minmax() {
            long min = Long.MAX_VALUE, max = Long.MIN_VALUE;
            for (DNAitem i: items) {
                if (i.h < min)
                    min = i.h;
                if (i.h > max)
                    max = i.h;
            }
            return new long[] {min, max};
        }
        static int binSearchNext (ArrayList<SimpleEntry<Integer,Integer>> sub, int i) {
            int start = 0, end = sub.size(), mid;
            while (start < end) {
                mid = (start+end)/2;
                if (sub.get(mid).getKey() < i)
                    start = mid+1;
                else if (sub.get(mid).getKey() > i)
                    end = mid;
                else
                    return mid;
            }
            return start;
        }
    }
    /** Parent solution class to measure time taken */
    static abstract class Solution {
        abstract void totalHealth();
        void run() {
            long start, end;
            start = System.currentTimeMillis();
            totalHealth();
            end = System.currentTimeMillis();
            double duration = (end-start)/1000.0;
            System.out.println("\nCompleted after " + duration + " seconds.\n");
        }
    }
    /** Solution with three for loops. O(s*m*n) efficiency. 0.031s for input00. 549.105s for input02. */
    static class Solution1 extends Solution {
        void totalHealth() {
            for (DNAitem i: items)
                i.h = computeHealth(i);
            long[] result = Utils.minmax();
            System.out.println(result[0] + " " + result[1]);
        }
        static long computeHealth(DNAitem item) {
            long total = 0;
            for (int i=0; i<item.d.length(); i++)
                for (int j=item.f; j<=item.l; j++)
                    if (item.d.startsWith(genes[j], i))
                        total += health[j];
            return total;
        }
    }
    /** Solution with HashMap for each gene range. O(s*(n+m*k)) efficiency. 0.022s for input00. 270.203s for input02. */
    static class Solution2 extends Solution {
        static int[] range = null;
        void totalHealth() {
            long min = Long.MAX_VALUE, max = Long.MIN_VALUE;
            range = Utils.minmax(genes);
            for (DNAitem i: items) {
                i.h = computeHealth(i);
                if (i.h < min)
                    min = i.h;
                if (i.h > max)
                    max = i.h;
            }
            System.out.println(min + " " + max);
        }
        static long computeHealth(DNAitem item) {
            long total = 0;
            HashMap<String,Long> map = convert(item.f, item.l);
            String k = null;
            for (int i=0; i<item.d.length(); i++)
                for (int j=range[0]; j<=range[1] && i+j<=item.d.length(); j++)
                    if (map.containsKey(k = item.d.substring(i,i+j)))
                        total += map.get(k);
            return total;
        }
        static HashMap<String,Long> convert(int f, int l) {
            HashMap<String,Long> map = new HashMap<>((l-f+1)*2);
            for (int i=f; i<=l; i++) {
                Long value = map.get(genes[i]);
                long v = value == null ? 0l : value;
                map.put(genes[i], v + health[i]);
            }
            return map;
        }
    }
    /** Solution with global HashMap of HashMap. O(s*m*n) efficiency?. 0.057s for input00. 63.695s for input02 */
    static class Solution3 extends Solution {
        static int[] range = null;
        static HashMap<String,HashMap<Integer,Integer>> map = null;
        void totalHealth() {
            long min = Long.MAX_VALUE, max = Long.MIN_VALUE;
            range = Utils.minmax(genes);
            map = convert();
            for (DNAitem i: items) {
                i.h = computeHealth(i);
                if (i.h < min)
                    min = i.h;
                if (i.h > max)
                    max = i.h;
            }
            System.out.println(min + " " + max);
        }
        static long computeHealth(DNAitem item) {
            long total = 0;
            String k = null;
            for (int i=0; i<item.d.length(); i++)
                for (int j=range[0]; j<=range[1] && i+j<=item.d.length(); j++)
                    if (map.containsKey(k = item.d.substring(i,i+j))) {
                        HashMap<Integer,Integer> sub = map.get(k);
                        for (Integer key: sub.keySet())
                            if (item.f <= key && key <= item.l)
                                total += sub.get(key);
                    }
            return total;
        }
        static HashMap<String,HashMap<Integer,Integer>> convert() {
            HashMap<String,HashMap<Integer,Integer>> map = new HashMap<>(genes.length*2);
            for (int i=0; i<genes.length; i++)
                if (map.containsKey(genes[i]))
                    map.get(genes[i]).put(i, health[i]);
                else {
                    HashMap<Integer,Integer> sub = new HashMap<>();
                    sub.put(i, health[i]);
                    map.put(genes[i], sub);
                }
            return map;
        }
    }
    /** Solution with global HashMap of ArrayList. O(s*m*n*log(k)) efficiency?. 0.029s for input00. 10.953s for input02. */
    static class Solution4 extends Solution {
        static int[] range = null;
        static HashMap<String,ArrayList<SimpleEntry<Integer,Integer>>> map = null;
        void totalHealth() {
            long min = Long.MAX_VALUE, max = Long.MIN_VALUE;
            range = Utils.minmax(genes);
            map = convert();
            for (DNAitem i: items) {
                i.h = computeHealth(i);
                if (i.h < min)
                    min = i.h;
                if (i.h > max)
                    max = i.h;
            }
            System.out.println(min + " " + max);
        }
        static long computeHealth(DNAitem item) {
            long total = 0;
            for (int i=0; i<item.d.length(); i++)
                for (int j=range[0]; j<=range[1] && i+j<=item.d.length(); j++) {
                    ArrayList<SimpleEntry<Integer,Integer>> sub = map.get(item.d.substring(i,i+j));
                    if (sub != null)
                        for (int l = Utils.binSearchNext(sub, item.f); l < sub.size() && sub.get(l).getKey() <= item.l; l++)
                            total += sub.get(l).getValue();
                }
            return total;
        }
        static HashMap<String,ArrayList<SimpleEntry<Integer,Integer>>> convert() {
            HashMap<String,ArrayList<SimpleEntry<Integer,Integer>>> map = new HashMap<>(genes.length*2);
            for (int i=0; i<genes.length; i++)
                if (map.containsKey(genes[i]))
                    map.get(genes[i]).add(new SimpleEntry<>(i, health[i]));
                else {
                    ArrayList<SimpleEntry<Integer,Integer>> sub = new ArrayList<>();
                    sub.add(new SimpleEntry<>(i, health[i]));
                    map.put(genes[i], sub);
                }
            return map;
        }
    }
    /** Solution with global HashMap of double HashMap. O(s*m) efficiency?. 0.074s for input00. Throws OutOfMemoryError for input02. */
    static class Solution5 extends Solution {
        static int[] range = null;
        static HashMap<String,HashMap<Integer,HashMap<Integer,Long>>> map = null;
        void totalHealth() {
            long min = Long.MAX_VALUE, max = Long.MIN_VALUE;
            range = Utils.minmax(genes);
            map = convert();
            for (DNAitem i: items) {
                i.h = computeHealth(i);
                if (i.h < min)
                    min = i.h;
                if (i.h > max)
                    max = i.h;
            }
            System.out.println(min + " " + max);
        }
        static long computeHealth(DNAitem item) {
            long total = 0;
            String k = null;
            for (int i=0; i<item.d.length(); i++)
                for (int j=range[0]; j<=range[1] && i+j<=item.d.length(); j++)
                    if (map.containsKey(k = item.d.substring(i,i+j)))
                        total += map.get(k).get(item.f).get(item.l);
            return total;
        }
        static HashMap<String,HashMap<Integer,HashMap<Integer,Long>>> convert() {
            HashMap<String,HashMap<Integer,HashMap<Integer,Long>>> map = new HashMap<>(genes.length*2);
            for (int i=0; i<genes.length; i++) {
                HashMap<Integer,HashMap<Integer,Long>> sub;
                if (!map.containsKey(genes[i]))
                    map.put(genes[i], sub = createIndex(genes.length));
                else
                    sub = map.get(genes[i]);
                for (int j=0; j<=i; j++) {
                    HashMap<Integer,Long> tub = sub.get(j);
                    for (int k=i; k<genes.length; k++)
                        tub.replace(k, tub.get(k)+health[i]);
                }
            }
            return map;
        }
        static HashMap<Integer,HashMap<Integer,Long>> createIndex(int length) {
            HashMap<Integer,HashMap<Integer,Long>> sub = new HashMap<>();
            for (int i=0; i<length; i++) {
                HashMap<Integer,Long> tub = new HashMap<>((length-i)*2);
                for (int j=i; j<length; j++)
                    tub.put(j,0l);
                sub.put(i,tub);
            }
            return sub;
        }
    }
    /** Solution with global HashMap of long[][]. O(s*m) efficiency?. 0.041s for input00. Throws OutOfMemoryError for input02. */
    static class Solution6 extends Solution {
        static int[] range = null;
        static HashMap<String,long[][]> map = null;
        void totalHealth() {
            long min = Long.MAX_VALUE, max = Long.MIN_VALUE;
            range = Utils.minmax(genes);
            map = convert();
            for (DNAitem i: items) {
                i.h = computeHealth(i);
                if (i.h < min)
                    min = i.h;
                if (i.h > max)
                    max = i.h;
            }
            System.out.println(min + " " + max);
        }
        static long computeHealth(DNAitem item) {
            long total = 0;
            for (int i=0; i<item.d.length(); i++)
                for (int j=range[0]; j<=range[1] && i+j<=item.d.length(); j++) {
                    long[][] sub = map.get(item.d.substring(i,i+j));
                    if (sub != null)
                        total += sub[item.f][item.l-item.f];
                }
            return total;
        }
        static HashMap<String,long[][]> convert() {
            HashMap<String,long[][]> map = new HashMap<>(genes.length*2);
            for (int i=0; i<genes.length; i++) {
                long[][] sub;
                if (!map.containsKey(genes[i]))
                    map.put(genes[i], sub = createIndex(genes.length));
                else
                    sub = map.get(genes[i]);
                for (int j=0; j<=i; j++)
                    for (int k=i; k<genes.length; k++)
                        sub[j][k-j] += health[i];
            }
            return map;
        }
        static long[][] createIndex(int length) {
            long[][] sub = new long[length][];
            for (int i=0; i<sub.length; i++)
                sub[i] = new long[length-i];
            return sub;
        }
    }
    /** Solution with global HashMap of ArrayList and filtered items. O(s*m*n*log(k)) efficiency?. 0.04s for input00. 2.766s for input02. */
    static class Solution7 extends Solution4 {
        void totalHealth() {
            long min = Long.MAX_VALUE, max = Long.MIN_VALUE;
            range = Utils.minmax(genes);
            map = convert();
            items.sort(DNAitem.comp);
            int limit = (int)Math.ceil(s > 1000 ? s * 0.1 : s * 0.5);
            for (int i=0; i<limit; i++) {
                DNAitem item = items.get(i);
                item.h = computeHealth(item);
                if (item.h < min)
                    min = item.h;
            }
            for (int i=s-limit; i<s; i++) {
                DNAitem item = items.get(i);
                item.h = computeHealth(item);
                if (item.h > max)
                    max = item.h;
            }
            System.out.println(min + " " + max);
        }
    }
    /** Solution with global HashMap of ArrayList and multiple Threads. O(s*m*n*log(k)) efficiency?. 0.052s for input00. 7.275s for input02. */
    static class Solution8 extends Solution4 {
        static volatile long min, max;
        static Thread[] threads;
        void totalHealth() {
            min = Long.MAX_VALUE;
            max = Long.MIN_VALUE;
            range = Utils.minmax(genes);
            map = convert();
            threads = new Thread[s<1024?s:1024];
            for (int i=0; i<threads.length; i++)
                threads[i] = new Thread(new Subtask(i));
            for (Thread thread: threads)
                thread.start();
            for (Thread thread: threads)
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            System.out.println(min + " " + max);
        }
        static class Subtask implements Runnable {
            final int index;
            public Subtask(int i) {
                index = i;
            }
            public void run() {
                for (int i=index; i<items.size(); i+=threads.length) {
                    DNAitem item = items.get(i);
                    item.h = computeHealth(item);
                    synchronized(Solution8.class) {
                        if (item.h < min)
                            min = item.h;
                        if (item.h > max)
                            max = item.h;
                    }
                }
            }
        }
    }
    /** Solution with Tree mapping structure. O(s*m*n) efficiency? 0.056s for input00. 4.147s for input02. */
    static class Solution9 extends Solution {
        static GeneItem map = null;
        void totalHealth() {
            long min = Long.MAX_VALUE, max = Long.MIN_VALUE;
            map = convert();
            for (DNAitem i: items) {
                i.h = computeHealth(i);
                if (i.h < min)
                    min = i.h;
                if (i.h > max)
                    max = i.h;
            }
            System.out.println(min + " " + max);
        }
        static long computeHealth(DNAitem item) {
            return map.getItem(item.d, item.f, item.l);
        }
        static GeneItem convert() {
            GeneItem map = new GeneItem();
            for (int i=0; i<genes.length; i++) {
                map.addItem(genes[i], health[i], i);
            }
            return map;
        }
    }
    /** Solution with Tree mapping structure and multiple Threads. O(s*m*n) efficiency? 0.046s for input00. 7.757s for input02. */
    static class Solution10 extends Solution9 {
        static volatile long min, max;
        static Thread[] threads;
        void totalHealth() {
            min = Long.MAX_VALUE;
            max = Long.MIN_VALUE;
            map = convert();
            threads = new Thread[16];
            for (int i=0; i<threads.length; i++)
                threads[i] = new Thread(new Subtask(i));
            for (Thread thread: threads)
                thread.start();
            for (Thread thread: threads)
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            System.out.println(min + " " + max);
        }
        static class Subtask implements Runnable {
            final int index;
            public Subtask(int i) {
                index = i;
            }
            public void run() {
                for (int i=index; i<items.size(); i+=threads.length) {
                    DNAitem item = items.get(i);
                    item.h = computeHealth(item);
                    synchronized(Solution10.class) {
                        if (item.h < min)
                            min = item.h;
                        if (item.h > max)
                            max = item.h;
                    }
                }
            }
        }
    }
}
