package lesson5.multithreading.timer;

public class MyTread extends Timer {

    private Thread timer;
    private int n;

    public MyTread(Thread timer, int n, Counter counter) {
        super(counter);
        this.n = n;
        this.timer = timer;
    }

    @Override
    public void run() {
        synchronized (timer) {
            while (true) {
                try {
                    timer.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (counter.getCounter() % n == 0) {
                    System.out.println(n + " сек");
                }
            }
        }
    }
}
