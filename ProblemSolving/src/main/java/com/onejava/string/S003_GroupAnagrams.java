package com.onejava.string;

import java.util.*;
import java.util.stream.Collectors;

public class S003_GroupAnagrams {
    public static void main(String[] args) {
        String[] words = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> lists = groupAnagramsStream(words);
        System.out.println(lists); // [[eat, tea, ate], [bat], [tan, nat]]

        List<List<String>> lists2 = groupAnagramsMap(words);
        System.out.println(lists2); // [[eat, tea, ate], [bat], [tan, nat]]
    }

    private static List<List<String>> groupAnagramsStream(String[] words){
        return Arrays.stream(words).collect(Collectors.groupingBy(S003_GroupAnagrams::sortedWord)).values().stream().toList();
    }

    private static List<List<String>> groupAnagramsMap(String[] words){
        Map<String, List<String>> map = new HashMap<>();

        for (String word: words){
            String key = sortedWord(word);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        }
        return new ArrayList<>(map.values());
    }

    private static String sortedWord(String word){
        char[] a = word.toCharArray();
        Arrays.sort(a);
        return new String(a);
    }
}
