package by.training2019.autumn;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Example #5.
 * */
public class ConcurrentLinkedQueueExample {
    private Queue<String> queue;

    private volatile boolean cycle = true;

    ConcurrentLinkedQueueExample() {
        queue = new ConcurrentLinkedQueue<>();

        Thread producer = new Thread(new Producer());
        Thread consumer = new Thread(new Consumer());

        producer.start();
//        consumer.start();

        while (producer.isAlive()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.exit(0);
    }

    class Producer implements Runnable {

        public void run() {
            System.out.println("Producer started");

            try {
                for (int i = 1;; i++) {
                    String str = "String" + i;

                    queue.add(str);

//                    System.out.println("Producer added : " + str);

//                    Thread.sleep(100);
                }

//                cycle = false;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    class Consumer implements Runnable {
        public void run() {
            String str;

            System.out.println("Consumer started\n");

            while (cycle || queue.size() > 0) {
                if ((str = queue.poll()) != null)
                    System.out.println("\t\tConsumer removed : " + str);
                try {
                    Thread.sleep(300);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args)
    {
        new ConcurrentLinkedQueueExample();
    }
}