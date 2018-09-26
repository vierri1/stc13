package lesson13.logging_tests.junit;

import java.io.IOException;

public class SomeClass {
    public Integer getSumm(int a, int b) {
        return a + b;
    }

    public void doSome(int a) throws Exception {
        if (a == 5) {
            throw new IOException("Some exception");
        }
    }
}
