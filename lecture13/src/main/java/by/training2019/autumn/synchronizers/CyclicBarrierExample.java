package by.training2019.autumn.synchronizers;

import java.util.concurrent.CyclicBarrier;

/**
 * Example 3.
 * */
public class CyclicBarrierExample {
    private static CyclicBarrier FERRY_BARIER;
    private static final int FERRY_BOAT_SIZE = 3;

    // Переправляющий автомобили паром
    public static class FerryBoat implements Runnable {
        @Override
        public void run() {
            try {
                // Задержка на переправе 
                System.out.println("\nЗагрузка автомобилей");
                Thread.sleep(500);
                System.out.println("Паром переправил автомобили\n");
            } catch (InterruptedException e) {
            }
        }
    }

    // Класс автомобиля
    public static class Car implements Runnable {
        private int carNumber;

        public Car(int carNumber) {
            this.carNumber = carNumber;
        }

        @Override
        public void run() {
            try {
                System.out.printf("К переправе подъехал автомобиль %d\n", carNumber);

                // Вызов метода await при подходе к 
                // барьеру; поток блокируется в ожидании 
                // прихода остальных потоков
                FERRY_BARIER.await();

                System.out.printf("Автомобиль %d продолжил движение\n", carNumber);
            } catch (Exception e) {
            }
        }
    }

    public static void main(String[] args)
            throws InterruptedException {
        FERRY_BARIER = new CyclicBarrier(FERRY_BOAT_SIZE, new FerryBoat());

        for (int i = 1; i < 10; i++) {
            new Thread(new Car(i)).start();
            Thread.sleep(400);
        }
    }
}