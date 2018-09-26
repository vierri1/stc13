package lesson13.logging_tests.log4j;

import org.apache.log4j.Logger;

public class Main {
    private final static Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        LOGGER.debug("debug message");
        for (int i = 0; i < 10_000_000; i++) {
            LOGGER.info("info message");
        }
    }
}
