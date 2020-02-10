package by.training2019.autumn.callables;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

/**
 * Example 4.
 *
 * Some statistics:
 * 1 (50 forks) = 169_575
 * 5 (10 forks) = 27_978
 * 10 (5 forks) = 7_948
 * 13 (4 forks) = 6_767
 * 25 (2 forks) = 6_238
 * 50 (0 forks) = 45_796
 * */
public class ForkJoinFibonacciExample extends RecursiveAction {
    private static final long threshold = 1;
    private volatile long number;

    public ForkJoinFibonacciExample(long number) {
        this.number = number;
    }

    public long getNumber() {
        return number;
    }

    @Override
    protected void compute() {
        long n = number;

        if (n <= threshold) {
            number = fib(n);
        } else {
            ForkJoinFibonacciExample f1 = new ForkJoinFibonacciExample(n - 1);
            ForkJoinFibonacciExample f2 = new ForkJoinFibonacciExample(n - 2);

            ForkJoinTask.invokeAll(f1, f2);
            number = f1.number + f2.number;
        }
    }

    private static long fib(long n) {
        if (n <= 1) {
            return n;
        }
        else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        ForkJoinFibonacciExample task = new ForkJoinFibonacciExample(50);

        new ForkJoinPool().invoke(task);

        System.out.println("Result: " + task.getNumber());

        long endTime = System.currentTimeMillis();

        System.out.println("Active time: " + (endTime - startTime));
    }
}