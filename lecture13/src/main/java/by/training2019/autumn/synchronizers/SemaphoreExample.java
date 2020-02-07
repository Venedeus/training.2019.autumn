package by.training2019.autumn.synchronizers;

import java.util.concurrent.Semaphore;

/**
 * Example #1.
 */
public class SemaphoreExample {
    private static final int STABLEMEN_COUNT = 5;
    private static final int RIDERS_COUNT = 10;
    private static boolean[] STABLEMEN = null;

    // Семафор
    private static Semaphore SEMAPHORE = null;

    public static class Rider implements Runnable {
        private int riderNum;

        public Rider(int ruderNum) {
            this.riderNum = ruderNum;
        }

        @Override
        public void run() {
            System.out.printf(
                    "Всадник %d подошел к конюшне, в очереди %d всадников\n", riderNum, SEMAPHORE.getQueueLength());
            try {
                // Запрос разрешения
                SEMAPHORE.acquire();

                System.out.printf("\tвсадник %d запрашивает свободного конюха\n", riderNum);

                int controlNum = -1;

                for (int i = 0; i < STABLEMEN_COUNT; i++) {
                    if (STABLEMEN[i]) {
                        STABLEMEN[i] = false;

                        controlNum = i;

                        System.out.printf("\tвсадник %d запрашивает лошадь у конюха %d.\n", riderNum, i);
                        break;
                    }
                }

                // Время обслуживания лошади и всадника
                Thread.sleep((int) (Math.random() * 10 + 1) * 1000);
                STABLEMEN[controlNum] = true;

                // Освобождение ресурса
                SEMAPHORE.release();

                System.out.printf("(!) Всадник %d получил лошадь, конюх %d освобожден\n", riderNum, controlNum);
            } catch (InterruptedException e) {
            }
        }
    }

    public static void main(String[] args)
            throws InterruptedException {
        STABLEMEN = new boolean[STABLEMEN_COUNT];

        for (int i = 0; i < STABLEMEN_COUNT; i++)
            STABLEMEN[i] = true;

        SEMAPHORE = new Semaphore(STABLEMEN.length,
                true);

        System.out.println("Всего всандиков: " + RIDERS_COUNT);
        System.out.println("Всего конюхов к конюшне: " + STABLEMEN_COUNT);
        System.out.println("--------------------------");

        for (int i = 0; i < RIDERS_COUNT; i++) {
            Thread rider = new Thread(new Rider(i));
            rider.start();
            Thread.sleep(400);
        }
    }
}
