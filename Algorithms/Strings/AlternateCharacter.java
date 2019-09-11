package Algorithms.Strings;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
/**
 * HackerRank Algorithms Strings 4
 * https://www.hackerrank.com/challenges/two-characters/problem
 * @author Hasol
 */
public class AlternateCharacter {
    // Complete the alternate function below.
    static int alternate(String s) {
        int max = 0;
        ArrayList<String> combo = getCombos(getUniqueChars(s));
        for (String c: combo)
        {
            String st = s.replaceAll("[^" + c + "]", "");
            if (!st.matches("^.*(\\w)\\1.*$") && st.length() > max)
                max = st.length();
        }
        return max;
    }
    static HashSet<Character> getUniqueChars(String s) {
        HashSet<Character> set = new HashSet<>(s.length());
        for (char c: s.toCharArray())
            set.add(c);
        return set;
    }
    static ArrayList<String> getCombos(HashSet<Character> set) {
        ArrayList<String> list = new ArrayList<>(set.size() * set.size());
        Character[] array = new Character[set.size()];
        array = set.toArray(array);
        for (int i = 0; i < set.size() - 1; i++)
            for (int j = i + 1; j < set.size(); j++)
                list.add("" + array[i] + array[j]);
        return list;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int l = Integer.parseInt(bufferedReader.readLine().trim());
        String s = bufferedReader.readLine();
        int result = alternate(s);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedReader.close();
        bufferedWriter.close();
    }
}
