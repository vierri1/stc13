package lesson5.multithreading.deadLock;

public class MyThread2 extends Thread {
    private Object A;
    private Object B;

    public MyThread2(Object object, Object object2) {
        this.A = object;
        this.B = object2;
    }

    @Override
    public void run() {
        synchronized (B) {
            try {
                System.out.println("Поток 2 занял B");
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (A) {
                System.out.println("Поток 2 занял A");
            }
        }
    }
}
