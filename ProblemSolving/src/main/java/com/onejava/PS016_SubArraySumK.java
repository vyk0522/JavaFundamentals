package com.onejava;

import java.util.HashMap;

public class PS016_SubArraySumK {
    public static void main(String[] args) {
        int[] a = {1, 1, 1};
        int k = 2;
        System.out.println(subArraySumCount(a, k));
    }

    //  if sum[i] - sum[j] = k, the sum of elements lying between indices i and j is k.
    private static int subArraySumCount(int[] a, int k) {
        int count = 0, sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < a.length; i++) {
           sum = sum + a[i];
           if (map.containsKey(sum - k)){
                count = count + map.get(sum - k);
            }
           map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
