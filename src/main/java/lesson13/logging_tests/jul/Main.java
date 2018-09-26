package lesson13.logging_tests.jul;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        logger.info("My logging_tests message");
        logger.log(Level.WARNING, "My warning message");
        try {
            FileHandler fileHandler = new FileHandler("JulLog.log");
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.log(Level.INFO, "Message to file and console");
        logger.log(Level.WARNING, "warning to file and console");
    }
}
