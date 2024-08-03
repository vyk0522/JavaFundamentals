package com.org;

import java.util.LinkedList;
import java.util.Queue;
import java.util.*;

public class Test12345 {
    public static void main(String[] args) {
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        System.out.println(ladderLength("hit", "cog", Arrays.asList(words)));

    }
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Queue<String> queue = new LinkedList<>();
        Set<String> words = new HashSet<>(wordList);
        if(!words.contains(endWord)) {
            return 0;
        }
        words.remove(beginWord);
        queue.add(beginWord);
        int level = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for(int i=0;i<size;i++) {
                String currentWord = queue.poll();
                if(currentWord.equals(endWord)) {
                    return level;
                }

                List<String> neighbours = getNeighbours(currentWord);
                for(String neighbour: neighbours) {
                    if(words.contains(neighbour)) {
                        words.remove(neighbour);
                        queue.offer(neighbour);
                    }
                }

            }
        }
        return 0;
    }

    private static List<String> getNeighbours(String word) {
        char chars[] = word.toCharArray();
        List result = new LinkedList<>();
        for(int i=0;i<chars.length;i++) {
            char tempChar = chars[i];
            for(char c='a';c<='z';c++) {
                chars[i] = c;
                String neighbour = new String(chars);
                result.add(neighbour);
            }
            chars[i] = tempChar;
        }
        return result;
    }

}
