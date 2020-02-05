package by.training2019.autumn;

import java.util.concurrent.*;

/**
 * Example #7.
 * */
public class BlockingQueueExample {
    private BlockingQueue<String> queue;

    private final String    DONE     = "done";

    private final String[] tasks = {
            "Мама приготовила обед",
            "Мама позвала к столу",
            "Дети кушают обед",
            "Папа моет посуду"};

    public BlockingQueueExample() {
        queue = new ArrayBlockingQueue<>(1, true);

        new Thread(new Producer()).start();
        new Thread(new Consumer()).start();
    }

    class Producer implements Runnable {
        public void run() {
            try {
                int ctr = 0;

                for (int i = 0; i < tasks.length; i++) {
                    queue.put(tasks[i]);

                    System.out.println("New task: \t\t" + tasks[i]);

                    if (++ctr < 4) {
                        Thread.sleep(700);
                    }
                }

                queue.put(DONE);
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    class Consumer implements Runnable {
        public void run() {
            try {
                String task = null;

                Thread.sleep(3000);

                while (!((task = queue.take()).equals(DONE))) {
                    System.out.println("Task done:\t\t\t" + task);
                    Thread.sleep(2000);
                }
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new BlockingQueueExample();
    }
}
