package by.training2019.autumn.callables;

import java.util.concurrent.*;

/**
 * Example #1.
 * */
public class CallableExample {
    private void demo() {
        // 1. Create ExecutorService instance.
        ExecutorService service = Executors.newFixedThreadPool(1);

        // 2. Create Callable task instance.
        Callable<String> callableTask = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "Callable task finished";
            }
        };

        // 3. Put Callable task inside ExecutorService.
        Future<String> taskResult = service.submit(callableTask);

        // 4. Get Callable task result.
        // Status verification can be added: isDone() / isCancelled().
        String result = new String();

        try {
            result = taskResult.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        // 5. Work with Callable task result.
        System.out.println(result);

        // 6. Shutdown the service.
        // Whole workflow can be wrapper with try-finally block.
        service.shutdown();
    }

    public static void main(String[] args) {
        new CallableExample().demo();
    }
}
