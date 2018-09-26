package lesson2.blocks;

public class Main {
    public static void main(String[] args) {
        Cat[] cats = new Cat[10];
        int i = 1;
        for (Cat cat : cats) {
            cat = new Cat("Barsik" + i, 4);
            i++;
            System.out.println(cat);
        }
    }
}
