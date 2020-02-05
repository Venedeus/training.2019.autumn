package by.training2019.autumn;

// Java program to illustrate Traditional Collections Problem

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Example #1.
 * - no synchronized blocks;
 * - no Collections.synchronizedList;
 * - but CopyOnWriteArrayList;
 * */
class TraditionalCollectionsProblem extends Thread {
    private static List<String> l = new CopyOnWriteArrayList<>(); //new ArrayList<>();

    public void run() {
        System.out.println("Trying to modify the list from a different thread");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Child Thread going to add element");
        }

        // Child thread trying to add new
        // element in the Collection object
        l.add("D");
    }

    public static void main(String[] args) throws InterruptedException {
        l.add("A");
        l.add("B");
        l.add("C");

        // We create a child thread that is
        // going to modify ArrayList l.
        new TraditionalCollectionsProblem().start();

        // Now we iterate through the ArrayList
        // and get exception.
        Iterator itr = l.iterator();

        while(itr.hasNext())

    {
        System.out.println(itr.next());

        Thread.sleep(3000);
    }

        System.out.println(l);
    }
}
