package com.onejava.string;

import java.util.Objects;

import static com.onejava.string.String002_Reverse.reverse;

public class String003_Palindrome {
    public static void main(String[] args) {
        String s2 = "madam";
        String s3 = "abc";
        System.out.println("palindrome is true? " + isPalindromeUsingReverse(s2));
        System.out.println("palindrome is true? " + isPalindromeUsingReverse(s3));
        System.out.println("palindrome with pointer: " + isPalindromeUsingPointer(s2));
        System.out.println("palindrome with pointer: " + isPalindromeUsingPointer(s3));

        System.out.println("palindrome by changing char abbi: " + isPalindromeByChangingExactlyOneChar("abbi")); // true
        System.out.println("palindrome by changing char abbia: " + isPalindromeByChangingExactlyOneChar("abbiab")); // false
        System.out.println("palindrome by changing char madam: " + isPalindromeByChangingExactlyOneChar("madam")); // true
        System.out.println("palindrome by changing char dood: " + isPalindromeByChangingExactlyOneChar("dood")); // false
    }

    private static boolean isPalindromeByChangingExactlyOneChar(String word){
        int i = 0;
        int j = word.length() - 1;
        int mismatch = 0;
        while(i < j){
            if(word.charAt(i) != word.charAt(j)){
                mismatch++;
            }
            i++;
            j--;
        }
        if(mismatch == 1) return true;

        if(mismatch > 1) return false;

        // mismatch == 0
        //Changing 1 character in an odd-length palindrome means you can modify
        // the middle character and keep it a palindrome.
        // Changing 1 character in an even-length palindrome always breaks symmetry.
        return word.length() % 2 != 0;
    }

    private static boolean isPalindromeUsingReverse(String s2) {
        return Objects.equals(s2, reverse(s2));
    }

    private static boolean isPalindromeUsingPointer(String s1) {
        int i = 0;
        int j = s1.length() - 1;
        while(i < j){
            if(s1.charAt(i) != s1.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
