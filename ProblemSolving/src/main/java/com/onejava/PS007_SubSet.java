package com.onejava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PS007_SubSet {
    public static void main(String[] args) {
        Integer[] nums = new Integer[]{1, 2, 3};
        Character[] chars = new Character[]{'a', 'b', 'c'};
        System.out.println(subsets(nums));
        System.out.println(subsets1(chars));
    }

    /*
    When iterating 1st element > []         [1]
    When iterating 2nd element > [][1]      [2][1,2]
    When iterating 3rd element > [][1][2][1,2]   [3][1,3][2,3][1,2,3]
    Initially result wil have one list, retrieve the list and add current element and add new list to result
    if result has two list - retrieve the list and add current element to both list and add the new two lists to result.

    TC: O(n*2^n)
     */
    public static <T> List<List<T>> subsets(T[] nums) {
        return iterativeApproach(nums);
    }

    public static <T> List<List<T>> subsets1(T[] nums) {
        return backTrackingApproach(nums);
    }

    private static <T> List<List<T>> iterativeApproach(T[] nums) {
        List<List<T>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for(T num : nums){
            int size = result.size();
            for (int i = 0; i < size; i++) {
                List<T> list = new ArrayList<>(result.get(i));
                list.add(num);
                result.add(list);
            }
        }
        return result;
    }

    private static <T> List<List<T>> backTrackingApproach(T[] nums) {
        List<List<T>> result = new ArrayList<>();
        generateSubsets(0, nums, new ArrayList<T>(), result);
        return result;
    }

    private static <T> void generateSubsets(int index, T[] nums,
                                            ArrayList<T> current, List<List<T>> result) {
        result.add(new ArrayList<>(current));

        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);
            generateSubsets(i + 1, nums, current, result);
            current.remove(current.size() - 1);
        }

    }
}
