package by.training2019.autumn;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Example #2.
 * */
public class ListIteratorProblem {

    public static void main(String args[]){
        /**
         * This part causes ConcurrentModificationException.
         * */
        List<String> myList = new CopyOnWriteArrayList<>(); // new ArrayList<>();

        myList.add("1");
        myList.add("2");
        myList.add("3");
        myList.add("4");
        myList.add("5");

        Iterator<String> it = myList.iterator();

        while(it.hasNext()){
            String value = it.next();

            System.out.println("List Value:" + value);

            if(value.equals("3")) {
                myList.remove(value);
            }
        }

        System.out.println(myList);
    }
}