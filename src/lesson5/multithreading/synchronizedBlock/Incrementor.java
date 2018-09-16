package lesson5.multithreading.synchronizedBlock;

public class Incrementor extends Thread {

    private Monitor monitor;

    public Incrementor(Monitor monitor) {
        this.monitor = monitor;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            synchronized (monitor) {
                monitor.setStore(monitor.getStore() + 1);

            }
        }
    }
}
