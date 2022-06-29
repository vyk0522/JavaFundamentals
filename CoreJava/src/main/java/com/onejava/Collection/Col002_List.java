package com.onejava.Collection;

import java.util.*;

public class Col002_List {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, null, 1, 2, 3, 3));
        list.set(0, 11);
        System.out.println(list.contains(null)); // it uses == instead of equals when input is null
        list.add(5);

        List<Integer> list1 = Arrays.asList(1);
        list.removeAll(list1);
        System.out.println(list);

        list.remove((Integer) 2); // to remove element 2
        list.remove(1); // It removes 1st indexed element
        System.out.println(list);

        list = new ArrayList<>(new HashSet<>(list));
        System.out.println(list);

        List<Integer> list2 = Arrays.asList(1, 2, 1, 3);
        Set<Integer> set = new HashSet<>(list2);
        System.out.println(set);

        Object[] objects = list2.toArray();
        Integer[] integers = list2.toArray(new Integer[0]);
        System.out.println(Arrays.toString(integers));

        String[] str = new String[]{ "one", "two", "three" };
        List<String> strings = Arrays.asList(str);

        List<Integer> list3 = List.of(10, 20, 30);
        // list3.add(20); // UnsupportedOperationException
        System.out.println(list3);
        List<Integer> list4 = Collections.unmodifiableList(list);
        list.add(11);
       System.out.println(list4);


    }
}
