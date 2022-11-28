package com.onejava.exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Sample007_Override {
    public static void main(String[] args) {
        Base base = new Child();
        try {
            base.m1();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        base.m2();
    }
}

class Base{
    public void m1() throws IOException {}

    public void m2() throws NumberFormatException {}

    public void m3() throws ArithmeticException{}

    public void m4() {}
}

class Child extends Base{
    @Override // You cannot throw Exception as it is higher than the Base class IOException
    public void m1() throws FileNotFoundException, IOException {}

    public void m2() throws RuntimeException{}

    public void m3() {}

    public void m4() throws RuntimeException{}
}
