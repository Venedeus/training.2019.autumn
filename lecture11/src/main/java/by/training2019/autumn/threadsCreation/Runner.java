package by.training2019.autumn.threadsCreation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

public class Runner {
    private static final Logger LOGGER = LoggerFactory.getLogger(Runner.class);

    public static void main(String[] args) {
        Thread extThread = new ExtThread("extThread");
        Runnable implRunnable = new ImplRunnable();
        Callable implCallable = new ImplCallable("implCallable");

//        /**
//         * Thread execution.
//         * */
//        LOGGER.info("Starting Thread:");
//        // 'main' thread name should be printed.
//        extThread.run();
//        // 'extThread' thread name should be printed.
//        extThread.start();

//        /**
//         * Runnable execution.
//         * */
//        LOGGER.info("Starting Runnable:");
//        // 'main' thread name should be printed.
//        implRunnable.run();
//        // 'implRunnable' thread name should be printed.
//        new Thread(implRunnable, "implRunnable").start();

//        /**
//         * Runnable execution with lambda.
//         * */
//        new Thread(() -> LOGGER.info("Starting Runnable with lambda..."), "Lambda Runnable").start();

//        /**
//         * Callable execution.
//         * */
//        LOGGER.info("Starting Callable:");
//        ExecutorService executor = Executors.newFixedThreadPool(10);
//        Future<String> future = executor.submit(implCallable);
//        try {
//            LOGGER.info("Future result: " + future.get());
//        } catch (InterruptedException | ExecutionException e) {
//            e.printStackTrace();
//        }
//
//        executor.shutdown();

//        LOGGER.info(Thread.currentThread().getName());
//        LOGGER.info("Main is finishing...");
    }
}

class ExtThread extends Thread {
    private static final Logger logger = LoggerFactory.getLogger(ExtThread.class);

    public ExtThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        logger.info(Thread.currentThread().getName());
    }
}

class ImplRunnable implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(ImplRunnable.class);

    public void run() {
        logger.info(Thread.currentThread().getName());
    }
}

class ImplCallable implements Callable<String> {
    private static final Logger logger = LoggerFactory.getLogger(ImplCallable.class);

    private String name;

    public ImplCallable(String name) {
        this.name = name;
    }

    public String call() throws Exception {
        logger.info(Thread.currentThread().getName());
        return name;
    }
}
