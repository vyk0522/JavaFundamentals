package com.onejava.string;

public class String006_SwapStringWithoutTemp {
    public static void main(String[] args) {
        String s1 = "visa";
        String s2 = "mastercard";
        s1 = s2.concat(s1); // mastercardvisa
        s2 = s1.substring(s2.length());
        s1 = s1.substring(0, s1.indexOf(s2));
        System.out.println("S2: " + s2);
        System.out.println("S1: " + s1);
    }
}
