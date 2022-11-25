package com.onejava;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        String first = "abcbcd";
        String second = "cdefef";
        String common = commonCharacters(first, second);
        System.out.println("common characters in '" + first + "' and '" + second + "' are '" + common + "'");
    }

    public static String commonCharacters(String a, String b) {
        Set<Character> set = new HashSet<>();
        Set<Character> resultSet = new HashSet<>();
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < a.length(); i++) {
            set.add(a.charAt(i));
        }

        for (int i = 0; i < b.length(); i++) {
            if (set.contains(b.charAt(i))){
                resultSet.add(b.charAt(i));
            }
        }

        return resultSet.stream().map(String::valueOf).collect(Collectors.joining());
    }
}
