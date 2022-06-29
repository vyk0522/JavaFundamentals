package com.onejava.Collection;

import java.util.*;

public class Col001_Collections {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("2");
        list.add("1");
        list.add(null); // sort, binarySearch, min, max fails if null reference is added
        Collections.addAll(list, "3", "4", null);
        System.out.println(list); // [1, 2, 3, 4]

        boolean replacedAny = Collections.replaceAll(list, null, "0");
        System.out.println(replacedAny);
        System.out.println(list);




         Collections.sort(list, Collections.reverseOrder());
         list.sort(Collections.reverseOrder());
         int index = Collections.binarySearch(list, "2"); // List should be sorted before you use binary search
         System.out.println(index);

        Collections.shuffle(list);
        System.out.println(list);

        String min = Collections.min(list);
        System.out.println("Min element: " + min);


    }
}
