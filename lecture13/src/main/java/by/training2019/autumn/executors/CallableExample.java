package by.training2019.autumn.executors;

import java.security.SecureRandom;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.Future;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ExecutionException;

import java.text.SimpleDateFormat;

/**
 * Example 12.
 * */
public class CallableExample {
    private int poolSize = 6;

    private void demo() {
        // Определяем пул из трех потоков
        ExecutorService executor = Executors.newFixedThreadPool(poolSize);

        // Список ассоциированных с Callable задач Future
        List<Future<String>> futures = new ArrayList<>();

        for (int i = 0; i < poolSize; i++) {
            // Запускается Callable-поток и результат исполнения добавляется в List
            futures.add(executor.submit(new CallableClass()));
        }

        for (Future<String> future : futures) {
            try {
                // Выводим в консоль полученное значение
                System.out.println(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        // Останавливаем пул потоков
        executor.shutdown();
    }

    // Класс, реализующий интерфейс Callable
    class CallableClass implements Callable<String> {
        @Override
        public String call() throws Exception {
            System.out.println("Starting thread: " + Thread.currentThread().getName());

            Thread.sleep(new SecureRandom().nextInt(10) * 100);

            // наименование потока, выполняющего callable задачу
            return "Thread completed its work: " + Thread.currentThread().getName();
        }
    }

    public static void main(String args[]) {
        new CallableExample().demo();
    }
}
