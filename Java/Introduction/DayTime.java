package Java.Introduction;
import java.util.*;
/**
 * HackerRank Java Introduction 12
 * https://www.hackerrank.com/challenges/java-date-and-time/problem
 * @author Hasol
 */
public class DayTime {
    public static String getDay(String day, String month, String year) {
        int d = Integer.parseInt(day), m = Integer.parseInt(month), y = Integer.parseInt(year);
        Calendar c = new Calendar.Builder().setDate(y, m-1, d).build();
        return c.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.US).toUpperCase();
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String month = in.next();
        String day = in.next();
        String year = in.next();
        System.out.println(getDay(day, month, year));
    }
}
