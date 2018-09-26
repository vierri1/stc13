package lesson5.multithreading.createThread;

public class Main {
    public static void main(String[] args) {
        long res = 0;
        CounterThread counterThread = new CounterThread();
        Thread thread = new Thread(counterThread);
        thread.start();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 590_000; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            res += i;
        }
        System.out.println(res);
        System.out.println(System.currentTimeMillis() - startTime);
    }
}
