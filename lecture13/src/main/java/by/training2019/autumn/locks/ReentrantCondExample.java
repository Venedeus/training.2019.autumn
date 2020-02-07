package by.training2019.autumn.locks;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Example 9.
 * */
public class ReentrantCondExample {
    private Store store;
    private final String[] GOODS = {"Молоко", "Кефир", "Ряженка", "Кофе", "Чай"};
    private List<String> goods = new ArrayList<>();

    public void demo() {
        store = new Store();

        Thread producer = new Thread(new Producer());
        Thread consumer = new Thread(new Consumer());

        producer.start();
        consumer.start();

        while (producer.isAlive() || consumer.isAlive()) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.exit(0);
    }

    void printMessage(final String msg) {
        System.out.println(msg != null ? msg : "\tТоваров на складе: " + goods.size());
    }

    public static void main(String[] args) {
        new ReentrantCondExample().demo();
    }

    // Производитель
    class Producer implements Runnable {
        public void run() {
            for (int i = 0; i < GOODS.length; i++) {
                store.put(GOODS[i]);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Потребитель
    class Consumer implements Runnable {
        public void run() {
            for (int i = 0; i < GOODS.length; i++) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                store.get();
            }
        }
    }

    // Склад с товаром
    private class Store {
        private ReentrantLock lock;  // блокировка
        private Condition cond;  // условие блокировки

        public Store() {
            lock = new ReentrantLock();
            cond = lock.newCondition();
        }

        public void get() {
            lock.lock();

            try {
                // ожидание на пустом складе
                while (goods.size() < 1) {
                    cond.await();
                }

                printMessage("Реализация : " + goods.get(0));

                goods.remove(0);

                printMessage(null);

                // Сигнализация
                cond.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void put(final String good) {
            lock.lock();

            try {
                // ожидание освобождения места
                while (goods.size() >= 3) {
                    cond.await();
                }

                goods.add(good);

                printMessage("Доставка : " + good);
                printMessage(null);

                // Сигнализация
                cond.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}