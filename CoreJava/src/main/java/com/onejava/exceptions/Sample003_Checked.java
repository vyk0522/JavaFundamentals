package com.onejava.exceptions;

import java.io.IOException;

public class Sample003_Checked {
    public static void main(String[] args) {
        unChecked(); // Doesn't need to handle at compile time

        try {
            checked(); // Need to handle this. Else CTE
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("This will not run");
        

    }

    private static void unChecked() throws IllegalArgumentException {
        throw new IllegalArgumentException();
    }

    private static void checked() throws IOException {
        throw new IOException();
    }
}
