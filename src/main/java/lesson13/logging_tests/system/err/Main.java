package lesson13.logging_tests.system.err;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.err.println("My error message");
        System.out.println("My usual message");

        System.setErr(new PrintStream(new FileOutputStream("errLog.log")));
        System.err.println("Message to file");
        try {
            throw new Exception("Exception message");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
