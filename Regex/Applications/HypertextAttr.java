package Regex.Applications;
import java.io.*;
import java.util.*;
import java.util.regex.*;
/**
 * HackerRank Regex Applications 20
 * https://www.hackerrank.com/challenges/html-attributes/problem
 * @author Hasol
 */
public class HypertextAttr {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<n; i++) {
            sb.append(scan.nextLine());
            sb.append('\n');
        }
        HashMap<String, HashSet<String>> map = new HashMap<>();
        String reg = "<\\s*?(\\w+)((?:\\s+?\\w+\\s*?=\\s*?[\"'].*?[\"'])?)\\s*?/?>";
        Matcher m = Pattern.compile(reg).matcher(sb);
        while (m.find()) {
            String tag = m.group(1);
            if (tag != null && (tag = tag.trim()).length()>0) {
                if (!map.containsKey(tag))
                    map.put(tag, new HashSet<>());
                String attr0 = m.group(2);
                if (attr0 != null && (attr0 = attr0.trim()).length()>0) {
                    attr0 = attr0.replaceAll("\\s*?=\\s*?[\"'].*?[\"']", "").trim();
                    HashSet<String> set = map.get(tag);
                    String[] attr1 = attr0.split("\\s+");
                    for (int i=0; i<attr1.length; i++)
                        set.add(attr1[i]);
                }
            }
        }
        ArrayList<Map.Entry<String, HashSet<String>>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, Map.Entry.comparingByKey());
        for (Map.Entry<String, HashSet<String>> item: list) {
            System.out.print(item.getKey());
            System.out.print(':');
            ArrayList<String> attr = new ArrayList<>(item.getValue());
            Collections.sort(attr);
            for (int i=0; i<attr.size(); i++) {
                System.out.print(attr.get(i));
                if (i != attr.size()-1)
                    System.out.print(',');
            }
            System.out.println();
        }
    }
}
