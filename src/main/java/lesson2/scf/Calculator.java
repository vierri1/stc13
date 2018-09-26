package lesson2.scf;

public class Calculator {

    public double divide(int a, int b) {
        try {
            return a / b;
        } catch (ArithmeticException | NullPointerException ex) {
            System.out.println("exception");
        } finally {
            System.out.println("Finally");
        }
        return 1;
    }
}
