package com.onejava.Collection;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public class Col004_Map {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        System.out.println(map.put(1, 1));
        map.put(null, 2);
        System.out.println(map.put(null, 3));
        map.put(3, null);
        map.put(4, null);
        System.out.println("putIfAbsent: " + map.putIfAbsent(1, 100));
        map.merge(1, 33, (oldValue, newValue) -> oldValue + newValue + 1 );
        System.out.println(map);

        System.out.println(map.get(null));
        System.out.println(map.getOrDefault(7, 0));
        System.out.println(map.containsValue(null));

        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, Integer> entry = iterator.next();
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        System.out.println(map.isEmpty());

        Map<Integer, Integer> table = new Hashtable<>();
        //table.put(null, 1);
       // table.put(2, null);
        table.put(3, 33);
        System.out.println(table);

    }
}
