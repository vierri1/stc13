package lesson5.multithreading.threadpool;

public class SlaveThread {
    public Double count() {
        double sum = 0;
        for (int i = 0; i < 5000000; i++) {
            sum += i;
        }
        return sum;
    }
}
