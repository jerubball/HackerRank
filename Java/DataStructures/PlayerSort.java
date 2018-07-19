package Java.DataStructures;
import java.util.*;
/**
 * HackerRank Java DataStructures 11
 * https://www.hackerrank.com/challenges/java-comparator/problem
 * @author Hasol
 */
public class PlayerSort {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Player[] player = new Player[n];
        PlayerComparator checker = new PlayerComparator();
        for(int i=0; i<n; i++)
            player[i] = new Player(scan.next(), scan.nextInt());
        scan.close();
        Arrays.sort(player, checker);
        for(int i=0; i<player.length; i++)
            System.out.printf("%s %s\n", player[i].name, player[i].score);
    }
}
class Player {
    String name;
    int score;
    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
}
class PlayerComparator implements Comparator<Player> {
    @Override
    public int compare(Player a, Player b) {
        if (a.score != b.score)
            return b.score - a.score;
        else
            return a.name.compareTo(b.name);
    }
}
