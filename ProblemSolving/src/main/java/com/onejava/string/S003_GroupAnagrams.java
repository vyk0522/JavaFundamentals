package com.onejava.string;

import java.util.*;
import java.util.stream.Collectors;

/*
        Group Anagrams and sort the list
 */
public class S003_GroupAnagrams {
    public static void main(String[] args) {
        String[] words = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> lists = groupAnagramsStream(words);
        System.out.println(lists); // [[ate, eat, tea], [bat], [nat, tan]] // sorted list

        List<List<String>> lists2 = groupAnagramsMap(words);
        System.out.println(lists2); // [[eat, tea, ate], [bat], [tan, nat]]
    }

    private static List<List<String>> groupAnagramsStream(String[] words){
        Map<String, List<String>> listMap = Arrays.stream(words)
                .collect(Collectors.groupingBy(S003_GroupAnagrams::sortedWord));

        List<List<String>> anagramsList = listMap.values().stream().toList();

        anagramsList.forEach(anagrams -> Collections.sort(anagrams));

        return anagramsList;
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
