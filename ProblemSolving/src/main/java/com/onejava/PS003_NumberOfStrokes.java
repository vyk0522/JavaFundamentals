package com.onejava;

/*
Paint a wall of blocks. Blocks are of same width but different height. Given an array which has heights of consecutive blocks as elements
Ex: [1, 3, 2, 1, 2, 1, 5, 3, 3, 4, 2]
We need to do continuous horizontal strokes. Every horizontal stroke is 1 unit.
Find minimum number of horizontal strokes needed?
 */
public class PS003_NumberOfStrokes {
    public static void main(String[] args) {
        System.out.println(minimumNumberOfStrokes(new int[]{1, 3, 2, 1, 2, 1, 5, 3, 3, 4, 2})); // 9
        System.out.println(minimumNumberOfStrokes(new int[]{5, 8})); // 8
        System.out.println(minimumNumberOfStrokes(new int[]{1, 1, 1, 1})); // 1
    }

    /*
    a[0] element makes first count.
    Only if current element is greater than previous element, add the difference to final count.
    It will be easily understood if you write blocks and strike the blocks which is continuous
     */
    public static int minimumNumberOfStrokes(int[] a) {
        int max = 1000000000;
        int count = a[0];
        for (int i = 1; i < a.length; i++) {
            int difference = a[i] - a[i-1];
            if (difference > 0){
                if (max - count < difference){
                    return -1;
                }
                count = count + difference;
            }
        }
        return count;
    }
}
