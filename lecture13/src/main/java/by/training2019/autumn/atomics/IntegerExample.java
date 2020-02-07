package by.training2019.autumn.atomics;

/**
 * Example 6.
 * */
public class IntegerExample {
    private static Integer value = 0;

    private static class Updater implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Thread " + Thread.currentThread().getId() + " \t/ Counter\t:\t" + value++);
            System.out.println("Thread " + Thread.currentThread().getId() + "\t/ Previous\t:\t" + ++value);
            System.out.println("Thread " + Thread.currentThread().getId() + "\t/ plus five\t:\t" + (value += 5));
            System.out.println("Thread " + Thread.currentThread().getId() + "\t/ Value was equal to 14, so it was updated to " + (value = (value == 14) ? 3 : 6));
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Updater());
        Thread thread2 = new Thread(new Updater());

        thread1.start();
        thread2.start();

        while (thread1.isAlive() || thread2.isAlive()) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\nFinal value: " + value);
    }
}

