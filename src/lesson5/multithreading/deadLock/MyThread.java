package lesson5.multithreading.deadLock;

public class MyThread extends Thread {
    private Object A;
    private Object B;

    public MyThread(Object object, Object object2) {
        this.A = object;
        this.B = object2;
    }

    @Override
    public void run() {
        synchronized (A) {
            try {
                System.out.println("Поток 1 занял А");
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (B) {
                System.out.println("Поток 1 занял B");
            }
        }
    }
}
