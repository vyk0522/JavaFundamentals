package com.org;

public class A007_Test {
    public static void main(String[] args) {
        String text = "abdfdfsfdffdf";
        String note = "ab";
        System.out.println(canConstructLetter(text, note));
    }

    public static boolean canConstructLetter(String text, String note) {
        int a[] = new int[26];
        text = text.replaceAll("[^a-z]", "");
        note = note.replaceAll("[^a-z]", "");
        for (int i = 0; i < text.length(); i++) {
            a[text.charAt(i) - 'a']++;
        }
        for (int i = 0; i < note.length(); i++) {
            if (a[note.charAt(i) - 'a'] > 0){
                a[note.charAt(i) - 'a']--;
            }
            else if (a[note.charAt(i) - 'a'] == 0){
                return false;
            }

        }
        return true;

    }
}
