package com.onejava.Stream;

public class Stream005_FunctionalInterface {
    public static void main(String[] args) {
        A a = new B();
        a.m1();
        a.m3();
        A.m4();
       // B.m4();  // CTE
    }


}

interface A{
    String text = "Static M4";

    void m1();

    private void m2(){
        System.out.println("Private M2");
    }

    default void m3(){
        System.out.println("A - Default M3");
    }

    static void m4(){
        System.out.println(text);
    }

}

class B implements A{

    @Override
    public void m1() {
        System.out.println("B - M1 Implementation");
    }

    public void m3(){
        System.out.println("B - M3 Override");
    }
}