package lesson13.logging_tests.junit;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SomeClassTest {
    private static Logger LOGGER = Logger.getLogger(SomeClass.class);
    private SomeClass someClass;

    @BeforeEach
    void setUp() {
        LOGGER.info("BeforeEach method performed");
        someClass = new SomeClass();
    }

    @AfterEach
    void tearDown() {
        LOGGER.info("AfterEach method performed");
    }

    @Test
    void getSumm() {
        int res = someClass.getSumm(1, 2);
        assertEquals(3, res);
    }

    @Test
    void doSome() {
        assertThrows(IOException.class, () -> someClass.doSome(5));
    }

    @Test
    void doSomeWithoutException() {

    }

}