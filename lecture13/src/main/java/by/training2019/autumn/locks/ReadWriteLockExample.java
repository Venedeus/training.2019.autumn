package by.training2019.autumn.locks;

import java.util.*;
import java.util.concurrent.locks.*;
 
/**
 * Example 10.
 * */
public class ReadWriteLockExample<E> {
    private static final int READER_SIZE = 10;
    private static final int WRITER_SIZE = 2;

    private List<E> list = new ArrayList<>();
    private ReadWriteLock rwLock = new ReentrantReadWriteLock();
 
    public ReadWriteLockExample(E... initialElements) {
        list.addAll(Arrays.asList(initialElements));
    }

    public static void main(String[] args) {
        new ReadWriteLockExample().demo();
    }

    private void demo() {
        Integer[] initialElements = {33, 28, 86, 99};

        ReadWriteLockExample<Integer> sharedList = new ReadWriteLockExample<>(initialElements);

        for (int i = 0; i < WRITER_SIZE; i++) {
            new Writer(sharedList).start();
        }

        for (int i = 0; i < READER_SIZE; i++) {
            new Reader(sharedList).start();
        }
    }
 
    public void add(E element) {
        Lock writeLock = rwLock.writeLock();
        writeLock.lock();
 
        try {
            list.add(element);
        } finally {
            writeLock.unlock();
        }
    }
 
    public E get(int index) {
        Lock readLock = rwLock.readLock();
        readLock.lock();
 
        try {
            return list.get(index);
        } finally {
            readLock.unlock();
        }
    }
 
    public int size() {
        Lock readLock = rwLock.readLock();
        readLock.lock();
 
        try {
            return list.size();
        } finally {
            readLock.unlock();
        }
    }

    class Writer extends Thread {
        private ReadWriteLockExample<Integer> sharedList;

        public Writer(ReadWriteLockExample<Integer> sharedList) {
            this.sharedList = sharedList;
        }

        public void run() {
            Random random = new Random();
            int number = random.nextInt(100);
            sharedList.add(number);

            try {
                Thread.sleep(100);
                System.out.println(getName() + " -> put: " + number);
            } catch (InterruptedException ie ) { ie.printStackTrace(); }
        }
    }

    class Reader extends Thread {
        private ReadWriteLockExample<Integer> sharedList;

        public Reader(ReadWriteLockExample<Integer> sharedList) {
            this.sharedList = sharedList;
        }

        public void run() {
            Random random = new Random();
            int index = random.nextInt(sharedList.size());
            Integer number = sharedList.get(index);

            System.out.println(getName() + " -> get: " + number);

            try {
                Thread.sleep(100);
            } catch (InterruptedException ie ) { ie.printStackTrace(); }

        }
    }
}