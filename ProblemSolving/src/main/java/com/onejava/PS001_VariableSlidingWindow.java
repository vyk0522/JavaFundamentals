package com.onejava;

import java.util.HashMap;
import java.util.Map;

public class PS001_VariableSlidingWindow {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));  // 3
        System.out.println(lengthOfLongestSubstring("bbbbb")); // 1
        System.out.println(lengthOfLongestSubstring("pwwkew")); //3
        System.out.println(lengthOfLongestSubstring("abba")); // 2

    }

    /*
    We used Map to store Character and it's position + 1 > We can use this to move i's position to (j+1 position) when repeating character comes.
    j-1+1 gives the window size of unique elements
    We calculate window size in every iteration. If repeating character comes, we modify i and take the window size.
    map.put method overrides existing value with new value.

    abccbc  > Here We need to move i's position when c is repeated to existing c's position + 1

     */
    public static int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j = 0;
        int result = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (j < s.length()) {
            Character c = s.charAt(j);
            if (map.containsKey(c)){
                i = Math.max(i, map.get(c));  // abba > we don't consider if duplicate key is there before i pointer.
            }
            result = Math.max(result, j-i+1);
            map.put(c, j+1);
            j++;
        }

        return result;
    }
}
