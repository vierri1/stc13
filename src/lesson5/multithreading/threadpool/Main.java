package lesson5.multithreading.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(8);
        SlaveThread slaveThread = new SlaveThread();
        long startTime = System.currentTimeMillis();

        List<Future<Double>> futures = new ArrayList<>();
        for (int i = 0; i < 400; i++) {
            final int j = 0;
            futures.add(CompletableFuture.supplyAsync(slaveThread::count, threadPool));
        }

        double value = 0;
        for (Future<Double> future : futures) {
            try {
                value += future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        System.out.println(System.currentTimeMillis() - startTime);
        threadPool.shutdown();
    }
}
