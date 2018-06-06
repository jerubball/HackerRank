package Algorithms.Implementation;
import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
/**
 * HackerRank Algorithms Implementation 1
 * https://www.hackerrank.com/challenges/grading/problem
 * @author Hasol
 */
public class Grade {
    //Complete the gradingStudents function below.
    static int[] gradingStudents(int[] grades) {
        int[] s = new int[grades.length];
        for (int i=0; i<grades.length; i++)
            s[i] = grades[i] >= 38 && grades[i] % 5 > 2 ? grades[i] - grades[i] % 5 + 5 : grades[i];
        return s;
    }
    static final Scanner scan = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int n = Integer.parseInt(scan.nextLine().trim());
        int[] grades = new int[n];
        for (int gradesItr=0; gradesItr<n; gradesItr++)
            grades[gradesItr] = Integer.parseInt(scan.nextLine().trim());
        int[] result = gradingStudents(grades);
        for (int resultItr=0; resultItr<result.length; resultItr++) {
            bw.write(String.valueOf(result[resultItr]));
            if (resultItr != result.length-1)
                bw.write("\n");
        }
        bw.newLine();
        bw.close();
    }
}
