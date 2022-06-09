package com.org;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
String with N lower case letters. Return minimum number of letters that must be deleted to obtain a word with unique occurrence.
 */
public class A004_MinimumNumToDelete {
    public static void main(String[] args) {
        System.out.println(minDeletions("aaaabbbb")); // 4 4 > 4 3 > 1
        System.out.println(minDeletions("ccaaffddecee")); // 33222
        System.out.println(minDeletions("eeee"));
        System.out.println(minDeletions("example")); // 2 1 1 1 1 1
    }

    private static int getMinimumNumToDelete(String str) {
        List<Integer> values = str
                .chars()
                .mapToObj(e -> (char) e)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(e -> 1)))
                .values().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        Set<Integer> set = new HashSet<>();
        Integer result = 0;
        boolean flag = true;
        for (Integer value : values){  // 3 added // 3 > 2 added // 2 > 1 added // 2
            if (flag && ! set.add(value)){
                do {
                    value--;
                    result++;
                    flag = value != 1 ;
                }while(value > 0 && ! set.add(value));
            }
            else if(! flag){
                result = result + value;
            }
        }

        return result;
    }

    public static int minDeletions(String s) {
        int[] a = new int[26];

        for (int i = 0; i < s.length(); i++) {
            a[s.charAt(i) - 'a']++;
        }

        int result = 0;
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < 26; i++) {
            while (a[i] > 0 && set.contains(a[i])){
                a[i]--;
                result++;
            }
            set.add(a[i]);
        }


        return result;

    }
}
