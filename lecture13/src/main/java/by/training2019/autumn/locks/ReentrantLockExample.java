package by.training2019.autumn.locks;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Example 8.
 * */
public class ReentrantLockExample {
    private String resource = "Hello, World!";
    private SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss  ");

    private Lock lock;

    private final int TIME_WAIT = 7000;
    private final int TIME_SLEEP = 5000;

    public void demo() throws InterruptedException {
        lock = new ReentrantLock();

        Thread thread1 = new Thread(new LockClass("first", "Первый поток"));
        Thread thread2 = new Thread(new LockClass("second","Второй поток"));

        printMessage(null);
        Thread.sleep(100);

        thread1.start();
        thread2.start();

        while (thread1.isAlive() || thread2.isAlive()) {
            Thread.sleep(500);
        }

        System.exit(0);
    }

    void printMessage(final String msg) {
        String text = sdf.format(new Date());

        System.out.println(text += msg == null ? resource: msg);
    }

    private class LockClass implements Runnable {
        private String name;
        private String text;

        public LockClass(String name, String text) {
            this.name = name;
            this.text = text;
        }

        @Override
        public void run() {
            boolean locked = false;

            try {
                // Получение блокировки в течение TIME_WAIT
                locked = lock.tryLock(TIME_WAIT, TimeUnit.MILLISECONDS);

                if (locked) {
                    resource = text;

                    printMessage(null);
                }

                Thread.sleep(TIME_SLEEP);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                // Убираем блокировку
                printMessage(name + " : завершил работу");

                if (locked) {
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new ReentrantLockExample().demo();
    }
}