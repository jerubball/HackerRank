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
    /*
    static long totalHealth1(String d, int first, int last, String[] genes, int[] health) {
        long total = 0;
        for (int i=0; i<d.length(); i++)
            for (int j=first; j<=last; j++)
                if (d.startsWith(genes[j], i))
                    total += health[j];
        return total;
    }
    static long totalHealth2(String d, int first, int last, String[] genes, int[] health, int maxlength) {
        long total = 0;
        HashMap<String,Integer> map = new HashMap<>((last-first+1)*2);
        for (int i=first; i<=last; i++)
            if (map.containsKey(genes[i]))
                map.replace(genes[i], map.get(genes[i]) + health[i]);
            else
                map.put(genes[i], health[i]);
        String k = null;
        for (int i=0; i<d.length(); i++)
            for (int j=1; j<=maxlength && i+j<=d.length(); j++)
                if (map.containsKey(k = d.substring(i,i+j)))
                    total += map.get(k);
        return total;
    }
    static long totalHealth3(String d, int first, int last, HashMap<String,HashMap<Integer,Integer>> map, int maxlength) {
        long total = 0;
        String k = null;
        for (int i=0; i<d.length(); i++)
            for (int j=1; j<=maxlength && i+j<=d.length(); j++)
                if (map.containsKey(k = d.substring(i,i+j))) {
                    HashMap<Integer,Integer> sub = map.get(k);
                    for (Integer key: sub.keySet())
                        if (first <= key && key <= last)
                            total += sub.get(key);
                }
        return total;
    }
    static long totalHealth4(String d, int first, int last, HashMap<String,ArrayList<SimpleEntry<Integer,Integer>>> map, int maxlength) {
        long total = 0;
        String k = null;
        for (int i=0; i<d.length(); i++)
            for (int j=1; j<=maxlength && i+j<=d.length(); j++)
                if (map.containsKey(k = d.substring(i,i+j))) {
                    ArrayList<SimpleEntry<Integer,Integer>> sub = map.get(k);
                    for (int l = binSearchNext(sub, first); l < sub.size() && sub.get(l).getKey() <= last; l++)
                            total += sub.get(l).getValue();
                }
        return total;
    }
    static long totalHealth5(String d, int first, int last, HashMap<String,HashMap<Integer,HashMap<Integer,Long>>> map, int maxlength) {
        long total = 0;
        String k = null;
        for (int i=0; i<d.length(); i++)
            for (int j=1; j<=maxlength && i+j<=d.length(); j++)
                if (map.containsKey(k = d.substring(i,i+j)))
                    total += map.get(k).get(first).get(last);
        return total;
    }
    static int binSearchNext (ArrayList<SimpleEntry<Integer,Integer>> sub, int i) {
        int start=0, end=sub.size(), mid;
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
    static void minmax(long[] arr) {
        long min = Long.MAX_VALUE, max = Long.MIN_VALUE;
        for (long i: arr) {
            if (i < min)
                min = i;
            if (i > max)
                max = i;
        }
        System.out.println(min + " " + max);
    }
    static HashMap<String,HashMap<Integer,Integer>> convert1(String[] genes, int[] health) {
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
    static HashMap<String,ArrayList<SimpleEntry<Integer,Integer>>> convert2(String[] genes, int[] health) {
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
    static HashMap<String,HashMap<Integer,HashMap<Integer,Long>>> convert3(String[] genes, int[] health) {
        HashMap<String,HashMap<Integer,HashMap<Integer,Long>>> map = new HashMap<>(genes.length*2);
        for (int i=0; i<genes.length; i++) {
            HashMap<Integer,HashMap<Integer,Long>> sub;
            if (!map.containsKey(genes[i]))
                map.put(genes[i], sub = createIndex(genes.length));
            else
                sub = map.get(genes[i]);
            for (int j=0; j<=i; j++) {
                HashMap<Integer,Long> tub = sub.get(j);
                for (int k=i; k<genes.length; j++)
                    tub.replace(k, tub.get(k)+health[i]);
            }
        }
        return map;
    }
    static HashMap<Integer,HashMap<Integer,Long>> createIndex(int length) {
        HashMap<Integer,HashMap<Integer,Long>> sub = new HashMap<>();
        for (int i=0; i<length; i++) {
            HashMap<Integer,Long> tub = new HashMap<>((length-i)*2);
            for (int j=i; j<length; j++) {
                tub.put(j,0l);
            }
            sub.put(i,tub);
        }
        return sub;
    }
    */
    static int maxStringLength(String[] a) {
        int maxlength = 0;
        for (String s: a)
            if (s.length() > maxlength)
                maxlength = s.length();
        return maxlength;
    }
    static void totalHealth6() {
        long min = Long.MAX_VALUE, max = 0, result = 0;
        int maxlength = maxStringLength(genes);
        items.sort(DNAitem.comp);
        int limit = Math.ceil(s > 1000 ? s * 0.1 : s * 0.5);
        for (int i=0; i<limit; i++) {
            if (result < min)
                min = result;
        }
        for (int i=s-limit; i<limit; i++) {
            if (result > max)
                max = result;
        }
        System.out.println(min + " " + max);
    }
    static String[] genes = null;
    static int[] health = null;
    static int n = 0, s = 0;
    static ArrayList<DNAitem> items = null;
    //static HashMap<> map = ????
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        genes = new String[n];
        String[] genesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int i=0; i<n; i++)
            genes[i] = genesItems[i];
        health = new int[n];
        String[] healthItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int i=0; i<n; i++)
            health[i] = Integer.parseInt(healthItems[i]);
        s = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        //HashMap<String,HashMap<Integer,Integer>> map = convert1(genes, health);
        //HashMap<String,ArrayList<SimpleEntry<Integer,Integer>>> map = convert2(genes, health);
        //HashMap<String,HashMap<Integer,HashMap<Integer,Long>>> map = convert3(genes, health);
        items = new ArrayList<>(s);
        for (int sItr=0; sItr<s; sItr++) {
            String[] firstLastd = scanner.nextLine().split(" ");
            int first = Integer.parseInt(firstLastd[0]);
            int last = Integer.parseInt(firstLastd[1]);
            String d = firstLastd[2];
            items.add(new DNAitem(d, first, last));
        }
        totalHealth6();
        scanner.close();
    }
    static class DNAitem {
        static Comparator<DNAitem> comp = (a,b) -> {
            int a1 = a.l - a.f, b1 = b.l - b.f, a2 = a.d.length(), b2 = b.d.length();
            return a1 < b1 ? -1 : a1 > b1 ? 1 : a2 < b2 ? -1 : a2 < b2 ? 1 : 0;
        };
        String d;
        int f, l;
        public DNAitem(String _d, int _f, int _l) {
            d = _d;
            f = _f;
            l = _l;
        }
    }
}
