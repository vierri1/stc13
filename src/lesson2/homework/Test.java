package lesson2.homework;

public class Test {
    public static void main(String[] args) {
        Integer[] integers = {11, 0, 4, 7, 22, 7, 5, 12, -3, 1, 8, 2, 3, 10, 6};
        System.out.println("Before");
        for (int i = 0; i < integers.length; i++) {
            System.out.print(integers[i] + " ");
        }
        System.out.println("\nAfter");
        QuickSort.sort(integers, 0, integers.length - 1);
        for (int i = 0; i < integers.length; i++) {
            System.out.print(integers[i] + " ");
        }
    }
}
