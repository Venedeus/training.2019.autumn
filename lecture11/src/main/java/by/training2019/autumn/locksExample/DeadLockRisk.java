package by.training2019.autumn.locksExample;

public class DeadLockRisk implements Runnable {
    private Object lock = new Object();
    private static class Resource {
    }

    private final Resource scissors = new Resource();
    private final Resource paper = new Resource();

    public static void main(String[] args) {
        DeadLockRisk job = new DeadLockRisk();
        Thread masha = new Thread(job, "Маша");
        Thread dasha = new Thread(job, "Даша");
        masha.start();
        dasha.start();
    }

    public void doSun() {
        synchronized (lock) { // May deadlock here
            System.out.println(Thread.currentThread().getName()
                    + " взяла ножницы для вырезания солнышка");
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName()
                        + " взяла бумагу для вырезания солнышка");
                System.out.println(Thread.currentThread().getName()
                        + " вырезает солнышко");
            }
        }
    }

    public void doCloud() {
        synchronized (lock) { // May deadlock here
            System.out.println(Thread.currentThread().getName()
                    + " взяла бумагу для вырезания облачка");
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName()
                        + " взяла ножницы для вырезания облачка");
                System.out.println(Thread.currentThread().getName()
                        + " вырезает облачко");
            }
        }
    }

    public void run() {
        doSun();
        doCloud();
    }
}
