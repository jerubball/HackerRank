package Java.DataStructures;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.PriorityQueue;
/**
 * HackerRank Java DataStructures 15
 * https://www.hackerrank.com/challenges/java-priority-queue/problem
 * @author Hasol
 */
public class StudentQueue {
    final static Scanner scan = new Scanner(System.in);
    final static Priorities priorities = new Priorities();
    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());    
        List<String> events = new ArrayList<>();
        while (totalEvents-- > 0)
            events.add(scan.nextLine());
        List<Student> students = priorities.getStudents(events);
        if (students.isEmpty())
            System.out.println("EMPTY");
        else
            for (Student st: students)
                System.out.println(st.getName());
    }
}
class Student implements Comparable<Student> {
    String name;
    double cgpa;
    int id;
    public Student(int id, String name, double cgpa) {
        this.name = name;
        this.cgpa = cgpa;
        this.id = id;
    }
    public Student(String id, String name, String cgpa) {
        this(Integer.parseInt(id), name, Double.parseDouble(cgpa));
    }
    public String getName() {
        return this.name;
    }
    public double getCGPA() {
        return this.cgpa;
    }
    public int getID() {
        return this.id;
    }
    public int compareTo(Student o) {
        if (this.cgpa != o.cgpa)
            return o.cgpa < this.cgpa ? -1 : 1;
        else if (!this.name.equals(o.name))
            return this.name.compareTo(o.name);
        else
            return this.id - o.id;
    }
}
class Priorities {
    PriorityQueue<Student> queue;
    ArrayList<Student> served, list;
    public Priorities() {
        queue = new PriorityQueue<>();
        served = new ArrayList<>();
        list = new ArrayList<>();
    }
    private void query(String event) {
        String[] args = event.split(" ");
        args[0] = args[0].toUpperCase();
        switch (args[0]) {
            case "ENTER":
                queue.add(new Student(args[3], args[1], args[2]));
                break;
            case "SERVED":
                if (queue.size() > 0)
                    served.add(queue.poll());
                break;
        }
    }
    public List<Student> getStudents(List<String> events) {
        while (!events.isEmpty())
            query(events.remove(0));
        while (queue.size() > 0)
            list.add(queue.poll());
        return list;
    }
}
