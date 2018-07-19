package Java.ObjectOrientedProgramming;
import java.util.*;
import java.io.*;
/**
 * HackerRank Java ObjectOrientedProgramming 6
 * https://www.hackerrank.com/challenges/java-method-overriding-2-super-keyword/problem
 * @author Hasol
 */
public class Cycle {
    public static void main(String[] args) {
        MotorCycle m = new MotorCycle();
    }
}
class BiCycle {
    String defineMe() {
        return "a vehicle with pedals.";
    }
}
class MotorCycle extends BiCycle {
    public MotorCycle() {
        System.out.println("Hello I am a motorcycle, I am "+ define_me());
        String temp = super.defineMe();
        System.out.println("My ancestor is a cycle who is " + temp);
    }
    String defineMe() {
        return "a cycle with an engine.";
    }
}
