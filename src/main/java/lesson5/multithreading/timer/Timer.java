package lesson5.multithreading.timer;

public class Timer extends Thread {
    protected Counter counter;

    public Timer(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        while (true) {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this) {
                int counterValue = counter.getCounter();
                counter.setCounter(++counterValue);
                System.out.println(counterValue);
                notifyAll();
            }

        }
    }
}
