package com.onejava.patterns;

/*
When C implements A, B it inherits same method from A, B. It causes ambiguity(CTE)
To Resolve it, override m1()
A.super.m1(); // To invoke A's m1
 */
public class Diamond {
    public static void main(String[] args) {
        new C().m1();
    }
}

interface A{
    default void m1() {
        System.out.println("A");
    }
}

interface B{
    default void m1() {
        System.out.println("B");
    }
}

class C implements A, B{

    @Override
    public void m1() {
        System.out.println("C");
        A.super.m1();
        B.super.m1();
    }
}
