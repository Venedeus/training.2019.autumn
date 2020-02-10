package by.training2019.autumn.callables;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

/**
 * Example 2.
 * */
public class WorkStealingExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
//        ExecutorService executorService = Executors.newWorkStealingPool();

        Set<Thread> threads = new HashSet<>();
        List<Callable<String>> tasks = new ArrayList<>();
        List<Future<String>> futures;

        Callable<String> task = () -> {
            System.out.println(Thread.currentThread().getName());

            threads.add(Thread.currentThread());

            return "... some Callable result ...";
        };

        for (int i = 0; i < 10; i++) {
            tasks.add(task);
        }

        futures = executorService.invokeAll(tasks);

        System.out.println("--------------------------------");
        System.out.println("Threads size: " + threads.size());
        System.out.println("Executed tasks: " + futures.size());
        System.out.println("--------------------------------");

        for (Future future : futures) {
            System.out.println(future.get());
        }

        executorService.shutdown();
    }
}
