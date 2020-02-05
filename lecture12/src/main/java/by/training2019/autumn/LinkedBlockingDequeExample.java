package by.training2019.autumn;

import java.util.*;
import java.util.concurrent.*;

/**
 * Example #8.
 * */
public class LinkedBlockingDequeExample {
    private final String EXTRACT     = "Извлечение из map : %s%n"   ;
    private final String INSERT      = "Добавление в очередь : %s%n";
    private final String WAIT        = "... ожидание : %s%n"        ;
    private final String SIZE        = "--- deque.size=%d ---%n"    ;
    private final String REMOVE_HEAD = "\tremove head: %s%n"        ;
    private final String REMOVE_TAIL = "\tremove tail: %s%n"        ;

    private Map<String, Integer>  names = null;
    private Deque<String>         deque = null;

    LinkedBlockingDequeExample() {
        Calendar now    = Calendar.getInstance();
        Locale   locale = Locale.getDefault();

        names = now.getDisplayNames(Calendar.MONTH, Calendar.ALL_STYLES, locale);

        System.out.printf("Список коллекции : %s%n\n",names);

        deque = new LinkedBlockingDeque<>(6);

        Thread producer = new Thread(new Producer());
        producer.start();

        Thread consumer = new Thread(new Consumer());
        consumer.start();

        while (producer.isAlive()) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException ignored) {}
        }

        System.exit(0);
    }

    class Producer implements Runnable {
        public void run() {
            Set<String>      keys = names.keySet();
            Iterator<String> iter = keys.iterator();
            String element = null;

            while ((iter.hasNext()) || (element != null)) {
                if (element == null) {
                    element = iter.next();

                    System.out.printf(EXTRACT, element);
                }

                // Добавление элемента в начало
                if (deque.offerFirst(element)) {
                    System.out.printf(INSERT, element);

                    iter.remove();
                    element = null;
                } else {
                    System.out.printf(WAIT, element);

                    try {
                        Thread.sleep(250);
                    } catch (InterruptedException ignored) {}
                }

                System.out.printf(SIZE, deque.size());
            }
            try {
                Thread.sleep(3500);
            } catch (InterruptedException ignored) {}
        }
    }

    class Consumer implements Runnable {
        public void run() {
            while (true) {
                if ((deque.size() % 2 == 1)) {
                    // удаление из начала
                    System.out.printf(REMOVE_HEAD, deque.pollFirst());
                }
                else {
                    // удаление из конца
                    System.out.printf(REMOVE_TAIL, deque.pollLast());
                }
                try {
                    // пауза между циклами
                    Thread.sleep(500);
                } catch (InterruptedException ignored) {}
            }
        }
    }

    public static void main(String args[]) {
        new LinkedBlockingDequeExample();
    }
}
