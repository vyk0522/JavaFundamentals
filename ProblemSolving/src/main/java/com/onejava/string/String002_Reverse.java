package com.onejava.string;

import java.util.StringJoiner;

/*
To reverse a string insert character at 0th position instead of appending it to existing string
 */
public class String002_Reverse {
    public static void main(String[] args) {
        System.out.println(reverseByInsertingAtFirstIndex("vivek"));
        System.out.println(reverse("vivek"));

        System.out.println(reverseUsingSwap("viveks"));
        System.out.println(reverseUsingSwapWithTwoPointers("vivek"));

        String s1 = "One Two Three";
        System.out.println(reverseWordWise(s1.toCharArray()));
        System.out.println(reverseWordWiseWithSplit(s1));

        int n = 'a';
        System.out.println(n); // 97
        char c = 'a' + 1;
        System.out.println(c); // b

        boolean b = characterExistsInRange('a');
        System.out.println(b); // true
        boolean b2 = characterExistsInRange('A');
        System.out.println(b2); // false

    }

    private static String reverseWordWiseWithSplit(String s1) {
        String[] strings = s1.split(" ");
        StringJoiner sj = new StringJoiner(" ");
        StringBuilder builder = new StringBuilder();
        for(String str : strings){
            builder.insert(0, str);
        }
        // Extra way started
        for (int i = strings.length - 1; i >= 0; i--) {
            sj.add(strings[i]);
        }
        System.out.println(sj);
        // Extra way ended
        return builder.toString();
    }

    private static boolean characterExistsInRange(Character c){
        if (c >= 'a' && c<= 'z'){
            return true;
        }
        return false;
    }

    public static String reverse(String input){
        String reverse = "";
        for (int i = 0; i < input.length(); i++) {
            reverse = input.charAt(i) + reverse;
        }
        return reverse;
    }

    private static String reverseUsingSwap(String input){
        char[] chars = input.toCharArray();
        int n = chars.length;
        for (int i = 0; i < n /2; i++) {
            swap(chars, i, n - i - 1);
        }
        return new String(chars);
    }

    private static String reverseUsingSwapWithTwoPointers(String input){
        char[] chars = input.toCharArray();
        int i = 0;
        int j = input.length() - 1;
        while(i < j){
            swap(chars, i, j);
            i++;
            j--;
        }
        return new String(chars);
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    private static String reverseByInsertingAtFirstIndex(String input){
        StringBuilder s1 = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            s1.insert(0, input.charAt(i));
        }
        return s1.toString();
    }

    private static String reverseWordWise(char[] chars){
        // reverse whole array
        reverse(chars, 0, chars.length - 1);

        // reverse individual word
        int i =0;
        for (int j = 0; j < chars.length; j++) {
            if (chars[j] == ' '){
                reverse(chars, i, j-1);
                i = j+1;
            }
        }
        // reverse last part
        reverse(chars, i, chars.length - 1);

        return new String(chars);
    }

    private static void reverse(char[] a, int i, int j) {
        while(i < j){
            swap(a, i, j);
            i++;
            j--;
        }
    }
}
