package com.onejava.Collection;

import java.util.*;

public class Col003_Set {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(1);
        System.out.println(set.contains(1)); // true
        System.out.println(set.size()); // 1

        List<Integer> list = new ArrayList<>(set);
        list.add(3);
        list.add(2);
        System.out.println(list);

        TreeSet<Integer> treeSet = new TreeSet<>(list);
        treeSet.descendingSet().forEach(System.out::print);
        System.out.println();

        SortedSet sortedSet = new TreeSet(list);
        System.out.println(sortedSet.first());
        System.out.println(sortedSet.headSet(2));

        NavigableSet<String> original = new TreeSet();
        original.add("1");
        original.add("2");
        original.add("3");
        System.out.println(original.headSet("2", true));


    }
}
