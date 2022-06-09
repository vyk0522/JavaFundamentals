package com.org;

import java.util.Arrays;
import java.util.Comparator;

public class Sample007_CandleHeight {
    public static void main(String[] args) {
        int[] a = {3,2,1,3};
        System.out.println(birthdayCakeCandles(a));

        //String s = "abc";
        // String s = "ab";
        String s = "abcd ab def abcdef abcdefgh sgsggs vgfdhed";
        String[] s1 = s.split(" ");
        String test = firstMaxEvenLengthString(s1);
        System.out.println(test);
        String test2 = firstMaxEvenLengthString2(s1);
        System.out.println(test2);
    }

    /*
    Count of max element in the list -- Max: 3 and Count: 2
     */
    private static int birthdayCakeCandles(int[] a) {
        int max = -1;
        int count = 0;
        for (int value : a) {
            if (value > max) {
                max = value;
                count = 1;
            } else if (value == max) {
                count++;
            }
        }
        return count;
    }

    private static String firstMaxEvenLengthString(String[] a) {
        String max = null;
        for (String s : a) {
            if (s.length() % 2 == 0) {
                if (max == null || max.length() < s.length()) {
                    max = s;
                }
            }
        }
        return max == null ? "00" : max;
    }


    private static String firstMaxEvenLengthString2(String[] a){
        return Arrays
                .stream(a)
                .filter(e -> e.length() % 2 == 0)
                .max(Comparator.comparingInt(String::length))
                .orElse("00");
    }


}
