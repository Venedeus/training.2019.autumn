package by.training2019.autumn;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * Example #9.
 * */
public class SynchQueuesExample {
    private BlockingQueue<String> queue;

    private final String    DONE     = "done";
    private final String[] tasks = {
            "Мама приготовила обед",
            "Мама позвала к столу",
            "Дети кушают обед",
            "Папа моет посуду"};

    public SynchQueuesExample () {
        queue = new SynchronousQueue<>();

        new Thread(new Producer()).start();
        new Thread(new Consumer()).start();
    }

    class Producer implements Runnable {
        public void run() {
            try {
                for (int i = 0; i < tasks.length; i++) {
                    System.out.println("\t# " + i + " Producer is waiting to be synchronized");

                    queue.put(tasks[i]);

                    System.out.println("\t# " + i + " Producer has been synchronized");
                }

                queue.put(DONE);
            } catch (InterruptedException e) {}
        }
    }

    class Consumer implements Runnable {
        private int i = 0;

        public void run() {
            try {
                String msg = null;

                while (true) {
                    System.out.println("# " + i + " Consumer is waiting to be synchronized");

                    Thread.sleep(3000);

                    if (!((msg = queue.take()).equals(DONE))) {
                        System.out.println("\t\t------- " + msg + " -------");
                    } else {
                        break;
                    }

                    System.out.println("# " + i++ + " Consumer has been synchronized");
                }
            } catch (InterruptedException e) {}
        }
    }

    public static void main(String[] args) {
        new SynchQueuesExample();
    }
}
