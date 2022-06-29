package com.onejava;

import java.util.Arrays;

// Given input range 1 to 500
public class PS013_NumberAndFrequencies {
    public static void main(String[] args) {
        int[] countArray = new int[501];
        int[] a = {1, 22, 5, 22, 5, 2, 3, 488, 500};

        for (int i=0; i < a.length; i++){
            countArray[a[i]]++;
        }
        // System.out.println(Arrays.toString(countArray));

        for (int i = 0; i < countArray.length; i++) {
            if (countArray[i] > 0) {
                System.out.println("[" + i + "] = " + countArray[i]);
            }
        }
    }
}
