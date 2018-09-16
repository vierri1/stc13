package lesson5.multithreading.timer;

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread timer = new Timer(counter);
        Thread thread1 = new MyTread(timer, 3, counter);
        Thread thread2 = new MyTread(timer, 5, counter);
        Thread thread3 = new MyTread(timer, 11, counter);
        timer.start();
        thread1.start();
        thread2.start();
        thread3.start();


    }
}
