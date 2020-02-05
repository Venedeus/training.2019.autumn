package by.training2019.autumn;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Example #3.
 * */
public class MapIteratorProblem {

    public static void main(String args[]){
        /**
         * This part causes ConcurrentModificationException.
         * */
        Map<String,String> myMap = new ConcurrentHashMap<>(); // new HashMap<>();
        myMap.put("1", "1");
        myMap.put("2", "2");
        myMap.put("3", "3");

        Iterator<Map.Entry<String, String>> iterator = myMap.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();

            System.out.println(entry);

            if (entry.getKey().equals("2")) {
                myMap.put("key", "value");
            }
        }
    }
}