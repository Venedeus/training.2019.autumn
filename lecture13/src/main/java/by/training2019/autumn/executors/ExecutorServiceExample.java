package by.training2019.autumn.executors;

import java.util.concurrent.*;

/**
 * Example 13.
 * */
public class ExecutorServiceExample {
    private final int COUNT = 5;

    private void demo() {
        CountDownLatch cdl1 = new CountDownLatch(COUNT);
        CountDownLatch cdl2 = new CountDownLatch(COUNT);
        CountDownLatch cdl3 = new CountDownLatch(COUNT);
        CountDownLatch cdl4 = new CountDownLatch(COUNT);

        ExecutorService executor = Executors.newFixedThreadPool(2);

        System.out.println("Запуск потоков");
        executor.execute(new MyThread(cdl1, "Thread.1"));
        executor.execute(new MyThread(cdl2, "Thread.2"));
        executor.execute(new MyThread(cdl3, "Thread.3"));
        executor.execute(new MyThread(cdl4, "Thread.4"));

        try {
            cdl1.await();
            cdl2.await();
            cdl3.await();
            cdl4.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executor.shutdown();
    }

    class MyThread implements Runnable {
        private String name;
        private CountDownLatch latch;

        public MyThread(CountDownLatch c, String n) {
            latch = c;
            name = n;
        }

        public void run() {
            try {
                for (int i = 0; i < COUNT; i++) {
                    System.out.println(name + " - " + i);

                    latch.countDown();

                    Thread.sleep((long) (Math.random() * 1500));
                }

                System.out.println(name + " completed");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String args[]) {
        new ExecutorServiceExample().demo();
    }
}