package lesson3.generics.homework;


public class Test {
    public static void main(String[] args) {
        Integer[] integers = {10, 8, 4};
        MathBox mathBox = new MathBox(integers);
        mathBox.dump();

        try {
            System.out.println("Divide by 2: " + mathBox.splitter(2));
        } catch (MathBoxException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }

        System.out.println("Calc: " + mathBox.summator());

        mathBox.removeElement(10);
        System.out.println("Remove 10 " + mathBox.toString());

        mathBox.addElement(12);
        mathBox.dump();

        try {
            System.out.println("Divide by 0: " + mathBox.splitter(0));
        } catch (MathBoxException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
}
