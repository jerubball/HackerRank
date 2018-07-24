package Regex.Applications;
import java.io.*;
import java.util.*;
/**
 * HackerRank Regex Applications 17
 * https://www.hackerrank.com/challenges/hackerrank-language/problem
 * @author Hasol
 */
public class LanguageAPI {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        String reg = "^[1-9]\\d{4} (C|CPP|JAVA|PYTHON|PERL|PHP|RUBY|CSHARP|HASKELL|CLOJURE|BASH|SCALA|ERLANG|CLISP|LUA|BRAINFUCK|JAVASCRIPT|GO|D|OCAML|R|PASCAL|SBCL|DART|GROOVY|OBJECTIVEC)$";
        while (scan.hasNextLine())
            System.out.println(scan.nextLine().matches(reg) ? "VALID" : "INVALID");
    }
}
