package com.onejava.string;

public class String003_AlphaWiseLargeString {
    public static void main(String[] args) {

    }

    private static String alphabeticallyLargeString(String s1){
        int[] a = new int[26];
        char[] chars = s1.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            a[chars[i] - 'a']++;
        }
        return "";
    }

}
