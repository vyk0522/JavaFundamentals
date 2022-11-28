package com.onejava.exceptions;

public class Sample005_Error {
    public static void main(String[] args) {
        try {
            new Calc(); // ExceptionInInitializerError
        } catch (Throwable t) {
            System.out.println(t);
        }

        // NoClassDefFoundError
        new Calc(); // This class is not available as it is not initialised properly. Java wont try again.

    }

    public static class Calc{
        static int i = 10/0;
    }

}
