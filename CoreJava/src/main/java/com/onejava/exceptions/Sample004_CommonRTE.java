package com.onejava.exceptions;

public class Sample004_CommonRTE {
    public static void main(String[] args) {
        int result = 5 / 0;  // AE

        int[] a = new int[1];
        System.out.println(a[1]); // AIOBE

        String s1 = "1";
       //  Integer i = (Integer) s1; // CCE. Simple so fails at Compile time
        Object obj = s1;
        Integer i = (Integer) obj;  // CCE

        String s2 = null;
        s2.toLowerCase();  // NPE

        Integer number = Integer.parseInt("1a"); // NFE

        int age = 15;
        if(age < 21){
            // Usually you throw this exception rather than handling it
            // You fix the data or input to prevent this exception
            throw new IllegalArgumentException("Age can not be less than 21");
        }

        boolean isSwitchedOn = false;
        if(!isSwitchedOn){
            throw new IllegalStateException("It should be switched on");
        }


     }
}
