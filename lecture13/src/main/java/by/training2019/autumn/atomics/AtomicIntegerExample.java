package by.training2019.autumn.atomics;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Example 7.
 * */
public class AtomicIntegerExample {
    private static AtomicInteger at = new AtomicInteger(0);
 
    static class MyRunnable implements Runnable {
        private int myCounter;
        private int myPrevCounter;
        private int myCounterPlusFive;
        private boolean isFourteen;
 
        public void run() {
            myCounter = at.incrementAndGet();
            System.out.println("Thread " + Thread.currentThread().getId() + " \t/ Counter\t:\t" + myCounter);

            myPrevCounter = at.getAndIncrement();
            System.out.println("Thread " + Thread.currentThread().getId() + "\t/ Previous\t:\t" + myPrevCounter);

            myCounterPlusFive = at.addAndGet(5);        
            System.out.println("Thread " + Thread.currentThread().getId() + "\t/ plus five\t:\t" + myCounterPlusFive);

            isFourteen = at.compareAndSet(14, 3);

            if (isFourteen) {
                System.out.println("\nThread " + Thread.currentThread().getId()
                        + "\t/ Value was equal to 14, so it was updated to " + at.intValue());
            }
        }
    }
 
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyRunnable());
        Thread t2 = new Thread(new MyRunnable());

        t1.start();
        t2.start();
    }
}