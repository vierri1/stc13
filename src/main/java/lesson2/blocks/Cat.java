package lesson2.blocks;

public class Cat extends Animal implements Running, Mieowing, Eating {

    public Cat(String name, Integer nLegs) {
        super(name, nLegs);
    }

    @Override
    public void eat() {
        System.out.println("Cat eats");
    }

    @Override
    public void meow() {
        System.out.println("Meow");
    }

    @Override
    public void run() {
        System.out.println("Cat runs");

    }

    public String toString() {
        return super.toString();
    }
}
