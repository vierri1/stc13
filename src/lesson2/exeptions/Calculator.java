package lesson2.exeptions;

public class Calculator {

    public double divide(int a, int b) {
        try {
            return a / b;
        } catch (ArithmeticException ex) {
            System.out.println("Problem");
        }

        return 0;
    }
}
