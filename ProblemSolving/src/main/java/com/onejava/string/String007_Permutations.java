package com.onejava.string;

/*
Number of permutations = n! = 3! = 6

Given two strings s1 and s2, return true if s2 contains a permutation of s1

 */
public class String007_Permutations {
    public static void main(String[] args) {
        permutations("ABC", 0, "ABC".length() - 1);
        System.out.println(checkInclusion("ab", "eidbaooo")); // true
        System.out.println(checkInclusion("ab", "eidboaoo")); // false
    }

    private static void permutations(String str, int left, int right){
        if (left == right){
            System.out.println(str);
        }
        else{
            for (int i = left; i <= right; i++) {
                String swappedStr = swap(str, left, i);
                permutations(swappedStr, left + 1, right);
            }
        }
    }

    /*
     Takes String and swap characters in i and j positions
     */
    private static String swap(String str, int i, int j){
        char[] chars = str.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return String.valueOf(chars);
    }

    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int[] s1map = new int[26];
        int[] s2map = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1map[s1.charAt(i) - 'a']++;
            s2map[s2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (matches(s1map, s2map))
                return true;
            s2map[s2.charAt(i + s1.length()) - 'a']++;
            s2map[s2.charAt(i) - 'a']--;
        }
        return matches(s1map, s2map);
    }

    public static boolean matches(int[] s1map, int[] s2map) {
        for (int i = 0; i < 26; i++) {
            if (s1map[i] != s2map[i])
                return false;
        }
        return true;
    }
}
