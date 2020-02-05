package by.training2019.autumn;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Example #4.
 * */
public class ConcurrentHashMapExample {
    Map<String, String> map;

    public ConcurrentHashMapExample() {
        System.out.println("ConcurrentHashMap");
        createMap(true);
        addValue();

        System.out.println("\n\nHashMap");
        createMap(false);
        addValue();
    }

    private void addValue() {
        System.out.println("\tbefore iterator : " + map);

        Iterator<String> it = map.keySet().iterator();

        System.out.print("\tcycle : ");

        while(it.hasNext()){
            String key = it.next();

            if (key.equals("2")) {
                map.put(key + "-new", "222");
            } else {
                System.out.print("  " + key + "=" + map.get(key));
            }
        }
        System.out.println("\n\tafter iterator : " + map);
    }

    private void createMap(boolean concurrent) {
        map = concurrent ? new ConcurrentHashMap<>() : new HashMap<>();

        map.put("1", "1");
        map.put("2", "1");
        map.put("3", "1");
        map.put("4", "1");
        map.put("5", "1");
        map.put("6", "1");
    }

    public static void main(String[] args)
    {
        new ConcurrentHashMapExample();
    }
}
