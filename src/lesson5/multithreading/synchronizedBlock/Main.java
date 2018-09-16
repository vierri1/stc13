package lesson5.multithreading.synchronizedBlock;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        long startTime = System.currentTimeMillis();
        Monitor monitor = new Monitor();
        Incrementor thread1 = new Incrementor(monitor);
        Incrementor thread2 = new Incrementor(monitor);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(monitor.getStore());
        System.out.println(System.currentTimeMillis() - startTime);
    }
}
