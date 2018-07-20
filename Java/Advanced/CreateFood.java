package Java.Advanced;
import java.util.*;
import java.security.*;
/**
 * HackerRank Java Advanced 5
 * https://www.hackerrank.com/challenges/java-factory/problem
 * @author Hasol
 */
public class CreateFood {
    public static void main(String[] args) {
        DoNotTerminate.forbidExit();
        try {
            Scanner sc=new Scanner(System.in);
            FoodFactory foodFactory = new FoodFactory();
            Food food = foodFactory.getFood(sc.nextLine());
            System.out.println("The factory returned " + food.getClass());
            System.out.println(food.getType());
        } catch (DoNotTerminate.ExitTrappedException e) {
            System.out.println("Unsuccessful Termination!!");
        }
    }
}
class DoNotTerminate {
    public static class ExitTrappedException extends SecurityException {
        private static final long serialVersionUID = 1L;
    }
    public static void forbidExit() {
        final SecurityManager securityManager = new SecurityManager() {
            @Override
            public void checkPermission(Permission permission) {
                if (permission.getName().contains("exitVM"))
                    throw new ExitTrappedException();
            }
        };
        System.setSecurityManager(securityManager);
    }
}	
interface Food {
    public String getType();
}
class Pizza implements Food {
    public String getType() {
        return "Someone ordered a Fast Food!";
    }
}
class Cake implements Food {
    public String getType() {
        return "Someone ordered a Dessert!";
    }
}
class FoodFactory {
    public Food getFood(String order) {
        switch (order.toUpperCase()) {
            case "PIZZA":
                return new Pizza();
            case "CAKE":
                return new Cake();
        }
        return null;
    }
}
