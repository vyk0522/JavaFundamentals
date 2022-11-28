package com.onejava.exceptions;

import java.io.IOException;

public class Sample006_Throw {

    public static void main(String[] args) {
        Util util = new Util();
        try {
            util.checked(20);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            util.checkedImpl(20);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}

class Util {
    void checked(int age) throws IOException {
    }

    void unChecked(int age) throws IllegalArgumentException {
    }

    // Throws or try catch is mandatory
    void checkedImpl(int age) throws IOException {
        throw new IOException();
    }

    void unCheckedImpl(int age) {
        throw new IllegalArgumentException();
    }
}
