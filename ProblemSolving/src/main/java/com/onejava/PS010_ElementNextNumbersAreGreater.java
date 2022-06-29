package com.onejava;

import java.util.ArrayList;
import java.util.List;
/*
Element's next series of numbers should be greater than that number
Iterate from the backwards you will get a series to solve in O(n)
 */
public class PS010_ElementNextNumbersAreGreater {
    public static void main(String[] args) {
        int[] a = {3, 5, 2, 8, 7, 9, 11}; // 2, 7, 9
        System.out.println(elementNextNumbersAreGreater(a));

    }

    private static List<Integer> elementNextNumbersAreGreater(int[] a){
        List<Integer> list = new ArrayList<>();
        int min = a[a.length - 1];
        for (int i = a.length-2; i > 0 ; i--) {
            if(a[i] < min){
                list.add(0, a[i]);
                min = a[i];
            }
        }
        return list;
    }
}
