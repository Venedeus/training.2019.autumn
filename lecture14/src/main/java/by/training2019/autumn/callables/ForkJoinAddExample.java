package by.training2019.autumn.callables;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * Example 3.
 *
 * Some statistics:
 * 1 (123_456_789 forks) = 2508
 * 10 (12_345_679 forks) = 1253
 * 100 (1_234_568 forks) = 771
 * 1_000 (123_457 forks) = 718
 * 10_000 (12_346 forks) = 615
 * 100_000 (1_235 forks) = 579
 * 1_000_000 (123 forks) = 608
 * 10_000_000 (13 forks) = 605
 * 100_000_000 (2 forks) = 618
 * 123_456_789 (0 forks) = 611
 * */
public class ForkJoinAddExample extends RecursiveTask<Long> {
    private final long[] numbers;
    private final int start;
    private final int end;
    public static final long threshold = 1;

    public ForkJoinAddExample(long[] numbers) {
        this(numbers, 0, numbers.length);
    }

    private ForkJoinAddExample(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        int length = end - start;

        if (length <= threshold) {
            return add();
        }

        ForkJoinAddExample firstTask = new ForkJoinAddExample(numbers, start, start + length / 2);
        firstTask.fork();

        ForkJoinAddExample secondTask = new ForkJoinAddExample(numbers, start + length / 2, end);
        secondTask.fork();

        Long firstTaskResult = firstTask.join();
        Long secondTaskResult = secondTask.join();

        return firstTaskResult + secondTaskResult;
    }

    private long add() {
        long result = 0;

        for (int i = start; i < end; i++) {
            result += numbers[i];
        }
        return result;
    }

    public static long startForkJoinSum(long n) {
        long[] numbers = LongStream.rangeClosed(1, n).toArray();

        ForkJoinTask<Long> task = new ForkJoinAddExample(numbers);

        return new ForkJoinPool().invoke(task);
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        System.out.println(ForkJoinAddExample.startForkJoinSum(123_456_789));

        long endTime = System.currentTimeMillis();

        System.out.println("Active time: " + (endTime - startTime));
    }

}