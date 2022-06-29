package com.onejava;

public class PS009_FirstUniqueLetter {
    public static void main(String[] args) {
        String s1 = "VivekV";
        System.out.println(firstUniqueCharacter(s1));

        char[] str = "Hello world".toCharArray();
        printFreq(str);

    }

    private static Character firstUniqueCharacter(String word){
        char[] chars = word.toCharArray();
        int[] a = new int[256];

        for (int i = 0; i < chars.length; i++) {
            a[chars[i]]++; // it increments the value in the index which is equal to char ascii value
        }

        for (Character c: chars) {
            if(a[c] == 1){
                return c;
            }
        }

        return null;
    }

    //   = 1, H = 1, d = 1, e = 1, l = 3, o = 2, r = 1, w = 1,
    private static void printFreq(char[] chars) {
        int[] freq = new int[256];
        for (int i = 0; i < chars.length; i++) {
            freq[chars[i]]++;
        }
        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0) {
                System.out.print((char)(i) + " = " + freq[i] + ", ");
            }
        }
    }
}
