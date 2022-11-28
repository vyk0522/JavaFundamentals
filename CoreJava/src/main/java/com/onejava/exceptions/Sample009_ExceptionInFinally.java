package com.onejava.exceptions;

import java.io.IOException;

public class Sample009_ExceptionInFinally {
    public static void main(String[] args) {
        try{
            throw new IllegalArgumentException("A");
        }

        finally {
            throw new NumberFormatException("B");
        }
    }
}
