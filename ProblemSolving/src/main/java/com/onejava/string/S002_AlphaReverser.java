package com.onejava.string;

/*
    Reverses only the alphabetic characters in the string.
    Non-alphabet characters (digits, symbols, etc.) remain fixed in their positions.

    A. Use two pointers.
    B. If non letter character, skip to the next one on both sides
    C. Swap if both are letter character.
 */
public class S002_AlphaReverser {
    public static void main(String[] args) {
        String input1 = "A1b2C3_D$E%F&G";
        String output1 = alphaReverser(input1);
        System.out.println(output1);

        String input2 = "abcD123xyz";
        String output2 = alphaReverser(input2);
        System.out.println(output2);
    }

    /*
     * Reverses only the alphabetic characters in the string.
     * Non-alphabet characters (digits, symbols, etc.) remain fixed in their positions.
     *
     * Uses a two-pointer approach:
     *  - Move left pointer forward until it finds a letter.
     *  - Move right pointer backward until it finds a letter.
     *  - Swap the letters and continue until both pointers meet.
     */
    private static String alphaReverser(String input) {
        char[] a = input.toCharArray();
        int i = 0;
        int j = input.length() - 1;

        while (i < j) {
            // Skip non-letter characters on the left
            if (!Character.isLetter(a[i])) {
                i++;
                continue;
            }

            // Skip non-letter characters on the right
            if (!Character.isLetter(a[j])) {
                j--;
                continue;
            }

            // Both sides have letters → swap them
            swap(a, i, j);
            i++;
            j--;
        }

        return new String(a);
    }

    /*
     * Swaps two characters in the array.
     */
    private static void swap(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
