package lesson6.reflection.proxy;

public class JavaTrainer implements Trainer {
    @Override
    public void teach() {
        System.out.println("Java is really complicated");
    }

    @Override
    public void eat() {
        System.out.println("I like to eat Mango");
    }

    @Override
    public void talk() {
        System.out.println("Where is your homework?");
    }
}
