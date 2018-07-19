package Java.DataStructures;
import java.util.*;
/**
 * HackerRank Java DataStructures 12
 * https://www.hackerrank.com/challenges/java-sort/problem
 * @author Hasol
*/
public class StudentSort {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        List<Student> studentList = new ArrayList<Student>();
        while(testCases-- > 0) {
            int id = in.nextInt();
            String fname = in.next();
            double cgpa = in.nextDouble();
            Student st = new Student(id, fname, cgpa);
            studentList.add(st);
        }
        Collections.sort(studentList, Student.getComparator());
        for(Student st: studentList)
            System.out.println(st.getFname());
    }
}
class Student {
    private int id;
    private String fname;
    private double cgpa;
    public Student(int id, String fname, double cgpa) {
        super();
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }
    public int getId() {
        return id;
    }
    public String getFname() {
        return fname;
    }
    public double getCgpa() {
        return cgpa;
    }
    public static Comparator<Student> getComparator() {
        return new Comparator<Student>() {
            @Override
            public int compare(Student a, Student b) {
                if (a.cgpa != b.cgpa)
                    return b.cgpa < a.cgpa ? -1 : 1;
                else if (!a.fname.equals(b.fname))
                    return a.fname.compareTo(b.fname);
                else
                    return a.id - b.id;
            }
        };
    }
}
