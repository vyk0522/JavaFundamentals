package com.onejava.string;

public class String007_ReverseAlphabets {
    public static void main(String[] args) {
        String s1 = "ab12cde%$!5xyz1ghyz";
        System.out.println(s1);
        System.out.println(reverseAlphabets(s1));

    }

    private static String reverseAlphabets(String str){
        char[] chars = str.toCharArray();
        int i = 0;
        int j = str.length() - 1;

        while(i < j){
            if(!Character.isLetter(chars[i])){
                i++;
                continue;
            }
            if(!Character.isLetter(chars[j])){
                j--;
                continue;
            }
            swap(chars, i, j);
            i++;
            j--;
        }
        return new String(chars);
    }

    private static void swap(char[] a, int i, int j){
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


}
