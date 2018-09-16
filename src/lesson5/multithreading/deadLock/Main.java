package lesson5.multithreading.deadLock;

public class Main {
    public static void main(String[] args) {
        Object A = new Object();
        Object B = new Object();

        MyThread thread1 = new MyThread(A, B);
        MyThread2 thread2 = new MyThread2(A, B);
        thread1.start();
        thread2.start();
    }

}
