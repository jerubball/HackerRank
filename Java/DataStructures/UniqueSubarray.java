package Java.DataStructures;
import java.util.*;
/**
 * HackerRank Java DataStructures 13
 * https://www.hackerrank.com/challenges/java-dequeue/problem
 * @author Hasol
 */
public class UniqueSubarray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        Deque<Integer> deque = new ArrayDeque<>(n);
        HashSet<Integer> set = new HashSet<>();
        int d = 0;
        for (int i=0; i<n; i++) {
            int num = scan.nextInt();
            deque.add(num);
            set.add(num);
            if (deque.size() > m) {
                int a = deque.remove();
                if (!deque.contains(a))
                    set.remove(a);
            }
            if (d < set.size())
                d = set.size();
        }
        System.out.println (d);
    }
}
