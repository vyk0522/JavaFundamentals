package com.onejava.string;

import java.util.*;

public class String005_GroupOfAnagrams {
    public static void main(String[] args) {
        String[] names = {"eat","tea","tan","ate","nat","bat"};
        List<String> strings = Arrays.asList(names);
        solution(strings);

    }

    private static void solution(List<String> list) {
        HashMap<String, List<String>> map = new HashMap<>();
        List<String> resultList = new ArrayList<>();

        if (Objects.isNull(list) || list.size() == 0) {
            return ;
        }

        for (String str : list) {

            String s2 = sortedString(str);
            if (map.get(s2) == null) {
                resultList = new ArrayList();
                resultList.add(str);
                map.put(s2, resultList);
            } else {
                resultList = map.get(s2);
                resultList.add(str);
                map.put(s2, resultList);
            }


        }
        System.out.println(map);
    }

    private static String sortedString(String string) {
        char[] chars = string.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
