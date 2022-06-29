package com.org;

import java.util.HashSet;

/*
String with N lower case letters. Return minimum number of letters that must be deleted to obtain a word with unique occurrence.

Store each character's frequency as array element in its index. Ex: a's index is 0 and z's index is 26
Iterate each element - if value is greater than 1 and already present in set.. decrement until you get the unique value.. and add that unique value to set
Calculate each decrement counter
 */
public class A004_MinimumNumToDelete {
    public static void main(String[] args) {
        System.out.println(minDeletions("aaaabbbb")); // 4 4 > 4 3 > 1
        System.out.println(minDeletions("ccaaffddecee")); // 33222
        System.out.println(minDeletions("eeee"));
        System.out.println(minDeletions("example")); // 2 1 1 1 1 1
    }

    public static int minDeletions(String s) {
        int[] a = new int[26];
        int result = 0;
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            a[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            while (a[i] > 0 && set.contains(a[i])) {
                a[i]--;
                result++;
            }
            set.add(a[i]);
        }

        return result;

    }
}
