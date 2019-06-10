package common.composite;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class IOHelper {

    private InputStream is;
    private PrintStream ps;
    private Scanner scanner;

    public IOHelper(InputStream is, PrintStream ps) {
        this.is = is;
        this.ps = ps;
        scanner = new Scanner(is);
    }

    public String input(String text) {
        ps.println(text);
        return scanner.nextLine();
    }

    public void print(Object text) {
        System.out.println(text);
    }
}
