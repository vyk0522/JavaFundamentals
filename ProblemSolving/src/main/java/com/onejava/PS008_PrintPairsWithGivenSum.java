package com.onejava;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Get complement value(sum - a[i]) and if complement value is present in map, fetch its value and add it to count.
Use hashmap to store element and its frequency
 */
public class PS008_PrintPairsWithGivenSum {
    public static void main(String[] args) {
        int[] a = {1, 5, 7, -1, 5};
        int k = 6;
        printPairs(a, k); // 3 pairs
        printPairs2(a, k);

        int[] b = {1, 1, 1, 1};
        k = 2;
        printPairs(b, k); // 6 pairs

        int[] c = {2, 7, 11, 15};
        k = 9;
        int[] sum = twoSum(c, k);
        System.out.println(Arrays.toString(sum)); // index of two numbers whose sum is k [0, 1]
    }

    private static void printPairs(int[] a, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int pairs = 0;

        for (int i = 0; i < a.length; i++) {
            Integer complement = k - a[i];
            if (map.containsKey(complement)) {
                Integer frequency = map.get(complement);
                pairs = pairs + frequency;
                for (int j = 0; j < frequency; j++) {
                    System.out.println("(" + a[i] + "," + complement + ")");
                }
            }

            Integer frequency = map.get(a[i]);
            frequency = frequency == null ? 1 : ++frequency;
            map.put(a[i], frequency);
        }

        System.out.println("Total pairs: " + pairs);
    }

    private static int[] twoSum(int[] a, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < a.length; i++) {
            int complement = k - a[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(a[i], i);
        }

        throw new IllegalArgumentException("No Two Sum Solution");

    }

    // Sort and use two pointers
    public static void printPairs2(int a[], int sum) {
        Arrays.sort(a);

        int i = 0;
        int j = a.length - 1;

        while (i < j) {
            if (a[i] + a[j] == sum) {
                System.out.println("(" + a[i] + "," + a[j] + ")");
            }
            if (a[i] + a[j] > sum) {
                j--;
            } else {
                i++;
            }
        }
    }
}
